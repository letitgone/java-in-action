package design.pattern.factory.abastract.impl;

import design.pattern.factory.abastract.IVideo;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("python视频");
    }
}
