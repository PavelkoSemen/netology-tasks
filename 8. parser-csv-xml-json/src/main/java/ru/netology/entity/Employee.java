package ru.netology.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

}
