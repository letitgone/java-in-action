package web.generator.service;


import web.generator.domain.TableInfo;

import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2019/10/24
 */
public interface IGeneratorService {
    /**
     * 查询数据库表信息
     * @param tableInfo
     * @return
     */
    List<TableInfo> tableInfoList(TableInfo tableInfo);

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    byte[] generatorCode(String tableName);
}
