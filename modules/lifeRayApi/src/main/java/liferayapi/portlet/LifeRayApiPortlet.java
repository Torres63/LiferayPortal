package liferayapi.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mashape.unirest.http.exceptions.UnirestException;
import liferayapi.constants.LifeRayApiPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Torres
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LifeRayApi",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LifeRayApiPortletKeys.LIFERAYAPI,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LifeRayApiPortlet extends MVCPortlet {
	String response="";
	@ProcessAction(name = "addLayout")
	public String addLayout(ActionRequest actionRequest, ActionResponse actionResponse) {
		String name = ParamUtil.getString(actionRequest, "name");
		String title = ParamUtil.getString(actionRequest, "title");
		String description = ParamUtil.getString(actionRequest, "description");


		response=utilApi.addLayout(name, title, description);
		return response;
	}
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String responseLayout= response;
		renderRequest.setAttribute("layouts",responseLayout);
		super.render(renderRequest, renderResponse);
	}
}