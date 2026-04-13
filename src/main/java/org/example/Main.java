package org.example;

import java.util.HashSet;
import java.util.Set;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null ||  getClass() != o.getClass()) return false;
        Person person =  (Person)o;
        return name.equals(person.name);
    }
}

public class Main {
    static void changeName(Person p) {
        p = new Person("Alice");
    }

    static void changePrimitive(int x) {
        x = 10;
    }



    public static void main(String[] args) {
        Person person1 = new Person("Bob");
        Person person2 = new Person("Bob");

        changeName(person1);

        System.out.println("person1:" + person1.name);

        int a = 5;
        changePrimitive(a);

        System.out.println(a);

        System.out.println("Equals example: " + person1.equals(person2));

        Set<Person> set = new HashSet<>();
        set.add(new Person("Gav"));
        System.out.println("check HashSet " + set.contains(new Person("Gav")));
    }


}