package ru.netology.util;

import ru.netology.person.Education;
import ru.netology.person.Person;
import ru.netology.person.Sex;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {

    public long getNumberOfMinors(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() < 18)
                .count();
    }

    public List<String> getConscripts(List<Person> people) {
        return people.stream()
                .filter(p -> p.getSex().equals(Sex.MAN))
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    public List<Person> getAbleToWork(List<Person> people) {
        return people.stream()
                .filter(p -> p.getEducation().equals(Education.HIGHER))
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Sex.WOMAN && p.getAge() < 60)
                        || (p.getSex() == Sex.MAN && p.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }

}
