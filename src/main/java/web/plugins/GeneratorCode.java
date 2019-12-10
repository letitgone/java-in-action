package web.plugins;

/**
 * 生成代码
 */
public class GeneratorCode {
    public static void main(String[] args){
        /**
         *  参数为表名
         */
        new GeneratorSqlmap().gen("config");
    }
}
