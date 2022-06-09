package com.zaks.custom;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> p=new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.length()>5;
            }
        };

        Predicate<String>p2=text-> text.length() > 5;
    }
}
