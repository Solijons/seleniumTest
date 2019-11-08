package RequestHandlers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Oauth {

    private String utils;
    private String token;

    public void getToken() throws Exception {
        HttpPost post = new HttpPost("https://test.com/as/token.oauth");
        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("client_id", "client_id"));
        urlParameters.add(new BasicNameValuePair("client_secret", "client_secret"));
        urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post)) {
                ObjectMapper objectMapper = new ObjectMapper();
                utils = EntityUtils.toString(response.getEntity());
                objectMapper.writeValue(new File("src/test/java/RequestHandlers/creds.json"), utils);

                JSONObject credsInJSON = new JSONObject();
                credsInJSON.put("data", utils);
                String unescapeJava = StringEscapeUtils.unescapeJava(credsInJSON.toString());
                String removeQoutes = unescapeJava.replace("\"{", "{");
                String finalStringText = removeQoutes.replace("}\"", "}");

                try (FileWriter file = new FileWriter("src/test/java/RequestHandlers/creds.json")) {
                    file.write(finalStringText);
                }
            }
    }

    public String readToken() throws Exception {
        JSONParser jsonParser = new JSONParser();
        Object object;
        try {
            object = jsonParser.parse(new FileReader("src/test/java/RequestHandlers/creds.json"));
            org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) object;

            org.json.simple.JSONObject data = (org.json.simple.JSONObject) jsonObject.get("data");
            token = (String) data.get("access_token");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return token;
    }
}
