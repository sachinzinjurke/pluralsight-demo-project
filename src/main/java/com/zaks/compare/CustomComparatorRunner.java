package com.zaks.compare;

import java.util.function.Function;

public class CustomComparatorRunner {

    public static void main(String[] args) {

        Comparator<Person> cmpByAge=(p1,p2)->p2.getAge()-p1.getAge();

        Comparator<Person> cmpByFirstName=(p1,p2)->p1.getFirstName().compareTo(p2.getFirstName());

        Comparator<Person> cmpByLastName=(p1,p2)->p1.getSurName().compareTo(p2.getSurName());

        Function<Person,Integer> f1=p->p.getAge();
        Function<Person,String> f2=p->p.getFirstName();
        Function<Person,String> f3=p->p.getSurName();

        Comparator<Person> cmpAge=Comparator.comparing(Person::getAge);
        Comparator<Person> cmpFirstName=Comparator.comparing(Person::getFirstName);
        Comparator<Person> cmpLastName=Comparator.comparing(Person::getSurName);

        Comparator<Person> cmp3=cmpFirstName.thenComparing(cmpFirstName);

        Comparator<Person> cmp4=Comparator.comparing(Person::getAge)
                .thenComparing(Person::getFirstName);




    }
}
