package com.interview.kforce.first.q3;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author gasieugru
 */
public class Person {
    private String surname;
    private String name;

    public Person(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surname, person.surname) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name);
    }

    public static void main(String[] args) {
        HashMap<Person, String> personMap = new HashMap<>();

        Person person1 = new Person("Smith", "John");
        Person person2 = new Person("Smith", "John");
        personMap.put(person1, "person1");

        // What needs to be done t o see string "person1" as an output?
        // We need to implement equals and hashCode methods in class Person.
        System.out.println(personMap.get(person2));
    }
}
