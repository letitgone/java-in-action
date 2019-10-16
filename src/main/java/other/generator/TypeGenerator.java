package other.generator;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhangGJ
 * @Date 2019/10/15
 *
 * Mybatis生成代码，把数据库类型转换成Java的单例模式
 */
public class TypeGenerator {

    private static TypeGenerator typeGenerator = null;

    public Map<String, String> map = null;

    private TypeGenerator(){
        map = new HashMap<String, String>();
        map.put("tinyint", "Integer");
        map.put("smallint", "Integer");
        map.put("mediumint", "Integer");
        map.put("int", "Integer");
        map.put("integer", "integer");
        map.put("bigint", "Long");
        map.put("float", "Float");
        map.put("double", "Double");
        map.put("decimal", "BigDecimal");
        map.put("bit", "Boolean");
        map.put("char", "String");
        map.put("varchar", "String");
        map.put("tinytext", "String");
        map.put("text", "String");
        map.put("mediumtext", "String");
        map.put("longtext", "String");
        map.put("time", "Date");
        map.put("date", "Date");
        map.put("datetime", "Date");
        map.put("timestamp", "Date");
    }

    public static TypeGenerator getInstance(){
        if(typeGenerator == null){
            typeGenerator = new TypeGenerator();
        }
        return typeGenerator;
    }

}
