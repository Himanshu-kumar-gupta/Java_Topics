import java.util.*;

// A simple class with name and age
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

// Separate comparator class for sorting by age
class AgeComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age);
    }
}

public class Comparator1 {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 25));

        System.out.println("Original List:");
        people.forEach(System.out::println);

        // 1. Sort using separate comparator class
        Collections.sort(people, new AgeComparator());
        System.out.println("\nSorted by age (using AgeComparator):");
        people.forEach(System.out::println);

        // 2. Sort using anonymous class by name
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);  //Using string compareTo method
            }
        });
        System.out.println("\nSorted by name (using anonymous class):");
        people.forEach(System.out::println);

        // 3. Sort using lambda expression by age descending
        // list.sort() expects a comparator interface, thus here comparator is implemented as its
        // compare method is implemented
        people.sort((p1, p2) -> Integer.compare(p2.age, p1.age));
        System.out.println("\nSorted by age descending (lambda):");
        people.forEach(System.out::println);

        people.sort(new AgeComparator().reversed());
        System.out.println("\nSorted by age descending (using reversed()):");
        people.forEach(System.out::println);
        
        // 4. Sort by age, then by name if age is equal
        people.sort(Comparator.comparingInt((Person p) -> p.age)
                              .thenComparing(p -> p.name)
                              .thenComparing(p -> p.name));
        System.out.println("\nSorted by age, then name (chained comparator):");
        people.forEach(System.out::println);

        // 5. Arrays.sort with Comparator
        Person[] personArray = {
            new Person("Zack", 40),
            new Person("Eve", 20),
            new Person("Adam", 22)
        };
        
        Arrays.sort(personArray, Comparator.comparing(p -> p.name));
        System.out.println("\nArray sorted by name using Arrays.sort():");
        for (Person p : personArray) {
            System.out.println(p);
        }

        Arrays.sort(personArray, Comparator.comparingInt(p -> p.age));
        System.out.println("\nArray sorted by age using Arrays.sort():");
        for (Person p : personArray) {
            System.out.println(p);
        }
    }
}