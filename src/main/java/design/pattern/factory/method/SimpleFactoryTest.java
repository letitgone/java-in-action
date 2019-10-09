package design.pattern.factory.method;

import design.pattern.factory.method.impl.JavaCourseFactory;
import design.pattern.factory.method.impl.PythonCourseFactory;
import design.pattern.factory.simple.ICourse;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 工厂方法模式
 */

public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.create();
        course.record();

        courseFactory = new PythonCourseFactory();
        course = courseFactory.create();
        course.record();
    }
}
