--
-- 代码生成查询表列的信息
--



SELECT       -- Mybatis中的SQL
	column_name,
	data_type,
	column_comment
FROM
	information_schema.COLUMNS
WHERE
	table_name = #{tableName} and table_schema = (select database()) order by ordinal_position



SELECT       -- MySQL中的SQL
	column_name,
	data_type,
	column_comment
FROM
	information_schema.COLUMNS
WHERE
	table_name = 'sys_job' and table_schema = (select database()) order by ordinal_position
