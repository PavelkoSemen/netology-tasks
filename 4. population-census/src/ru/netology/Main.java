package ru.netology;

import ru.netology.person.Education;
import ru.netology.person.Person;
import ru.netology.person.Sex;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> londoners = generatingListOfPeople();
        System.out.println("Начальный список: " + londoners);

        long countPeople = londoners.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        System.out.println("Число несовершеннолетних: " + countPeople);

        List<String> conscripts = londoners.stream()
                .filter(p -> p.getSex().equals(Sex.MAN))
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Призывники: " + conscripts);


        List<Person> workers = londoners.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Sex.WOMAN && p.getAge() < 60)
                        || (p.getSex() == Sex.MAN && p.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("Рабочии: " + workers);

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
