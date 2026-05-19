package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Seminar5App {

    public static void main(String[] args) {

        System.out.println("=== 1. ArrayList of Student Names ===");
        exercise1();

        System.out.println("\n=== 2. Sum and Average of Integers ===");
        exercise2();

        System.out.println("\n=== 3. Reverse a List Manually ===");
        exercise3();

        System.out.println("\n=== 4. Unique Words Counter ===");
        exercise4();

        System.out.println("\n=== 5. Word Frequency Counter ===");
        exercise5();

        System.out.println("\n=== 6. Phone Book ===");
        exercise6();

        System.out.println("\n=== 7. Students Management System ===");
        exercise7();

        System.out.println("\n=== 8. Sort Students ===");
        exercise8();

        System.out.println("\n=== 9. Remove Duplicates from Objects ===");
        exercise9();

        System.out.println("\n=== Optional 10. LRU Cache ===");
        exercise10();

        System.out.println("\n=== Optional 11. Merge Two Maps ===");
        exercise11();
    }

    public static void exercise1() {
        ArrayList<String> names = new ArrayList<>();

        names.add("Ana");
        names.add("Maria");
        names.add("Ioana");
        names.add("Andrei");
        names.add("Vlad");

        System.out.println("Initial names:");
        for (String name : names) {
            System.out.println(name);
        }

        names.remove(2);

        System.out.println("After removing the 3rd name:");
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void exercise2() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        double average = (double) sum / numbers.size();

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    public static void exercise3() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        System.out.println("Original list: " + numbers);

        for (int i = 0; i < numbers.size() / 2; i++) {
            int oppositeIndex = numbers.size() - 1 - i;

            int temp = numbers.get(i);
            numbers.set(i, numbers.get(oppositeIndex));
            numbers.set(oppositeIndex, temp);
        }

        System.out.println("Reversed list: " + numbers);
    }

    public static void exercise4() {
        String sentence = "java is easy and java is useful";

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Sentence: " + sentence);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Unique words count: " + uniqueWords.size());
    }

    public static void exercise5() {
        String input = "apple banana apple orange banana apple";

        String[] words = input.split(" ");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Word frequency: " + frequency);
    }

    public static void exercise6() {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Ana", "0711111111");
        phoneBook.put("Maria", "0722222222");
        phoneBook.put("Andrei", "0733333333");

        String searchedName = "Maria";

        if (phoneBook.containsKey(searchedName)) {
            System.out.println(searchedName + "'s phone number is: " + phoneBook.get(searchedName));
        } else {
            System.out.println(searchedName + " was not found.");
        }

        System.out.println("All phone book entries:");

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void exercise7() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ana", 9));
        students.add(new Student("Maria", 10));
        students.add(new Student("Andrei", 8));
        students.add(new Student("Vlad", 7));

        System.out.println("All students:");

        for (Student student : students) {
            System.out.println(student);
        }

        Student bestStudent = students.get(0);

        for (Student student : students) {
            if (student.getGrade() > bestStudent.getGrade()) {
                bestStudent = student;
            }
        }

        System.out.println("Student with highest grade: " + bestStudent);
    }

    public static void exercise8() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Vlad", 7));
        students.add(new Student("Ana", 9));
        students.add(new Student("Maria", 10));
        students.add(new Student("Andrei", 8));

        System.out.println("Original list:");
        System.out.println(students);

        students.sort(Comparator.comparing(Student::getName));

        System.out.println("Sorted by name alphabetically:");
        System.out.println(students);

        students.sort(Comparator.comparing(Student::getGrade).reversed());

        System.out.println("Sorted by grade descending:");
        System.out.println(students);
    }

    public static void exercise9() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ana", 9));
        students.add(new Student("Maria", 10));
        students.add(new Student("Ana", 9));
        students.add(new Student("Vlad", 7));
        students.add(new Student("Maria", 10));

        System.out.println("List with duplicates:");
        System.out.println(students);

        Set<Student> uniqueStudentsSet = new HashSet<>(students);

        List<Student> uniqueStudentsList = new ArrayList<>(uniqueStudentsSet);

        System.out.println("List without duplicates:");
        System.out.println(uniqueStudentsList);
    }

    public static void exercise10() {
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 3;
            }
        };

        cache.put(1, "Ana");
        cache.put(2, "Maria");
        cache.put(3, "Andrei");

        System.out.println("Initial cache: " + cache);

        cache.get(1);

        cache.put(4, "Vlad");

        System.out.println("Cache after accessing key 1 and adding key 4:");
        System.out.println(cache);
    }

    public static void exercise11() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 2);
        map1.put("banana", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 4);
        map2.put("orange", 5);

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (mergedMap.containsKey(key)) {
                mergedMap.put(key, mergedMap.get(key) + value);
            } else {
                mergedMap.put(key, value);
            }
        }

        System.out.println("Map 1: " + map1);
        System.out.println("Map 2: " + map2);
        System.out.println("Merged map: " + mergedMap);
    }
}