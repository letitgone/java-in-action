package design.pattern.factory.abastract;

import design.pattern.factory.abastract.impl.JavaNote;
import design.pattern.factory.abastract.impl.JavaVideo;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class JavaCourseFactory implements CourseFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
