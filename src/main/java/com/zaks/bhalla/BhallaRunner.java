package com.zaks.bhalla;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BhallaRunner {

    public static void main(String[] args) {

        Person p1=new Person("Sachin","Zinjurke",36);
        Person p2=new Person("Nikunj","Bhalla",32);
        Person p3=new Person("Sanjay","Karade",38);
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

        Map<String,List<String>>masterMap=new HashMap<>();

        personList.stream().map(person -> {
            Map<String, List<String>> map = new HashMap<>();
            map.computeIfAbsent("name", city->new ArrayList<>()).add(person.getName());
            map.computeIfAbsent("surName", city->new ArrayList<>()).add(person.getSurName());
            map.computeIfAbsent("age", city->new ArrayList<>()).add(String.valueOf(person.getAge()));
            return map;
        }).forEach(streamMap->{
            streamMap.forEach(
                    (keyAttr,valueAttr)->{
                        masterMap.merge(
                                keyAttr,valueAttr,
                                (valueFromMaster,valueFromStream)->{
                                    valueFromMaster.addAll(valueFromStream);
                                    return valueFromMaster;
                                });
                    }
            );

        });


        masterMap.forEach((key,value)-> System.out.println(key + " :: " +value));
    }
}
