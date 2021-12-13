package ru.netology.person;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String address;
    private boolean ageExist = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        ageExist = true;
    }

    public void happyBirthday() {
        if (!ageExist) {
            throw new IllegalArgumentException("Не известен начальный возраст");
        }
        age++;
    }

    public boolean hasAge() {
        return ageExist;
    }

    public boolean hasAddress() {
        return !(surname == null);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname)
                .setAddress(address)
                .setAge(0);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAgeExist() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cityOfResidence='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
