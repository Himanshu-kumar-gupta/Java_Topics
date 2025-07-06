@FunctionalInterface
interface Greeting {
    void sayHello();
}

public class FunctionalInterface4 {
    public static void main(String[] args) {
        // Using a lambda expression to implement the interface
        Greeting greeting = () -> System.out.println("Hello, World!");
        greeting.sayHello();
    }
}
