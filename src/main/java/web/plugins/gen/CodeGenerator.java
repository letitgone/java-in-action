//package web.plugins.gen;
//
//import com.google.common.base.CaseFormat;
//import freemarker.template.TemplateExceptionHandler;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import static web.plugins.gen.ProjectConstant.*;
//
//
///**
// * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
// */
//public class CodeGenerator {
//
//    private static final Logger log = LoggerFactory.getLogger(CodeGenerator.class);
//
//    //JDBC配置，请修改为你项目的实际配置
//    private static final String JDBC_URL = "jdbc:mysql://114.115.180.38:3506/wxyxproduct?useSSL=false";
//    private static final String JDBC_USERNAME = "root";
//    private static final String JDBC_PASSWORD = "Seeyouagain2017.";
//    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
//
//    private static final String PROJECT_PATH = System.getProperty("user.dir");//项目在硬盘上的基础路径
//    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";//模板位置
//
//    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
//    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径
//
//    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
//    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
//    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径
//
//    private static final String AUTHOR = "hifm";//@author
//    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//@date
//
//    /**
//     * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。
//     * 如输入表名称 "t_user_detail" 将生成 TUserDetail、TUserDetailMapper、TUserDetailService ...
//     * @param tableName 数据表名称...
//     */
//    public static void genCode(String tableName) {
//        log.info("正在生成service、impl和Controller");
////        for (String tableName : tableNames) {
//        genCodeByCustomModelName(tableName, null);
////        }
//    }
//
//    /**
//     * 通过数据表名称，和自定义的 Model 名称生成代码
//     * 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User" 将生成 User、UserMapper、UserService ...
//     * @param tableName 数据表名称
//     * @param modelName 自定义的 Model 名称
//     */
//    public static void genCodeByCustomModelName(String tableName, String modelName) {
////        genModelAndMapper(tableName, modelName);
//        genService(tableName, modelName);
//        genController(tableName, modelName);
//    }
//
//    public static void genService(String tableName, String modelName) {
//        try {
//            freemarker.template.Configuration cfg = getConfiguration();
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("date", DATE);
//            data.put("author", AUTHOR);
//            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
//            data.put("modelNameUpperCamel", modelNameUpperCamel);
//            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
//            data.put("basePackage", BASE_PACKAGE);
//
//            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
//            if (!file.getParentFile().exists()) {
//                file.getParentFile().mkdirs();
//            }
//            cfg.getTemplate("service.ftl").process(data,
//                    new FileWriter(file));
//            log.info(modelNameUpperCamel + "Service.java 生成成功");
//
//            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
//            if (!file1.getParentFile().exists()) {
//                file1.getParentFile().mkdirs();
//            }
//            cfg.getTemplate("service-impl.ftl").process(data,
//                    new FileWriter(file1));
//            log.info(modelNameUpperCamel + "ServiceImpl.java 生成成功");
//        } catch (Exception e) {
//            throw new RuntimeException("生成Service失败", e);
//        }
//    }
//
//    public static void genController(String tableName, String modelName) {
//        try {
//            freemarker.template.Configuration cfg = getConfiguration();
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("date", DATE);
//            data.put("author", AUTHOR);
//            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
//            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
//            data.put("modelNameUpperCamel", modelNameUpperCamel);
//            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
//            data.put("basePackage", BASE_PACKAGE);
//
//            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
//            if (!file.getParentFile().exists()) {
//                file.getParentFile().mkdirs();
//            }
//            cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
//
//           log.info(modelNameUpperCamel + "Controller.java 生成成功");
//        } catch (Exception e) {
//            throw new RuntimeException("生成Controller失败", e);
//        }
//
//    }
//
//    private static freemarker.template.Configuration getConfiguration() throws IOException {
//        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
//        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
//        cfg.setDefaultEncoding("UTF-8");
//        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
//        return cfg;
//    }
//
//    private static String tableNameConvertLowerCamel(String tableName) {
//        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
//    }
//
//    private static String tableNameConvertUpperCamel(String tableName) {
//        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());
//
//    }
//
//    private static String tableNameConvertMappingPath(String tableName) {
//        tableName = tableName.toLowerCase();//兼容使用大写的表名
//        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
//    }
//
//    private static String modelNameConvertMappingPath(String modelName) {
//        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
//        return tableNameConvertMappingPath(tableName);
//    }
//
//    private static String packageConvertPath(String packageName) {
//        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
//    }
//
//}
