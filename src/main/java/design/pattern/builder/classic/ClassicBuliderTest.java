package design.pattern.builder.classic;

import design.pattern.builder.classic.handler.HighConfigBuider;
import design.pattern.builder.classic.handler.LowConfigBuilder;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 * 经典builder模式
 */
public class ClassicBuliderTest {
    public static void main(String[] args) {
        Director director = new Director();//创建装机人员
        director.setBuilder(new LowConfigBuilder()); //告诉装机人员电脑配置，这里为低配版
        director.createComputer(); //装机人员开始组装
        Computer low = director.getComputer(); //从装机人员获取组装好的电脑
        System.out.print("电脑配置：" + low.toString());  //查看电脑配置

        director.setBuilder(new HighConfigBuider());
        director.createComputer();
        Computer hight = director.getComputer();
        System.out.print("电脑配置：" + hight.toString());
    }
}
