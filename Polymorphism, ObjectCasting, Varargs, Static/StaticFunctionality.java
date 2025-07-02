import static java.lang.Math.*;    //static import used to make static member available by their simple name

class MyClass {
    static int staticVariable; // Static variable
    int instanceVariable = 5; // Instance variable

    static{
        staticVariable = 10;
        System.out.println("Static block called");
    }

    static void staticMethod() { // Static method
        System.out.println("This is a static method.");
        System.out.println("Static variable in static method: " + staticVariable);
        // System.out.println(instanceVariable); // Error: Cannot access non-static member directly

        MyClass obj = new MyClass();
        System.out.println(obj.instanceVariable);
    }

    void instanceMethod() { // Instance method
        System.out.println("This is an instance method.");
        System.out.println("Static variable in instance method: " + staticVariable); // Can access static members
        System.out.println("Instance variable in instance method: " + instanceVariable);
    }
}

public class StaticFunctionality {
    public static void main(String[] args) {
        // Accessing static members using the class name
        System.out.println("Static variable value: " + MyClass.staticVariable);
        MyClass.staticMethod();

        // Creating an object to access instance members
        MyClass obj = new MyClass();
        System.out.println("Instance variable value: " + obj.instanceVariable);
        obj.instanceMethod();

        // Here as we have done static import above 
        // These static members are available to use without their classname(Math)
        System.out.println("Math PI value "+ PI);
        System.out.println("Math random value "+ random()*10);
    }
}
