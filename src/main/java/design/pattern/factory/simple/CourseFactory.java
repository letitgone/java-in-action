package design.pattern.factory.simple;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

/*public class CourseFactory {
    public static ICourse create(String name) {
        if ("java".equals(name)) {
            return new JavaCourse();
        } else if ("python".equals(name)) {
            return new PythonCourse();
        } else {
            return null;
        }
    }
}*/

/*public class CourseFactory {
    public static ICourse create(String className){
        //这里没有引入springUtil相关的jar包,也没有自己封装,将就吧
        if(className != null && !"".equals(className)){
            try {
                return (ICourse) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}*/

public class CourseFactory {
    public static ICourse create(Class<? extends ICourse> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
