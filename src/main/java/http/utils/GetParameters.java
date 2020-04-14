package http.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2020/04/14 14:19
 */
public class GetParameters {

    /**
     * 获取请求的参数
     * 问题：Get请求可以获取到，Post请求获取不到
     *
     * @param request
     * @return
     */
    public static  String getRequestParameter(HttpServletRequest request) {
        Map map = request.getParameterMap();
        String s = request.getParameter("name");
        Map<String, String> res = new HashMap<>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
            }
        }
        return res.toString();
    }
}
