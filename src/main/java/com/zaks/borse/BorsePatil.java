package com.zaks.borse;

import com.zaks.streams.PersonSpliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BorsePatil {

    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\sachin\\IdeaProjects\\pluralsight-demo-project\\src\\main\\resources\\person.txt");
        try(Stream<String> lines= Files.lines(path);){
            List<Person> personListByAgeFilter = lines.map(line -> {
                String[] personArr = line.split(",");
                Person p = new Person(personArr[0], personArr[1], Integer.valueOf(personArr[2]), personArr[3]);
                return p;
            }).filter(person -> person.getAge() > 20)
                    .collect(Collectors.toList());

            personListByAgeFilter.forEach(System.out::println);


        }catch (IOException exp){
            System.out.println("Exception occurred while processing.. " + exp.getMessage());
        }

        Path folderPath = Paths.get("C:\\Users\\sachin\\IdeaProjects\\pluralsight-demo-project\\src\\main\\resources\\");
        try (Stream<Path> pathStream = Files.walk(folderPath)) {
            pathStream.forEach(filePath->System.out.println(filePath.getFileName()));

        } catch (IOException e) {
            e.printStackTrace();
        }



        Map<String ,String> emcidMap=new HashMap<String, String>();
        emcidMap.putIfAbsent("Agent","123");
        emcidMap.putIfAbsent("Principal","456");
        emcidMap.putIfAbsent("AgentOrPrincipal","789");

        Set<Map.Entry<String, String>> entries = emcidMap.entrySet();

        String emcid=null;
        for (Map.Entry<String,String> entry:entries) {
            System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());

            if(entry.getKey().equals("Agent")){
                emcid= entry.getValue();
            }else if(entry.getKey().equals("Principal")){
                emcid=entry.getValue();
            }else if (entry.getKey().equals("AgentOrPrincipal")){
                emcid=entry.getValue();
            }
        }
        System.out.println("EMCID :: "+ emcid);
        }


    }
