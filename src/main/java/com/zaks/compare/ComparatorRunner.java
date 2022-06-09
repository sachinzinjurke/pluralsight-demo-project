package com.zaks.compare;

import java.util.Arrays;

public class ComparatorRunner {

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Volvo", 23400), new Car("Mazda", 13700),
                new Car("Porsche", 353800), new Car("Skoda", 8900),
                new Car("Volkswagen", 19900)
        };

        System.out.println("Before comparision");
        Arrays.stream(cars).forEach(System.out::println);

        System.out.println("Comparison by price:");
        Arrays.sort(cars, new ComparatorByPrice());

        Arrays.stream(cars).forEach(System.out::println);

        /*System.out.println("---------------------");
        System.out.println("Comparison by Name:");
        Arrays.sort(cars, new ComparatotByName());
        Arrays.stream(cars).forEach(System.out::println);
*/
        System.out.println("After comparision");
        Arrays.stream(cars).forEach(System.out::println);
    }
}
