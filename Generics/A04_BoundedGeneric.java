package Generics;

public class A04_BoundedGeneric {
    public static void main(String[] args) {
        // The class can have Generic as Animal class or its extension(Bounded)
        // Any other class is not permitted
        PrintAnimal<A03_Animal> aObj = new PrintAnimal<>(new A03_Animal());
        aObj.print();
        PrintAnimal<Cat> cObj = new PrintAnimal<>(new Cat());
        cObj.print();
        PrintAnimal<Dog> dObj = new PrintAnimal<>(new Dog());
        dObj.print();

//      PrintAnimal<Integer> iObj = new PrintAnimal<Integer>(290); gives error

//        Output
//        Animal
//        Cat
//        Dog        
    }
}

//Class that have Generic as Animal class or any subclass of Animal
class PrintAnimal<T extends A03_Animal> {  //T can have any name
    T toPrint;
    PrintAnimal(T t) {
        this.toPrint = t;
    }

    public void print() {
        toPrint.type();
    }
}
