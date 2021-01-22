package liferayapi.portlet;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;
public class utilApi {
    public static String addLayout(String name,
                                   String title,
                                   String description)  {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = null;
        try {
            response = Unirest.post("http://localhost:8080/api/jsonws/layout/add-layout")
                    .header("Authorization", "Basic dGVzdEB0ZXN0LmNvbTp4ZA==")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Cookie", "GUEST_LANGUAGE_ID=en_US")
                    .field("groupId", "20124")
                    .field("privateLayout", "true")
                    .field("parentLayoutId", "0")
                    .field("localeNamesMap", "{\"en_US\":\" "+name+" \"}")
                    .field("localeTitlesMap", "{\"en_US\":\""+ title+"\"}")
                    .field("descriptionMap", "{\"en_US\":\""+description+"\"}")
                    .field("keywordsMap", "{\"en_US\":\""+name+"\"}")
                    .field("robotsMap", "{\"en_US\":\""+name+"\"}")
                    .field("type", "url")
                    .field("typeSettings", "url=https://www.google.com\\nlayoutUpdateable=true")
                    .field("hidden", "false")
                    .field("friendlyURLMap", "{\"en_US\":\"/"+name+"\"}")
                    .asString();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }
}
