package liferayapi.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import liferayapi.constants.LifeRayApiPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

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
    private Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @ProcessAction(name = "addLayout")
    public String addLayout(ActionRequest actionRequest, ActionResponse actionResponse) {
        //Obtener valores de add-layout.jsp
        String name = ParamUtil.getString(actionRequest, "name");
        String title = ParamUtil.getString(actionRequest, "title");
        String description = ParamUtil.getString(actionRequest, "description");
        String type = ParamUtil.getString(actionRequest, "type");
        String typeSettings = ParamUtil.getString(actionRequest, "typeSettings");
        String parentSite = ParamUtil.getString(actionRequest, "parentSite");
        //------


        // Validaciones
        if (type.equals("url")) {
            typeSettings = "url=" + typeSettings + "\n";
        }
        if (type.equals("embedded")) {
            typeSettings = "embeddedLayoutURL=" + typeSettings + "\n";
        } else {  typeSettings = "";  }
        //------


        //Consumir api (Hacer configuraciones en base de datos)
        response = utilApi.addLayout(name, title, description, type, typeSettings,parentSite);
        JSONObject obj = new JSONObject(response);

        //Mandar respuesta a view.jsp (consultar linea 4)
        actionRequest.setAttribute("response", obj.getString("friendlyURL"));
        log.info("result=" + obj.getString("friendlyURL"));
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
        log.info("result=" + response);

        actionRequest.setAttribute("response",obj.getString("groupId"));
        return response;
    }

    //Crear grupo de paginas
    @ProcessAction(name="getGroups")
    public List<String> getGroups(){
        //  friendlyURL
        JSONArray arr = new JSONArray(utilApi.getGroupsByUser());
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < arr.length(); i++){
            list.add(arr.getJSONObject(i).getString("groupId"));

        }
        log.info("result LISTTTt=" + list);


        ArrayList<String[]> outerArr = new ArrayList<String[]>();
        String[] myString1= {};

        for(int i = 0; i < arr.length(); i++){
            list.add(arr.getJSONObject(i).getString("groupId"));
            myString1= new String[]{arr.getJSONObject(i).getString("groupId"),
                    arr.getJSONObject(i).getString("descriptiveName")};
            outerArr.add(myString1);

        }

        return list;
    }
    //Crear grupo de paginas
    @ProcessAction(name="getGroups2")
    public ArrayList<String[]> getGroups2(){
        JSONArray arr = new JSONArray(utilApi.getGroupsByUser());

        ArrayList<String[]> outerArr = new ArrayList<String[]>();
        String[] myString1= {};

        for(int i = 0; i < arr.length(); i++){
            myString1= new String[]{arr.getJSONObject(i).getString("groupId"),
                    arr.getJSONObject(i).getString("descriptiveName")};
            outerArr.add(myString1);

        }
        for (String[] arr2 : outerArr) {
            System.out.println();
            log.info("result XD=" +Arrays.toString(arr2));

        }

        return outerArr;
    }


    //Mandar a view.jsp  as travez del render, (consultar linea 5)

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        renderRequest.setAttribute("my_array", getGroups());
        renderRequest.setAttribute("my_array2", getGroups2());

        super.doView(renderRequest, renderResponse);
    }
}