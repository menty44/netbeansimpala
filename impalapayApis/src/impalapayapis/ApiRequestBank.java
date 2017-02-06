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

public class ApiRequestBank {

    private String url = "https://staging.impalapay.net/bankTransfer";//the url to the Api endpoint e.g https://
    private String params = "{\"api_username\":\"demo\",\"session_id\":\"7f458779f9b6428793b9 106d8450b58f\",\"source_country_code\":\"KE\",\"sendername\":\"eu genechimita\",\"recipient_mobile\":\"2347062988820\",\"recipien t_currency_code\":\"UGX\",\"recipient_country_code\":\"UG\",\"ref erence_number\":\"12345454\",\"bank_code\":\"KCBUG\",\"amount\":\"2 \",\"client_datetime\":\"656565\",\"sender_address\":\"nairobiken ya\",\"sender_city\":\"nairobi\",\"recipientname\":\"machetteeee\" ,\"accountnumber\":\"256715290374\"}"; //a valid json object containing the required parameters

    boolean retry;
    private Logger logger;
    private String dbname = "";

    public ApiRequestBank() {
        logger = Logger.getLogger(this.getClass());
    }

    public ApiRequestBank(String url, String params) {
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
