package aop.aspect;

import aop.domain.ExceptionLogs;
import aop.domain.RequestLogs;
import aop.domain.ResponseLogs;
import aop.service.IExceptionLogsService;
import aop.service.IRequestLogsService;
import aop.service.IResponseLogsService;
import aop.utils.GenerateRandomChar;
import bytes.BytesUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author ZhangGJ
 * @Date 2019/11/04
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private IRequestLogsService requestLogsService;

    @Autowired
    private IResponseLogsService responseLogsService;

    @Autowired
    private IExceptionLogsService exceptionLogsService;

    @Pointcut("@annotation(com.pactera.manager.aop.annotation.ILogs)")
    public void logsAspect() {

    }

    @Before("logsAspect()")
    public void before(JoinPoint joinPoint) throws Exception{
        log.info("请求时间，请求JSON，请求方式，请求平台，请求IP，请求端口，请求URL，请求人");
        long token = GenerateRandomChar.timestamp();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute("log-token",  token);
        Object[] objects = joinPoint.getArgs();
        String json = "";
        for (int i = 0; i < objects.length; i++) {
            json += objects[i].toString();
        }
        JSONObject jsonObject =  JSON.parseObject(json);
        JSONObject basic = jsonObject.getJSONObject("basic");
        RequestLogs requestLogs = null;
        try {
            requestLogs = new RequestLogs.Builder().logToken(token).requestTime(DateUtils.timestampFormat(token)).requestJson(json)
                    .requestJsonByte(BytesUtils.transformToKB(json, "utf-8"))
                    .requestWay(request.getMethod())
                    .requestPlatform(basic.getString("requestPlatform"))
                    .requestUrl(request.getRequestURL().toString())
                    .requestOperator(basic.getString("requestOperator")).build();
        } catch (UnsupportedEncodingException e) {
            log.info("不支持UTF-8编码格式！");
            e.printStackTrace();
        }
        log.info(requestLogs.toString());
        requestLogsService.insertRequestLogs(requestLogs);
        log.info("Request log insert success!");
    }

    @AfterReturning(value = "logsAspect()", returning = "jsonObject")
    public void after(JoinPoint joinPoint, JSONObject jsonObject) throws Exception{
        log.info("响应时间，响应码，响应信息，响应JSON，请求响应时间差");
        long nowTime = GenerateRandomChar.timestamp();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long token = (long) request .getAttribute("log-token");
        ResponseLogs responseLogs = null;
        try {
            responseLogs = new ResponseLogs.Builder().logToken(token).responseTime(DateUtils.timestampFormat(nowTime))
                    .responseStatus(Integer.parseInt(jsonObject.getString("code")))
                    .responseInfo(jsonObject.getString("result"))
                    .responseJson(jsonObject.getString("body"))
                    .responseJsonByte(BytesUtils.transformToKB(jsonObject.getString("body"), "utf-8"))
                    .timeDifferent(nowTime - token)
                    .build();
        } catch (UnsupportedEncodingException e) {
            log.info("不支持UTF-8编码格式！");
            e.printStackTrace();
        }
        log.info(responseLogs.toString());
        responseLogsService.insertResponseLogs(responseLogs);
        log.info("Response log insert success!");
    }

    @AfterThrowing(value = "logsAspect()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        log.info("异常信息，栈轨迹");
        long nowTime = GenerateRandomChar.timestamp();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long token = (long) request.getAttribute("log-token");
        ExceptionLogs exceptionLogs = new ExceptionLogs.Builder()
                .exceptionInfo(e.toString())
                .exceptionTime(DateUtils.timestampFormat(nowTime))
                .LogToken(token)
                .stackTrack(e.toString())
                .build();
        log.info(exceptionLogs.toString());
        exceptionLogsService.insertExceptionLogs(exceptionLogs);
        log.info("Exception log insert success!");
    }
}