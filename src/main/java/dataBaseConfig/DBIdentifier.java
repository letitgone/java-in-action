//package dataBaseConfig;
//
///**
// * 数据库标识管理类。用于区分数据源连接的不同数据库。
// *
// */
//public class DBIdentifier {
//
//    /**
//     * 用不同的工程编码来区分数据库
//     */
//    private static ThreadLocal<String> projectCode = new ThreadLocal<String>();
//
//    public static String getProjectCode() {
//        return projectCode.get();
//    }
//
//    public static void setProjectCode(String code) {
//        projectCode.set(code);
//    }
//}