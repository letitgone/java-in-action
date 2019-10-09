package design.pattern.factory.abastract;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 抽象工厂模式
 */

public class AbstractFactoryTest {

    public static void main(String[] args) {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNote().edit();
        javaCourseFactory.createVideo().record();

        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.createNote().edit();
        pythonCourseFactory.createVideo().record();
    }
}
