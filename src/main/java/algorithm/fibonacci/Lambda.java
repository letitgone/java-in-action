package algorithm.fibonacci;

import java.util.stream.Stream;

/**
 * @Author ZhangGJ
 * @Date 2020/07/02 06:40
 */
public class Lambda {

    public static void main(String[] args) {
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10)
                .map(t -> t[0]).forEach(System.out::println);
    }
}
