import java.util.*;

class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    public void speak() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    public void speak() {
        System.out.println("Cat meows");
    }
}

public class Generic2Wildcard {

    // Unbounded wildcard: accepts any type of list
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // Upper bounded wildcard: accepts List of Animal or its subclasses
    public static void makeAnimalsSpeak(List<? extends Animal> list) {
        for (Animal animal : list) {
            animal.speak();
        }
    }

    // Lower bounded wildcard: accepts List of Dog or any superclass of Dog
    public static void addDogs(List<? super Dog> list) {
        list.add(new Dog());
        System.out.println("Dog added to the list");
    }

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("Hello", "World");
        List<Integer> intList = Arrays.asList(1, 2, 3);

        System.out.println("=== Unbounded Wildcard ===");
        printList(stringList);
        printList(intList);

        System.out.println("\n=== Upper Bounded Wildcard ===");
        List<Dog> dogs = Arrays.asList(new Dog(), new Dog());
        List<Cat> cats = Arrays.asList(new Cat(), new Cat());
        makeAnimalsSpeak(dogs);
        makeAnimalsSpeak(cats);

        System.out.println("\n=== Lower Bounded Wildcard ===");
        List<Animal> animalList = new ArrayList<>();
        addDogs(animalList); // Dog is subclass of Animal
        makeAnimalsSpeak(animalList); // Confirm dog was added
    }
}