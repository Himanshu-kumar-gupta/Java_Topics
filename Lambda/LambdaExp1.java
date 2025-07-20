// Functional interface with no parameters
@FunctionalInterface
interface Greetable {
    void greet();
}

// Functional interface with two parameters
@FunctionalInterface
interface Addable {
    int add(int a, int b);
}

// Functional interface with one parameter
@FunctionalInterface
interface MessagePrinter {
    void printMessage(String message);
}

public class LambdaExp1 {
    public static void main(String[] args) {

        // Lambda with no parameters
        Greetable greeting = () -> System.out.println("Hello from Lambda!");
        greeting.greet();

        // Lambda with one parameter
        MessagePrinter printer = message -> System.out.println("Message: " + message);
        printer.printMessage("Lambda with one parameter!");

        // Lambda with two parameters and return value
        Addable addition = (a, b) -> a + b;
        System.out.println("Addition of 10 and 20: " + addition.add(10, 20));

        // Lambda with two parameters and multiple statements
        Addable detailedAdd = (a, b) -> {
            System.out.println("Adding numbers: " + a + " + " + b);
            return a + b;
        };
        int result = detailedAdd.add(5, 7);
        System.out.println("Result: " + result);
    }
}
