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
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.scss",
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