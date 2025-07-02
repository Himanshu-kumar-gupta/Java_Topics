public class VarArgs1 {

    public static void printNumbers(int... numbers) {
        System.out.println("Printing numbers:");
        for (int num : numbers)
            System.out.println(num);  
    }

    // In this case a number of arguments can be infront and varargs SHOULD BE AT END
    public static void printNameNumbers(String name, String name2, int... numbers) {
        System.out.println("Printing name: "+name + "   "+ name2);
        System.out.println("Printing numbers:");
        for (int num : numbers)
            System.out.println(num);
    }

    // public static void printNameNumbers2(String... name, int... numbers) {} //not allowed

    public static void main(String[] args) {
    // Calling with multiple arguments
    printNumbers(10, 20, 30);

    // Calling with a single argument
    printNumbers(50);

    // Calling with no arguments
    printNumbers();

    // Calling with an array
    int[] myNumbers = {1, 2, 3, 4};
    printNumbers(myNumbers);

    //Calling with more than 1 type
    printNameNumbers("golem", "goblin", 10, 20, 40, 90);
    }
}
