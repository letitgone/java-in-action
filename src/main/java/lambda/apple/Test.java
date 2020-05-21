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

    public static void main(String[] args) {
        filterApples(new ArrayList<>(), new AppleGreenColorPredicate());
    }
}
