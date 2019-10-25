package http.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 用于模拟HTTP请求中GET/POST方式
 */
@SuppressWarnings("all")
public class HttpUtils {
    /**
     * 发送GET请求
     *
     * @param url
     *            目的地址
     * @param parameters
     *            请求参数，Map类型。
     * @return 远程响应结果
     */
    public static String sendGet(String url, Map<String, String> parameters, Map<String, String> requestHeaders) {
        String result="";
        BufferedReader in = null;// 读取响应输入流
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数
            if (parameters == null) {
            } else if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                        java.net.URLEncoder.encode(parameters.get(name),
                            "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {
                    sb.append(name).append("=").append(
                        java.net.URLEncoder.encode(parameters.get(name),
                            "UTF-8")).append("&");
                }
                String temp_params = sb.toString();
                params = temp_params.substring(0, temp_params.length() - 1);
            }
            String full_url = params == "" ? url : (url + "?" + params);
            System.out.println(full_url);
            // 创建URL对象
            java.net.URL connURL = new java.net.URL(full_url);
            // 打开URL连接
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL
                .openConnection();
            // 设置通用属性
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            // 增加headers
            if (requestHeaders != null) {
                Set<String> keySet = requestHeaders.keySet();
                for (String k : keySet) {
                    httpConn.setRequestProperty(k, requestHeaders.get(k));
                }
            }
            // 建立实际的连接
            httpConn.connect();
            // 响应头部获取
            Map<String, List<String>> headers = httpConn.getHeaderFields();
            // 遍历所有的响应头字段
            //            for (String key : headers.keySet()) {
            //                System.out.println(key + "\t：\t" + headers.get(key));
            //            }
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式
            in = new BufferedReader(new InputStreamReader(httpConn
                .getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result ;
    }

    //post请求   传入url和json串
    public static String sendPost (String url , String json, Map<String, String> requestHeaders) throws Exception{
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json; charset=UTF-8");
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000)
            .setConnectTimeout(30000).build();
        post.setConfig(requestConfig);
        // 增加headers
        if (requestHeaders != null) {
            Set<String> keySet = requestHeaders.keySet();
            for (String k : keySet) {
                post.addHeader(k, requestHeaders.get(k));
            }
        }
        post.setEntity(new StringEntity(json, "UTF-8"));
        HttpResponse response = HttpClientBuilder.create().build().execute(post);
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        return content;
    }

    //post请求   传入url和json串
    public static String sendPost (String url , Map map, Map<String, String> requestHeaders) throws Exception{
        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json; charset=UTF-8");
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000)
            .setConnectTimeout(30000).build();
        post.setConfig(requestConfig);
        // 增加headers
        if (requestHeaders != null) {
            Set<String> keySet = requestHeaders.keySet();
            for (String k : keySet) {
                post.addHeader(k, requestHeaders.get(k));
            }
        }
        post.setEntity(new StringEntity(JSON.toJSONString(map), "UTF-8"));
        HttpResponse response = HttpClientBuilder.create().build().execute(post);
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        return content;
    }

    public static void sendPostCurl(String url, Map<String, String> parameters, Map<String, String> requestHeaders) throws Exception {


        List<String> cmds = new ArrayList();
        cmds.add("curl");
        cmds.add("-X");
        cmds.add("POST");
        cmds.add(url);

        //配置headers
        // 一定要去掉！！！ 否则收不到值
        // cmds.add("-H");
        // cmds.add("Content-Type:application/json");
        if (requestHeaders != null) {
            Set<String> keySet = requestHeaders.keySet();
            for (String k : keySet) {
                cmds.add("-H");
                cmds.add(k + ":" + requestHeaders.get(k));
            }
        }

        // 配置参数
        StringBuffer sb = new StringBuffer();// 存储参数
        String params = "";// 编码之后的参数
        for (String name : parameters.keySet()) {
            sb.append(name).append("=").append(
                java.net.URLEncoder.encode(parameters.get(name),
                    "UTF-8")).append("&");
        }
        String temp_params = sb.toString();
        params = temp_params.substring(0, temp_params.length() - 1);
        if (params != "") {
            cmds.add("--data");
            cmds.add(params);
        }
        String[] s1 = cmds.toArray(new String[cmds.size()]);
        for (String tem: s1) {
            System.out.println(tem);
        }

        execCurl(cmds);
        System.out.println("========---------------============== results ===========-----------======================");
    }

    public static void execCurl(List<String> cmds){
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line=br.readLine())!=null){
                System.out.println("\t"+line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 主函数，测试请求
     *
     * @param args
     */
    public static void main(String[] args) {
        String url = "https://center.essocloud.com/api/config/list";
        String jsonString = "{\n" + "    \"list\": [\n" + "        {\n"
            + "            \"key\": \"back_leader\",\n" + "            \"value\": \"2\"\n"
            + "        },\n" + "        {\n" + "            \"key\": \"workorder_request_clock\",\n"
            + "            \"value\": \"1\"\n" + "        }\n" + "    ]\n" + "}";
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization",
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjVmMTQ4ZDRkN2JiM2JmYWEzOGZmMzg3NThlOGNlMWMyYTRiMGNiNmE1NzhjMDU1ZWE3ZmE5YzI3ZWMzNGY2MGM5YzJmMDM3Y2RlZjkwNzFiIn0.eyJhdWQiOiIxIiwianRpIjoiNWYxNDhkNGQ3YmIzYmZhYTM4ZmYzODc1OGU4Y2UxYzJhNGIwY2I2YTU3OGMwNTVlYTdmYTljMjdlYzM0ZjYwYzljMmYwMzdjZGVmOTA3MWIiLCJpYXQiOjE1NzE5ODIwMTEsIm5iZiI6MTU3MTk4MjAxMSwiZXhwIjoxNjAzNjA0NDExLCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.Ae3OcC9AnsK9trT4exHJ6zctDFQse4uTtzLJnzAico2UjZmT_m2uMcK-HktfNBzPcG6g5178WJ3wey0bG74PimuwvgLG50dM5CvHmhZHYBpl8oJW35utAjQ1zHA1atbxumV9Oh_3-YkR-f7B7p1UxRvX5IjVDCs-ADoT_rc4LQfK6XB-E4-Wz93k78uw9Yn-geBkB4h3I8Vj4IlM3rxWAsck7VeKPvUByra2-Zs9NOa2z3KjRmFryocQ4baeDeKIgvdUJELu06c3zp_9jCJBEPNfdSGElTdxiY4jiYo0XwHy2Kmd0mxVbfpIb5OqxXM5HkvZhIuOZiQDdAakc-ueI-eS7ts_yUEQ0AfgaDMXIXBSH-bVKuGDSw4vdV4rWXmMegRtnuOgeXi52ivIcNvIHMVONIOVlm4ms3bPY-fohIXhxhrXBYjQ4BnPCgjLnhtPOWCUaKi64qn-LjXx_EEtx3YJvygeuV9wsm3UHfJu0oePgirJzS0DUEuV-ra42alLGxd0AahXMr_6Kim776qNUVdOvMgIu5uQBHAt8b-aKNc48mWITWonopA9K2U5l5l3rBvFoy4l7n95JtbsSM_0M9pqHT2jt0YpUDuh-hzKeOoW6g1kJLMM3gytxlgsunO6oE47GqYmGzeEC788Dv3MRKQHsLOWQWv_cLBxE-XcB0o");
        requestHeaders.put("Database","xz13970086211");
        String result = null;
        try {
            result = sendPost(url, jsonString, requestHeaders);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Result Json====:" + result);

        //        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("app_key", "95c7850584c4af17e80a5c64");
//        parameters.put("master_secret", "3c3270a9c5f2ab4a76fd19f0");
//        parameters.put("message", "java测试");
//        parameters.put("messageType", "DDV测试");
//        parameters.put("pushId", "778899");
//        parameters.put("title", "jasodi");
//        parameters.put("pushtype", "2");
//        parameters.put("people", "U18311178699");
//
//        try {
//            String result = HttpUtils.sendPost("http://center.essocloud.com:31004/", JSON.toJSONString(parameters), null);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}
