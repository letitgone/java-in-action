package web.plugins;

import dom.Dom4JUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.plugins.gen.CodeGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

    private static final Logger log = LoggerFactory.getLogger(GeneratorSqlmap.class);

//    @Autowired
//    private TableNameService tableNameService;

    public void generator() throws Exception{
        log.info("正在生成Mapper接口、mapper.xml、POJO");
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
    public void gen(String tableName) {
        try {
//            List<String> tableList = tableNameService.selectAllTableNameService(); //!tableList.contains(tableName)
            if(tableName == null || "".equals(tableName)){
                throw new Exception("请输入正确的数据库表名称！");
            }
            new Dom4JUtil().modifyXML(tableName);
            log.info("开始生成代码...");
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
            new CodeGenerator().genCode(tableName);
            log.info("全部代码生成完毕！");
        } catch (Exception e) {
            log.info("生成代码异常！");
            e.printStackTrace();
        }

    }

}
