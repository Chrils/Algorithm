package org.example;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        boolean[] bs = new boolean[4];
        System.out.println(Arrays.toString(bs));
    }

    private static <T> boolean test(T t,Predicate<T> predicate) {
        return predicate.test(t);
    }
}