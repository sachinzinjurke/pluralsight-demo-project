package com.zaks.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorDemo {


    public static void main(String[] args) {
        Path path;
        path = Paths.get("C:\\Users\\sachin\\IdeaProjects\\pluralsight-demo-project\\src\\main\\resources\\people.txt");

        try(Stream<String> lines=Files.lines(path);){

            //lines.forEach(System.out::println);
            Spliterator<String> linesSpliterator = lines.spliterator();
            Spliterator<Person> personSpliterator=new PersonSpliterator(linesSpliterator);

            Stream<Person> streamOfPersons = StreamSupport.stream(personSpliterator, false);
            streamOfPersons.forEach(System.out::println);

        }catch (IOException exp){

        }
    }
}
