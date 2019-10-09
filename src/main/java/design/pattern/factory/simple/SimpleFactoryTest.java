package design.pattern.factory.simple;

import design.pattern.factory.simple.impl.PythonCourse;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 简单工厂模式
 */

/*public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course = new JavaCourse();
        course.record();
    }
}*/

/*public class SimpleFactoryTest {
    public static void main(String[] args) {
        //ICourse course = new JavaCourse();
        ICourse course = CourseFactory.create("java");
        course.record();
    }
}*/

/*public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course = CourseFactory.create("design.pattern.factory.simple.impl.JavaCourse");
        course.record();
    }
}*/

public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course = CourseFactory.create(PythonCourse.class);
        course.record();
    }
}
