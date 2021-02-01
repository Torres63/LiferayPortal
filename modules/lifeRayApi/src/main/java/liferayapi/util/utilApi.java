package liferayapi.util;
import com.liferay.portal.kernel.portlet.DynamicActionRequest;
import com.liferay.portal.kernel.portlet.ProtectedActionRequest;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import javax.portlet.*;
import java.io.*;
import java.util.Base64;

public class utilApi {
    static String tokenV="";
    public static void getToken(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String username = themeDisplay.getUser().getEmailAddress();
        PortletSession session = renderRequest.getPortletSession();
        String token=username+":"+session.getAttribute(WebKeys.USER_PASSWORD,PortletSession.APPLICATION_SCOPE);
        token = Base64.getEncoder().encodeToString(token.getBytes());
        tokenV=token;
        session.setAttribute("token",token, PortletSession.APPLICATION_SCOPE);

    }
    public static String getGroupById(String id){
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response=null;
        try {
            response = Unirest.post("http://localhost:8080/api/jsonws/group/get-group")
                    .header("Authorization", "Basic "+tokenV)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US; JSESSIONID=A27FA9008EFB0635C84DDACDE863F4B4")
                    .field("groupId", id)
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }

    public static String getGroupsByUser(){
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;

        try {
             response = Unirest.get("http://localhost:8080/api/jsonws/group/get-user-sites-groups")
                    .header("Authorization", "Basic "+tokenV)
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US; JSESSIONID=D86B36244D806EADB8588C43B1C600B7")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
    public static String addGroup(String name,
                                  String description,
                                  String  parentGroup){

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post("http://localhost:8080/api/jsonws/group/add-group")
                    .header("Authorization", "Basic "+tokenV)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US")
                    .field("parentGroupId",parentGroup )
                    .field("liveGroupId", "0")
                    .field("nameMap", "{\"en_US\":\""+name+"\"}")
                    .field("descriptionMap", "{\"en_US\":\""+description+"\"}")
                    .field("type", "0")
                    .field("manualMembership", "true")
                    .field("membershipRestriction", "0")
                    .field("friendlyURL", "")
                    .field("site", "true")
                    .field("inheritContent", "false")
                    .field("active", "true")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return response.getBody();
    }
    public static String addLayout(String name,
                                   String title,
                                   String description,
                                   String type,
                                   String typeSettings,
                                   String parentGroup)  {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post("http://localhost:8080/api/jsonws/layout/add-layout")
                    .header("Authorization", "Basic "+tokenV)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US")
                    .field("groupId", parentGroup)
                    .field("privateLayout", "true")
                    .field("parentLayoutId", "0")
                    .field("localeNamesMap", "{\"en_US\":\" "+name+" \"}")
                    .field("localeTitlesMap", "{\"en_US\":\""+ title+"\"}")
                    .field("descriptionMap", "{\"en_US\":\""+description+"\"}")
                    .field("keywordsMap", "{\"en_US\":\""+name+"\"}")
                    .field("robotsMap", "{\"en_US\":\""+name+"\"}")
                    .field("type", type)
                    .field("typeSettings", typeSettings+"layoutUpdateable=true")
                    .field("hidden", "false")
                    .field("friendlyURLMap", "{\"en_US\":\"/"+name+"\"}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
