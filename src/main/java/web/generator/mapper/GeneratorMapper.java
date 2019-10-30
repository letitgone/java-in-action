package web.generator.mapper;

import org.springframework.stereotype.Repository;
import web.generator.domain.ColumnInfo;
import web.generator.domain.TableInfo;

import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2019/10/24
 */
@Repository
public interface GeneratorMapper {
    /**
     * 查询数据库表信息
     * @param tableInfo
     * @return
     */
    List<TableInfo> tableInfoList(TableInfo tableInfo);

    /**
     * 根据表名称查询信息
     * @param tableName
     * @return
     */
    TableInfo selectTableByName(String tableName);

    /**
     * 根据表名称查询列信息
     * @param tableName
     * @return
     */
    List<ColumnInfo> selectTableColumnsByName(String tableName);
}
