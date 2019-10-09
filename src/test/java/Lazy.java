/**
 * @Author ZhangGJ
 * @Date 2019/10/08
 */
public class Lazy {

    private static Lazy lazy = null;

    private Lazy(){

    }

    public static Lazy getInstance(){
        if(lazy == null){
            lazy = new Lazy();
        }
        return lazy;
    }
}
