package lambda;

import java.util.Arrays;

/**
 * 累加
 * @Author ZhangGJ
 * @Date 2019/12/20 16:29
 */
public class Cumulative {
    public static void main(String[] args) {
        String[] n = {"1","2","3"};
        int sum = Arrays.stream(n).mapToInt(num -> Integer.parseInt(num)).sum();
        System.out.println(sum);
    }
}
