package liferayapi.util;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;
public class utilApi {
    public static String getGroupsByUser(){
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;

        try {
             response = Unirest.get("http://localhost:8080/api/jsonws/group/get-user-sites-groups")
                    .header("Authorization", "Basic dGVzdEB0ZXN0LmNvbTpjZg==")
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
                    .header("Authorization", "Basic dGVzdEB0ZXN0LmNvbTpjZg==")
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
                    .header("Authorization", "Basic dGVzdEB0ZXN0LmNvbTpjZg==")
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
