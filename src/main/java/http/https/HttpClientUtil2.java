package http.https;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author ZhangGJ
 * @Date 2019/10/28
 */
public class HttpClientUtil2 {
    public static String doPost(String url, String json, Map<String, String> requestHeaders)
        throws Exception {
        HttpClient httpClient = new SSLClient();
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type" , "application/json; charset=UTF-8");
        RequestConfig requestConfig =
            RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(30000).build();
        post.setConfig(requestConfig);
        // 增加headers
        if (requestHeaders != null) {
            Set<String> keySet = requestHeaders.keySet();
            for (String k : keySet) {
                post.addHeader(k, requestHeaders.get(k));
            }
        }
        StringEntity se = new StringEntity(json);
        post.setEntity(se);
        //        HttpResponse response = HttpClientBuilder.create().build().execute(post);
        HttpResponse response = httpClient.execute(post);
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        return content;
    }

    public static void main(String[] args) {
        String url = "https://ifmproduct.essocloud.com/api/apiopen/login" ;
        String jsonStr = "" ;
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("appkey" , "5CD2FDC6F76F7A4L");
        requestHeaders.put("secretkey." , "$10$Nut7O5RLSls81s0OjCuytOJtnjVSbEi7qWwpBNju1BCwsgzFXIcm.");
        String httpOrgCreateTestRtn = null;
        try {
            httpOrgCreateTestRtn = HttpClientUtil2.doPost(url, jsonStr, requestHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=====================" + httpOrgCreateTestRtn);
    }
}
