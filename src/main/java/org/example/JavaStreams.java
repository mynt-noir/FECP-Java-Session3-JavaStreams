package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JavaStreams {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            String result;
            result = getName() + " - " + getAge();
            return result;
        }
    }

    public static void main(String[] args) {
        // --- act 1: filter odd numbers ---
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isOdd = num -> num % 2 == 1;

        List<Integer> oddNumbers = numbers.stream()
                .filter(isOdd)
                .toList();

        // print all odd numbers
        System.out.print("Odd Numbers: ");
        System.out.println(oddNumbers);


        // --- act 2: starts with letter A ---
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");

        Predicate<String> startsWithA = name -> name.startsWith("A");

        List<String> aNames = names.stream()
                .filter(startsWithA)
                .toList();

        // print all names starting with A
        System.out.print("Names starting with A: ");
        System.out.println(aNames);


        // --- act 3: square all numbers ---
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squaredNumbers = numbers1.stream()
                .map(num -> num * num)
                .toList();

        // print all numbers squared
        System.out.print("Squared numbers: ");
        System.out.println(squaredNumbers);


        // --- act 4: combine predicates ---
        // get numbers list from act 1
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreaterThanFive = num -> num > 5;

        Predicate<Integer> combined = isEven.and(isGreaterThanFive);

        List<Integer> evenAndGreaterThan5 = numbers.stream()
                .filter(combined)
                .toList();

        // print even and > 5
        System.out.print("Even and >5: ");
        System.out.println(evenAndGreaterThan5);


        // --- act 5: sort objects using comparator ---
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Tyrell", 24));
        persons.add(new Person("Rom", 24));
        persons.add(new Person("Ralph", 27));
        persons.add(new Person("Gen", 22));
        persons.add(new Person("Tricia", 25));


        // sort by age (ascending)
        System.out.println("Sorted by age (ascending):");
        
        // sort by name
        System.out.println("Sorted by name:");

        // sort by age (descending)
        System.out.println("Sorted by age (descending):");

    }
    }
