package web.generator.controller;

import com.alibaba.fastjson.JSONObject;
import http.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author ZhangGJ
 * @Date 2020/01/01 18:23
 */
@Slf4j
@RestController
public class TestController {

    private final HttpServletRequest httpServletRequest;

    @Autowired
    public TestController(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @GetMapping("/health")
    public JSONObject health() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "UP");
        return jsonObject;
    }

    @PostMapping("test/asset/changeuser")
    public Integer test(@RequestBody JSONObject jsonObject) {
        String db = httpServletRequest.getHeader("db");
        String userid = httpServletRequest.getHeader("userid");
        String language = httpServletRequest.getHeader("language");
        return 1;
    }

    @GetMapping("api/health_v1")
    public String healths() {
        return "SUCCESS!";
    }

    @GetMapping("php/function")
    public String function() throws Exception {
        //        HttpUtils.sendGet("http://localhost:8203/Hifm-Server-Test/java/function", null, null);
        System.out.println("PHP开始调用Java");
        String result = HttpUtils.sendPost("http://localhost:8203/php","Hifm-Server-Test", null);
        return result;
    }

    @PostMapping("hello")
    public String hello(){
        log.info("Java call PHP success!");
        return "Java call PHP success!";
    }
}
