package design.pattern.builder.classic;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
@Data
public class Computer {
    /*CPU*/
    private String CPU;
    /*内存*/
    private String memory;
    /*硬盘*/
    private String hardDisk;
    /*键盘*/
    private String keyboard;
    /*鼠标*/
    private String mouse;
}
