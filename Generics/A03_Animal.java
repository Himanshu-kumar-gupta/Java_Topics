package Generics;

public class A03_Animal {
    public void type() {
        System.out.println("Animal");
    }
}

class Cat extends A03_Animal {
    public void type() {
        System.out.println("Cat");
    }
}

class Dog extends A03_Animal {
    public void type() {
        System.out.println("Dog");
    }
}