package design.pattern.factory.method.impl;

import design.pattern.factory.method.ICourseFactory;
import design.pattern.factory.simple.ICourse;
import design.pattern.factory.simple.impl.JavaCourse;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
