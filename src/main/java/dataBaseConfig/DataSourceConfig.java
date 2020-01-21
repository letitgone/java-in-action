//package dataBaseConfig;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//
///**
// * 数据源配置管理。
// *
// */
//@Configuration
//@SuppressWarnings("all")
//public class DataSourceConfig {
//
//    /**
//     * 根据配置参数创建数据源。使用派生的子类。
//     *
//     * @return 数据源
//     */
//	@Bean(name="dataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource getDataSource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.type(DynamicDataSource.class);
//        return builder.build();
//    }
//
//}