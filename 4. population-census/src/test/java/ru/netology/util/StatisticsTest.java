package ru.netology.util;

import org.junit.jupiter.api.*;
import ru.netology.person.Education;
import ru.netology.person.Person;
import ru.netology.person.Sex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class StatisticsTest {
    private List<Person> defaultList;
    private Statistics statistics;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;


    @BeforeEach
    void setUp() {
        person1 = new Person("TestN1", "Test1", 12, Sex.MAN, Education.ELEMENTARY);
        person2 = new Person("TestN2", "Test2", 18, Sex.MAN, Education.ELEMENTARY);
        person3 = new Person("TestN3", "Test3", 20, Sex.MAN, Education.HIGHER);
        person4 = new Person("TestN4", "Test4", 22, Sex.WOMAN, Education.HIGHER);
        person5 = new Person("TestN5", "Test5", 64, Sex.WOMAN, Education.HIGHER);
        defaultList = List.of(person1, person2, person3, person4, person5);
        statistics = new Statistics();
    }

    @Test
    @DisplayName("количество совершеннолетних людей")
    void shouldReturnTheNumberOfMinors() {
        final long expectedValue = 1;

        assertEquals(expectedValue, statistics.getNumberOfMinors(defaultList));
    }

    @Test
    @DisplayName("получение списока фамилий военнообязанных людей")
    void shouldReturnListOfConscripts() {
        final List<String> expectedList = List.of("Test2", "Test3");

        assertEquals(expectedList, statistics.getConscripts(defaultList));
    }

    @Test
    @DisplayName("получение списока трудоспособных людей, с высшим образованием")
    void shouldReturnListOfPeopleAbleToWork() {
        final List<Person> expectedList = List.of(person3, person4);

        assertEquals(expectedList, statistics.getAbleToWork(defaultList));
    }
}