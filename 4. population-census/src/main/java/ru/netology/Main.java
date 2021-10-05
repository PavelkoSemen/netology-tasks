package ru.netology;

import ru.netology.person.Education;
import ru.netology.person.Person;
import ru.netology.person.Sex;
import ru.netology.util.Statistics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> londoners = generatingListOfPeople();

        Statistics statistics = new Statistics();

        System.out.println("Начальный список: " + londoners);
        System.out.println("Число несовершеннолетних: " + statistics.getNumberOfMinors(londoners));
        System.out.println("Призывники: " + statistics.getConscripts(londoners));
        System.out.println("Рабочии: " + statistics.getAbleToWork(londoners));

    }


    private static List<Person> generatingListOfPeople() {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        return persons;
    }
}
