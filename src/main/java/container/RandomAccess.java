package container;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2019/11/18
 */
public class RandomAccess {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        if(list instanceof RandomAccess){ // 是否支持高效的随机访问
            System.out.println("Y");
        }else{
            System.out.println("N");
        }
    }
}
