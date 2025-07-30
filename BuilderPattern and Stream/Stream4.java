import java.util.*;
import java.util.stream.Collectors;

public class Stream4 {

    static class Person {
        String name;
        int age;
        String city;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String toString() {
            return name + " (" + age + ", " + city + ")";
        }

        public String getName() { return name; }
        public int getAge() { return age; }
        public String getCity() { return city; }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "Delhi"));
        people.add(new Person("Bob", 25, "Mumbai"));
        people.add(new Person("Charlie", 35, "Delhi"));
        people.add(new Person("David", 40, "Mumbai"));
        people.add(new Person("Eve", 28, "Delhi"));

        // 1. toList()
        System.out.println("=== toList() ===");
        List<String> namesList = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(namesList);

        // 2. toSet()
        System.out.println("\n=== toSet() ===");
        Set<String> citySet = people.stream()
                .map(Person::getCity)
                .collect(Collectors.toSet());
        System.out.println(citySet);

        // 3. toMap() - name to age 
        System.out.println("\n=== toMap() without BinaryOperator ===");
        Map<String, Integer> nameToAge = people.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge      // Throws exception if duplicate key found
                ));
        System.out.println(nameToAge);

        // 3. toMap() - name to age (if duplicate, keep latest age)
        System.out.println("\n=== toMap() with BinaryOperator ===");
        Map<String, Integer> uniqueNameToAge = people.stream()
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getAge,
                        (existing, replacement) -> replacement)); // resolve duplicate key
        System.out.println(uniqueNameToAge);

        // 4. toCollection() - collect into LinkedList
        System.out.println("\n=== toCollection(LinkedList) ===");
        LinkedList<String> nameLinkedList = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(nameLinkedList);

        // 5. joining()
        System.out.println("\n=== joining() ===");
        String joinedNames = people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Names joined: " + joinedNames);

        // 6. averagingDouble()
        System.out.println("\n=== averagingDouble() ===");
        double averageAge = people.stream()
                .collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("Average age: " + averageAge);

        // 7. counting()
        System.out.println("\n=== counting() ===");
        long totalPeople = people.stream()
                .collect(Collectors.counting());
        System.out.println("Total count: " + totalPeople);

        // 8. groupingBy() - group people by city
        System.out.println("\n=== groupingBy() ===");
        Map<String, List<Person>> groupByCity = people.stream()
                .collect(Collectors.groupingBy(Person::getCity));
        groupByCity.forEach((city, persons) -> {
            System.out.println(city + ": " + persons);
        });

        // 9. groupingBy() with downstream collector: count people per city
        System.out.println("\n=== groupingBy() with counting() ===");
        Map<String, Long> cityCounts = people.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        System.out.println(cityCounts);

        // 10. partitioningBy() partition by age > 30
        System.out.println("\n=== partitioningBy() without downstream ===");
        Map<Boolean, List<Person>> partitioned = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 30));
        partitioned.forEach((isOlder, group) -> {
            System.out.println((isOlder ? "Older than 30" : "30 or below") + ": " + group);
        });

        // 11. partitioningBy() with downstream - partition by age > 30 and count
        System.out.println("\n=== partitioningBy() with counting() ===");
        Map<Boolean, Long> partitionByAge = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 30, Collectors.counting()));
        System.out.println("Age > 30: " + partitionByAge);
    }
}
