package design.pattern.factory.simple.impl;

import design.pattern.factory.simple.ICourse;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python视频");
    }
}
