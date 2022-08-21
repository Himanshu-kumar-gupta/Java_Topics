package Generics;

public class A02_WithGeneric {
    public static void main(String[] args) {

        //Generic cannot be of primitive types like int,float
        //Print<int> iObj = new Print<>(23);  gives error
        //They can be of any class
        //Such as wrapper class Integer, Double, Float

        Print<Integer> iObj = new Print<>(23);
        iObj.print();

        Print<Double> dObj = new Print<>(7.98);
        dObj.print();

        Print<String> sObj = new Print<>("Hello");
        sObj.print();

//        Output
//        23
//        7.98
//        Hello
    }
}

// Using same class with Generic to print diff types of objects

// Class to print any type
class Print<T> {  //T can have any name
    T toPrint;
    Print(T t) {
        this.toPrint = t;
    }

    public void print() {
        System.out.println(toPrint);
    }
}