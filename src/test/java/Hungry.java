/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class Hungry {

    private static final Hungry hungry = new Hungry();

    private Hungry() {

    }

    public static Hungry getInstance() {
        return hungry;
    }
}
