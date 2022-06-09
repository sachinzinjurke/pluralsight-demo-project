package com.zaks.compare;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    public static <U>Comparator<U> comparing(Function<U, Comparable> f1) {
        return (p1,p2)->f1.apply(p1).compareTo(f1.apply(p2)) ;
    }

    public int compare(T t1, T t2);

    public default Comparator<T> thenComparing(Comparator<T> cmpFirstName){
        return (p1,p2)-> compare(p1, p2)==0?cmpFirstName.compare(p1, p2):compare(p1, p2);

    }
    public default Comparator<T> thenComparing(Function<T, Comparable> f1){
        return thenComparing(comparing(f1));

    }

}
