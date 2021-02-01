package liferayapi.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import liferayapi.constants.LifeRayApiPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import liferayapi.util.utilApi;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Torres
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.version=3.0",
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
    String response = "";
    List<String> responses=new ArrayList<String>();

    private Log log = LogFactoryUtil.getLog(this.getClass().getName());
    String groupCreated="";
    @ProcessAction(name = "addLayout")
    public String addLayout(ActionRequest actionRequest, ActionResponse actionResponse) {



        String urlGen="";
        String groupName="";
        String siteName="";
        //Obtener valores de add-layout.jsp
        String name = ParamUtil.getString(actionRequest, "name");
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");
        String type = ParamUtil.getString(actionRequest, "type");
        String typeSettings = ParamUtil.getString(actionRequest, "typeSettings");
        String parentSite = ParamUtil.getString(actionRequest, "parentSite");
        //------
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        String password = (String)request.getSession().getAttribute(WebKeys.CURRENT_URL);
        log.info("password" + password);

        // Validaciones
        if (type.equals("url")) {
            typeSettings = "url=" + typeSettings + "\n";
        }
        if (type.equals("embedded")) {
            typeSettings = "embeddedLayoutURL=" + typeSettings + "\n";
        } else {  typeSettings = "";  }
        //------

        //Consumir api para la creacion del layout (Entiendase como sitio)
        response = utilApi.addLayout(name, title, description, type, typeSettings,parentSite);

        //Obtener nombre del sitio creado en base a lo que se lleno en el form add-layout (agregar sitio)
        JSONObject obj = new JSONObject(response);
        siteName= obj.getString("friendlyURL");
        //Obtener nombre de parentSite en base al ID obtenido del form en add-group
        JSONObject obj2 = new JSONObject(utilApi.getGroupById(parentSite));
        groupName=obj2.getString("friendlyURL");

        //Construir url
        urlGen="http://localhost:8080/group"+groupName+siteName;
        log.info("Response Add Layout=" + response);
        //Mandar URL generada al view.jsp
        actionRequest.setAttribute("response", urlGen);
        responses.add(urlGen);
        return response;
    }
    //Crear grupo de paginas
    @ProcessAction(name="addGroup")
    public String addGroup(ActionRequest actionRequest, ActionResponse actionResponse){
        String name = ParamUtil.getString(actionRequest,"name");
        String description= ParamUtil.getString(actionRequest,"description");
        String parentGroup=ParamUtil.getString(actionRequest,"parentGroup");
        response = utilApi.addGroup(name,description,parentGroup);
        JSONObject obj = new JSONObject(response);
        log.info("Response Add Group=" + response);
        actionRequest.setAttribute("response",obj.getString("friendlyURL"));
        return response;
    }


    //Crear grupo de paginas
    @ProcessAction(name="getGroups")
    public String getGroups(){
        //Utilidad = LLenar los combos de los forms que requieren GroupId (Entiendase padre del sitio)

        //Obtengo los grupos por usuario
        JSONArray arr = new JSONArray(utilApi.getGroupsByUser());
        JSONArray jsonArrayOutput = new JSONArray();
        //Filtro los parametros y los meto en un JSON para su facil transporte entre .jsp
        for(int i = 0; i < arr.length(); i++){
            JSONObject finalxd=new JSONObject();
            finalxd.put("id",arr.getJSONObject(i).getString("groupId"));
            finalxd.put("name", arr.getJSONObject(i).getString("descriptiveName"));
            jsonArrayOutput.put(finalxd);
        }

        return jsonArrayOutput.toString();
    }

    @ProcessAction(name="reduceArray")
    public void reduceArray(ActionRequest request, ActionResponse response){
        System.out.println(ParamUtil.getString(request, "valueArray"));
    }

    //Mandar a view.jsp  as travez del render

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        PortletSession session = renderRequest.getPortletSession();

        utilApi.getToken(renderRequest,renderResponse);

        renderRequest.setAttribute("groups", getGroups());
        renderRequest.setAttribute("responses",responses);

        super.doView(renderRequest, renderResponse);

    }
}