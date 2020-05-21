package lambda.apple.impl;

import lambda.apple.Apple;
import lambda.apple.ApplePredicate;

/**
 * @Author ZhangGJ
 * @Date 2020/05/20 23:30
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
