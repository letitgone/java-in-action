package design.pattern.builder.classic;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public interface ComputerConfigBuilder {
    void setCPU();

    void setMemery();

    void setHardDisk();

    void setKeyboard();

    void setMouse();

    Computer getComputer();
}
