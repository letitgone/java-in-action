package design.pattern.factory.abastract.impl;

import design.pattern.factory.abastract.IVideo;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */

public class JavaVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("java视频");
    }
}
