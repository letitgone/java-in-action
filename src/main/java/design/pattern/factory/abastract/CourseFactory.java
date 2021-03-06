package design.pattern.factory.abastract;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public interface CourseFactory {
    INote createNote();
    IVideo createVideo();
}
