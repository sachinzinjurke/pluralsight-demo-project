package com.zaks.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamBuilder {

    public static void main(String[] args) {

        Stream<String> xstream = Stream.iterate("X", d -> d + "X");
        xstream.limit(5).forEach(System.out::println);
        System.out.println(xstream);
        Stream<Integer> intStream = Stream.generate(() -> new Random().nextInt(10) );
        intStream.limit(5).forEach(System.out::println);

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

    }
}
