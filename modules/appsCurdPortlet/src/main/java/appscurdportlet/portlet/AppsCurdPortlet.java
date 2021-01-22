package appscurdportlet.portlet;


import appscurdportlet.constants.AppsCurdPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import crudapps.model.CrudApps;
import crudapps.service.CrudAppsLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author Torres
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.version=3.0",
                "com.liferay.portlet.css-class-wrapper=appsCurdPortlet",
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=AppsCurd",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AppsCurdPortletKeys.APPSCURD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AppsCurdPortlet extends MVCPortlet {
    private Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @Reference
    CounterLocalService counterLocalService;

    @Reference
    CrudAppsLocalService crudAppsLocalService;

    @ProcessAction(name = "addApp")
    public void addApp(ActionRequest actionRequest, ActionResponse actionResponse) {
        long appId = counterLocalService.increment(CrudApps.class.getName());
        String description = ParamUtil.getString(actionRequest, "description");
        String url = ParamUtil.getString(actionRequest, "url");
        String title = ParamUtil.getString(actionRequest, "title");
        log.info(":V TESTEANDo");
        CrudApps apps = crudAppsLocalService.createCrudApps(appId);
        apps.setAppId(appId);
        apps.setDescription(description);
        apps.setTitle(title);
        apps.setUrl(url);
        crudAppsLocalService.addCrudApps(apps);


    }
    @ProcessAction(name = "addLayout")
    public void addLayout(ActionRequest actionRequest, ActionResponse actionResponse) {
        String name = ParamUtil.getString(actionRequest, "name");
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");
        log.info(":V TESTEANDo");


        Unirest.setTimeouts(0, 0);
        try {
            HttpResponse<String> response = Unirest.post("http://localhost:8080/api/jsonws/layout/add-layout")
                    .header("Authorization", "Basic dGVzdEB0ZXN0LmNvbTp4ZA==")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US; JSESSIONID=D419F9FAA91B268C059CE14D65E75A80")
                    .field("groupId", "20124")
                    .field("privateLayout", "true")
                    .field("parentLayoutId", "0")
                    .field("localeNamesMap", "{\"en_US\":\""+name+"\"}")
                    .field("localeTitlesMap", "{\"en_US\":\""+title+"\"}")
                    .field("descriptionMap", "{\"en_US\":\""+description+"\"}")
                    .field("keywordsMap", "{\"en_US\":\""+name+"\"}")
                    .field("robotsMap", "{\"en_US\":\""+name+"\"}")
                    .field("type", "portlet")
                    .field("typeSettings", "url=https://www.google.com\\nlayoutUpdateable=true")
                    .field("hidden", "false")
                    .field("friendlyURLMap", "{\"en_US\":\"/"+name+"\"}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }

    @ProcessAction(name = "updateApp")
    public void updateApp(ActionRequest actionRequest, ActionResponse actionResponse) {
        long appId = ParamUtil.getLong(actionRequest, "appId", GetterUtil.DEFAULT_LONG);
        String title = ParamUtil.getString(actionRequest, "title", GetterUtil.DEFAULT_STRING);
        String description = ParamUtil.getString(actionRequest, "description", GetterUtil.DEFAULT_STRING);
        String url = ParamUtil.getString(actionRequest, "url", GetterUtil.DEFAULT_STRING);

        CrudApps app = null;
        try {
            log.info("ID-"+appId);

            app = crudAppsLocalService.getCrudApps(appId);
        } catch (Exception e) {
            log.info("ID ee-"+appId);

            log.error(e.getCause(), e);
        }

        if (Validator.isNotNull(app)) {
            app.setTitle(title);
            app.setDescription(description);
            app.setUrl(url);
            crudAppsLocalService.updateCrudApps(app);
        }
    }

    @ProcessAction(name = "deleteApp")
    public void deleteApp(ActionRequest actionRequest, ActionResponse actionResponse) {
        long appId = ParamUtil.getLong(actionRequest, "appId", GetterUtil.DEFAULT_LONG);
        try {
            crudAppsLocalService.deleteCrudApps(appId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        List<CrudApps> appList = crudAppsLocalService.getCrudAppses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        renderRequest.setAttribute("appList", appList);
        super.render(renderRequest, renderResponse);
    }
}