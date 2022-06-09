package com.zaks.bhalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public class BhallaAlternativeRunner {

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

        Map<String,List<String>> masterMap=new HashMap<>();

        personList.stream().map(person -> {
            Stream.Builder<String> builder = Stream.builder();
            builder.add("name".concat("-").concat(person.getName()))
                    .add("surName".concat("-").concat(person.getSurName()))
                    .add("age".concat("-").concat(String.valueOf(person.getAge())));
            return builder.build();
        }).flatMap(Function.identity())
                .forEach(pair->{
                    String[] split = pair.split("-");
                    masterMap.computeIfAbsent(split[0], key->new ArrayList<>()).add(split[1]);
                });

        masterMap.forEach((key,value)-> System.out.println(key + " :: " +value));
    }

}
