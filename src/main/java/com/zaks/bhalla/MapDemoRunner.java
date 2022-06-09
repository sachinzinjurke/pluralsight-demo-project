package com.zaks.bhalla;

import java.util.*;

public class MapDemoRunner {

    public static void main(String[] args) {
        Person p1=new Person("sachin","zaks",36);
        Person p2=new Person("bhalla","Nikunj",32);
        Person p3=new Person("Sanjay","karade",38);
        Person p4=new Person("Suresh","Dhere",35);
        Person p5=new Person("Vijay","Chaoure",39);
        Person p6=new Person("Suhas","Kokate",40);

        List<Person> personList=new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);

        City newYork=new City("newYork");
        City london=new City("london");
        City paris=new City("paris");

        Map<City,List<Person>>map=new HashMap<>();

        map.putIfAbsent(paris,new ArrayList<>());
        map.get(paris).add(p1);

        map.computeIfAbsent(newYork, city->new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city->new ArrayList<>()).add(p3);

        System.out.println("People from Paris " + map.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from New York " + map.getOrDefault(newYork, Collections.EMPTY_LIST));

    }
}
