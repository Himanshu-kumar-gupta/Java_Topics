public class Assertions1 {

    public static void main(String[] args) {
        int age = 15;

        // Assertion with no message
        assert age >= 18;

        // Assertion with custom error message
        assert age >= 18 : "Age must be at least 18, but was " + age;

        System.out.println("Program completed.");
    }
}

// to enable assertions use : java -ea Assertions1