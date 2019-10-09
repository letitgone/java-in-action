package design.pattern.factory.abastract;

import design.pattern.factory.abastract.impl.PythonNote;
import design.pattern.factory.abastract.impl.PythonVideo;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class PythonCourseFactory implements CourseFactory {

    @Override
    public INote createNote() {
        return new PythonNote();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
