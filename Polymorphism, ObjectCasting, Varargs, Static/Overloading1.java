public class Overloading1 {

    // 1. Overloading by changing the number of parameters
    public void display() {
        System.out.println("No parameters");
    }

    public void display(String message) {
        System.out.println("One parameter (String): " + message);
    }

    // 2. Overloading by changing the type of parameters
    public void show(int number) {
        System.out.println("Parameter type int: " + number);
    }

    public void show(double number) {
        System.out.println("Parameter type double: " + number);
    }

    // 3. Overloading by changing the sequence of parameters
    public void print(String text, int number) {
        System.out.println("String followed by int: " + text + ", " + number);
    }

    public void print(int number, String text) {
        System.out.println("Int followed by String: " + number + ", " + text);
    }

    // main method to run all examples
    public static void main(String[] args) {
        Overloading1 obj = new Overloading1();

        // Changing number of parameters
        obj.display();
        obj.display("Hello");

        // Changing type of parameters
        obj.show(100);
        obj.show(99.99);

        // Changing sequence of parameters
        obj.print("Age", 25);
        obj.print(30, "Years");
    }
}
