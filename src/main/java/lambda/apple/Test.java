package lambda.apple;

import lambda.apple.impl.AppleGreenColorPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhangGJ
 * @Date 2020/05/20 23:34
 */
public class Test {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        filterApples(new ArrayList<>(), new AppleGreenColorPredicate());

        /**
         * 匿名内部类
         */
        List<Apple> redApples = filterApples(new ArrayList<>(), new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        /**
         * Lambda表达式
         */
        List<Apple> redApple = filter(new ArrayList<>(), (Apple apple) -> "red".equals(apple.getColor()));
    }
}
