/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impalapayapis;

/**
 *
 * @author fred 0720106420
 */
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ApiRequestMNO {

    private String url = "https://staging.impalapay.net/mnoTransfer";//the url to the Api endpoint e.g https://
    private String params = "{\n" +
                            "    \"api_username\": \"demo\",\n" +
                            "    \"session_id\": \"edf8d33d0e5c44bcba01fa68400e891c\",\n" +
                            "    \"source_country_code\": \"AU\",\n" +
                            "    \"sendername\": \"Joe Smith\",\n" +
                            "    \"recipient_mobile\": \"256733123456\",\n" +
                            "    \"amount\": \"0.1\",\n" +
                            "    \"recipient_currency_code\": \"UGX\",\n" +
                            "    \"recipient_country_code\": \"UG\",\n" +
                            "    \"reference_number\": \"AU321\",\n" +
                            "    \"sendertoken\": \"1514324567\",\n" +
                            "    \"client_datetime\": \"2014-06-11T13:54:27+03:00\"\n" +
                            "}"; //a valid json object containing the required parameters

    boolean retry;
    private Logger logger;
    private String dbname = "";

    public ApiRequestMNO(String url, String params) {
        super();
        this.url = url;
        this.params = params;
    }

    public String doPost() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        StringEntity entity;
        String out = "";

        try {
            entity = new StringEntity(params);
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(entity);
            HttpResponse response = httpclient.execute(httppost);

            // for debugging
            System.out.println(entity.getContentType());
            System.out.println(entity.getContentLength());
            System.out.println(EntityUtils.toString(entity));
            System.out.println(EntityUtils.toByteArray(entity).length);

            //System.out.println(           "----------------------------------------");

            System.out.println(response.getStatusLine());
            System.out.println(url);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            out = rd.readLine();
            JsonElement root = new JsonParser().parse(out);

            String specificvalue = root.getAsJsonObject().get("replace with key of the value to retrieve").getAsString();
            System.out.println(specificvalue);

            /**
             * String line = ""; while ((line = rd.readLine()) != null) {
             * //System.out.println(line); }
*
             */
            
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException for URL: '" + url
                    + "'");

            logger.error(ExceptionUtils.getStackTrace(e));
        } catch (ClientProtocolException e) {
            logger.error("ClientProtocolException for URL: '" + url + "'");
            logger.error(ExceptionUtils.getStackTrace(e));
        } catch (IOException e) {
            logger.error("IOException for URL: '" + url + "'");
            logger.error(ExceptionUtils.getStackTrace(e));
        }
        return out;
    }

}
