package design.pattern.builder.classic;

/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class Director {
    private ComputerConfigBuilder mBuilder;

    public void setBuilder(ComputerConfigBuilder builder) {
        this.mBuilder = builder;
    }

    public void createComputer() {
        mBuilder.setCPU();
        mBuilder.setMemery();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }

    public Computer getComputer() {
        return mBuilder.getComputer();
    }
}
