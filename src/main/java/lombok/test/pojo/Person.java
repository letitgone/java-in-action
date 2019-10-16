package lombok.test.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author ZhangGJ
 * @Date 2019/10/16
 */
//@Getter
//@Setter
@Data
public class Person {

    private String name;

    private int id;

    private String className;

    private String classname;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getClassName() {
//        return className;
//    }
//
//    public void setClassName(String className) {
//        this.className = className;
//    }
//
//    public String getClassname() {
//        return classname;
//    }
//
//    public void setClassname(String classname) {
//        this.classname = classname;
//    }
}
