class CustomException extends Exception {

    // 1. No-arg constructor
    public CustomException() {
        super("Default CustomException message");
    }

    // 2. Constructor with custom message
    public CustomException(String message) {
        super(message);
    }

    // 3. Constructor with cause
    public CustomException(Throwable cause) {
        super(cause);
    }

    // 4. Constructor with message and cause
    // This is used when we want to chain another exception with message
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    // 5. Constructor with message, cause, suppression enabled/disabled, writableStackTrace
    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

public class CustomExceptionDemo1 {

    public static void main(String[] args) {

        // 1. Using no-arg constructor
        try {
            throw new CustomException();
        } catch (CustomException e) {
            System.out.println("Caught Exception (no-arg): " + e.getMessage());
        }

        // 2. Using message constructor
        try {
            throw new CustomException("Custom message");
        } catch (CustomException e) {
            System.out.println("Caught Exception (message): " + e.getMessage());
        }

        // 3. Using cause constructor
        try {
            Throwable cause = new NullPointerException("Root cause");
            throw new CustomException(cause);
        } catch (CustomException e) {
            System.out.println("Caught Exception (cause): " + e.getCause());
        }

        // 4. Using message and cause
        try {
            Throwable cause = new IllegalArgumentException("Illegal input");
            throw new CustomException("Combined error", cause);
        } catch (CustomException e) {
            System.out.println("Caught Exception (message + cause): " + e.getMessage() + ", cause: " + e.getCause());
        }

        // 5. Using all parameters (advanced)
        try {
            Throwable cause = new RuntimeException("Deep error");
            throw new CustomException("Full constructor", cause, true, false);
        } catch (CustomException e) {
            System.out.println("Caught Exception (full constructor): " + e.getMessage() + ", cause: " + e.getCause());
        }
    }
}

