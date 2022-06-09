package com.zaks.bhalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMergeDemoRunner {

    public static void main(String[] args) {
        Person p1=new Person("sachin","zaks",36);
        Person p2=new Person("bhalla","Nikunj",32);
        Person p3=new Person("Sanjay","karade",38);
        Person p4=new Person("Suresh","Dhere",35);
        Person p5=new Person("Vijay","Chaoure",39);
        Person p6=new Person("Suhas","Kokate",40);

        City newYork=new City("newYork");
        City london=new City("london");
        City paris=new City("paris");

        Map<City, List<Person>> map1=new HashMap<>();

        map1.computeIfAbsent(newYork,city->new ArrayList<>()).add(p1);
        map1.computeIfAbsent(paris,city->new ArrayList<>()).add(p2);
        map1.computeIfAbsent(paris,city->new ArrayList<>()).add(p3);

        map1.forEach((city,person)-> System.out.println(city + " : " + person));

        System.out.println("-----------------------------------------------");
        Map<City, List<Person>> map2=new HashMap<>();

        map2.computeIfAbsent(newYork,city->new ArrayList<>()).add(p4);
        map2.computeIfAbsent(london,city->new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris,city->new ArrayList<>()).add(p6);

        map2.forEach((city,person)-> System.out.println(city + " : " + person));

    }
}
