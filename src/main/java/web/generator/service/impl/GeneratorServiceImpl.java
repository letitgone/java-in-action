package web.generator.service.impl;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.generator.domain.ColumnInfo;
import web.generator.domain.TableInfo;
import web.generator.mapper.GeneratorMapper;
import web.generator.service.IGeneratorService;
import web.generator.utils.GenUtils;
import web.generator.utils.StringUtils;
import web.generator.utils.VelocityInitializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author ZhangGJ
 * @Date 2019/10/24
 */
@Service
public class GeneratorServiceImpl implements IGeneratorService {
    private static final Logger log = LoggerFactory.getLogger(GeneratorServiceImpl.class);

    @Autowired
    private GeneratorMapper generatorMapper;

    /**
     * 查询数据库表信息
     * @param tableInfo
     * @return
     */
    @Override
    public List<TableInfo> tableInfoList(TableInfo tableInfo){
        return generatorMapper.tableInfoList(tableInfo);
    }

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public byte[] generatorCode(String tableName){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        // 查询表信息
        TableInfo table = generatorMapper.selectTableByName(tableName);
        // 查询列信息
        List<ColumnInfo> columns = generatorMapper.selectTableColumnsByName(tableName);
        // 生成代码
        generatorMethods(table, columns, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


    private void generatorMethods(TableInfo table, List<ColumnInfo> columns, ZipOutputStream zip) {
        // 表名转换成Java属性名
        //        String className = GenUtils.tableToJava(table.getTableName());
        // 驼峰命名
        String className = GenUtils.convertToCamelCase(table.getTableName());
        table.setClassName(className);
        table.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(GenUtils.transColums(columns));
        // 设置主键
        table.setPrimaryKey(table.getColumnsLast());

        VelocityInitializer.initVelocity();
        String packageName = "com.pactera.module";
        String moduleName = "module";
        VelocityContext context = GenUtils.getVelocityContext(table);

        // 获取模板列表
        List<String> templates = GenUtils.getTemplates();
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(GenUtils.getFileName(template, table, moduleName)));
                IOUtils.write(sw.toString(), zip, "UTF-8");
                IOUtils.closeQuietly(sw);
                zip.closeEntry();
            } catch (IOException e) {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
            }
        }
    }
}
