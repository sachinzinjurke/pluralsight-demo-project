package com.zaks.streams;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

    private final Spliterator<String> linesSpliterator;
    private String name;
    private String gender;
    private String surName;

    public PersonSpliterator(Spliterator<String> linesSpliterator) {
        this.linesSpliterator=linesSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        
       if( this.linesSpliterator.tryAdvance((line)->this.name=line)  &&
            this.linesSpliterator.tryAdvance((line)->this.surName=line) &&
            this.linesSpliterator.tryAdvance((line)->this.gender=line)) {
           Person p=new Person(name,surName,gender);
           action.accept(p);
           return true;
       }else{
           return false;
       }

    }

    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.linesSpliterator.estimateSize()/3;
    }

    @Override
    public int characteristics() {
        return this.linesSpliterator.characteristics();
    }
}
