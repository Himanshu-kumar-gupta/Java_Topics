public class ThrowS1 {

    // Method that declares it might throw an exception using 'throws'
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            // Throwing an exception explicitly using 'throw'
            throw new IllegalArgumentException("Age must be at least 18 to vote.");
        } else {
            System.out.println("You are eligible to vote!");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16); // This will throw the exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling...");
    }
}
