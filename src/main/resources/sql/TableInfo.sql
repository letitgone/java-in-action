--
-- 代码生成查询表的信息
--

SELECT         -- Mybatis中的SQL
	table_name,
	table_comment,
	create_time,
	update_time
FROM
	information_schema.TABLES
WHERE
	table_comment <![ CDATA [ <> ]]> ''
	AND table_schema = ( SELECT DATABASE ( ) )
	AND table_name = #{tableName}
-- 如果要查询起始时间
  <if test="params.beginTime != null and params.beginTime != ''"><!-- 开始时间检索 -->
    and date_format(create_time,'%y%m%d') &gt;= date_format(#{params.beginTime},'%y%m%d')
  </if>



SELECT          -- MySQL中的SQL
	table_name,
	table_comment,
	create_time,
	update_time
FROM
	information_schema.TABLES
WHERE
	table_comment <> ''
	AND table_schema = ( SELECT DATABASE ( ) )
	AND table_name = 'sys_job'  -- 查询所有的表，删掉这一行
