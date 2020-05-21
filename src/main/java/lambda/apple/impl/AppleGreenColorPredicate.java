package lambda.apple.impl;

import lambda.apple.Apple;
import lambda.apple.ApplePredicate;

/**
 * @Author ZhangGJ
 * @Date 2020/05/20 23:31
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
