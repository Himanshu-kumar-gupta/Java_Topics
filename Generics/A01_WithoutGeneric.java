package Generics;

public class A01_WithoutGeneric {
    public static void main(String[] args) {
        IntPrint iObj = new IntPrint(23);
        iObj.print();

        DoublePrint dObj = new DoublePrint(2.67);
        dObj.print();

//        Output
//        23
//        2.67
    }
}

// Using diff classes to print diff types of objects

// Class to print Integer
class IntPrint {
    Integer toPrint;
    IntPrint(Integer i) {
        this.toPrint = i;
    }

    public void print() {
        System.out.println(toPrint);
    }
}

// Class to print Double
class DoublePrint {
    Double toPrint;
    DoublePrint(Double d) {
        this.toPrint = d;
    }

    public void print() {
        System.out.println(toPrint);
    }
}