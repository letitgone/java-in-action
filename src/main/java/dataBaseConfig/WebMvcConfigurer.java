//package dataBaseConfig;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.hifm.consumable.core.ServiceException;
//import com.hifm.consumable.exception.HifmRuntimeException;
//import com.hifm.consumable.model.Entity.Result;
//import com.hifm.consumable.model.Entity.ResultCode;
//import com.hifm.consumable.utils.InternationalizationUtil;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.*;
//
///**
// * Spring MVC 配置
// */
//@Configuration
//@SuppressWarnings("all")
//public class WebMvcConfigurer extends WebMvcConfigurationSupport {
//
//    private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
//    @Value("${spring.profiles.active}")
//    private String env;//当前激活的配置文件
//
//    @Autowired
//    private HttpServletRequest request;
//
//    @Autowired
//    private InternationalizationUtil internationalizationUtil;
//
//    //使用阿里 FastJson 作为JSON MessageConverter
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect);
//        // WriteMapNullValue 保留为空的字段
//        //SerializerFeature.WriteNullStringAsEmpty,//String null -> ""
//        //SerializerFeature.WriteNullNumberAsZero//Number null -> 0
//        // DisableCircularReferenceDetect 循环引用 json
//        // 按需配置，更多参考FastJson文档哈
//
//        converter.setFastJsonConfig(config);
//        converter.setDefaultCharset(Charset.forName("UTF-8"));
//        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
//        converters.add(converter);
//    }
//
//
//    //统一异常处理
//    @Override
//    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        exceptionResolvers.add(new HandlerExceptionResolver() {
//            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
//                Result result = new Result();
//                if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
//                    result.setCode(ResultCode.FAIL).setError(e.getMessage());
//                    logger.info(e.getMessage());
//                } else if (e instanceof NoHandlerFoundException) {
//                    result.setCode(ResultCode.NOT_FOUND).setError("接口 [" + request.getRequestURI() + "] 不存在");
//                } else if (e instanceof ServletException) {
//                    result.setCode(ResultCode.FAIL).setError(e.getMessage());
//                } else if (e instanceof ConstraintViolationException) {
//                    result.setCode(ResultCode.FAIL).setError(getMessage((ConstraintViolationException) e));
//                    System.out.println(e.toString());
//                } else if (e instanceof HifmRuntimeException) {
//                    logger.error(e.getMessage(), e);
//                    result.setCode(ResultCode.FAIL).setError(e.getMessage());
//                } else if(e instanceof DuplicateKeyException){
//                    result.setCode(ResultCode.FAIL).setError(e.getMessage());
//                } else {
//                    result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setError("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
//                    String message;
//                    if (handler instanceof HandlerMethod) {
//                        HandlerMethod handlerMethod = (HandlerMethod) handler;
//                        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
//                                request.getRequestURI(),
//                                handlerMethod.getBean().getClass().getName(),
//                                handlerMethod.getMethod().getName(),
//                                e.getMessage());
//                    } else {
//                        message = e.getMessage();
//                    }
//                    logger.error(message, e);
//                }
//                responseResult(response, result);
//                return new ModelAndView();
//            }
//
//        });
//    }
//
//    //解决跨域问题
//    private CorsConfiguration addcorsConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        List<String> list = new ArrayList<>();
//        list.add("*");
//        corsConfiguration.setAllowedOrigins(list);
//        /*
//         * 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
//         */
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        return corsConfiguration;
//    }
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", addcorsConfig());
//        return new CorsFilter(source);
//    }
//
//    //添加拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HandlerInterceptorAdapter() {
//            @Override
//            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//                // 设置数据源
//                setDataSource();
//                //验证签名 微服务直接获取
//                // php主服务做了验证，微服务需要取到userid/language/db
//                // request.getHeader("userid/language/db")
//                // 设置本次请求的语言
//                setLanguage();
//                return true;
//            }
//        });
//    }
//
//    /**
//     * todo ---------------------------------------------------------------------------------------------------------------
//     * 设置数据源
//     **/
//    private void setDataSource () {
//        DBIdentifier.setProjectCode(request.getHeader("db"));
//        // DBIdentifier.setProjectCode("wxyxproFIFO");
//    }
//
//    private void setLanguage () {
//        Map locale = new HashMap();
//        locale.put("locale", internationalizationUtil.getLocale(request.getHeader("userid")));
//        // locale.put("locale", internationalizationUtil.getLocale("411"));
//        request.setAttribute("locale", locale);
//    }
//
//
//    private void responseResult(HttpServletResponse response, Result result) {
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-type", "application/json;charset=UTF-8");
//        response.setStatus(result.getCode());
//        try {
//            response.getWriter().write(JSON.toJSONString(result));
//        } catch (IOException ex) {
//            logger.error(ex.getMessage());
//        }
//    }
//
//    /**
//     * 一个简单的签名认证，规则：
//     * 1. 将请求参数按ascii码排序
//     * 2. 拼接为a=value&b=value...这样的字符串（不包含sign）
//     * 3. 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
//     */
//    private boolean validateSign(HttpServletRequest request) {
//        String requestSign = request.getParameter("sign");//获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
//        if (StringUtils.isEmpty(requestSign)) {
//            return false;
//        }
//        List<String> keys = new ArrayList<String>(request.getParameterMap().keySet());
//        keys.remove("sign");//排除sign参数
//        Collections.sort(keys);//排序
//
//        StringBuilder sb = new StringBuilder();
//        for (String key : keys) {
//            sb.append(key).append("=").append(request.getParameter(key)).append("&");//拼接字符串
//        }
//        String linkString = sb.toString();
//        linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);//去除最后一个'&'
//
//        String secret = "Potato";//密钥，自己修改
//        String sign = DigestUtils.md5Hex(linkString + secret);//混合密钥md5
//
//        return StringUtils.equals(sign, requestSign);//比较
//    }
//
//    private String getIpAddress(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        // 如果是多级代理，那么取第一个ip为客户端ip
//        if (ip != null && ip.indexOf(",") != -1) {
//            ip = ip.substring(0, ip.indexOf(",")).trim();
//        }
//
//        return ip;
//    }
//
//    /**
//     * 获取批量异常信息
//     * @param e
//     * @return
//     */
//    public static String getMessage(ConstraintViolationException e) {
//        List<String> msgList = new ArrayList<>();
//        if (e.getMessage() != null) {
//            msgList.add(e.getMessage());
//        } else {
//            for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
//                msgList.add(constraintViolation.getMessage());
//            }
//        }
//        String messages = StringUtils.join(msgList.toArray(), ";");
//        return messages;
//    }
//}
