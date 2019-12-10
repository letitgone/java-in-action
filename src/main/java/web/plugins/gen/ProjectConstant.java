package web.plugins.gen;

/**
 * 项目常量
 */
public interface ProjectConstant {
    String BASE_PACKAGE = "com.pactera.template";//生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）

//    String MODEL_PACKAGE = BASE_PACKAGE + ".model";//生成的Model所在包
//    String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";//生成的Mapper所在包
    String SERVICE_PACKAGE = BASE_PACKAGE + ".service";//生成的Service所在包
    String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";//生成的ServiceImpl所在包
    String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";//生成的Controller所在包

//    String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";//Mapper插件基础接口的完全限定名

    int DATE_TIMESTAMP = 1;//时间戳
    int DATE_STRING = 2;//时间字符串
    int DATE_OBJ = 3;//时间对象


    public static final String IS_REMIND = "1";//低库存提醒开关默认值

    // 国际化是否被删除
    String IS_DELETED = "isDeleted";

    int CONSUMABLES_BZ=0;  //判断是否为备件
}
