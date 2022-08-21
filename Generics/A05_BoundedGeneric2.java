package Generics;

import java.io.Serializable;

// The Generic type can extend any number of interfaces seperated with &
// With both classes and interfaces extends keywords is used
// It can only extend single class as Java doesn't support multiple inheritance through classes
// If class is used it must be at the beginning
// T extends Serializable & A03_Animal & Cloneable and T extends Cloneable & Serializable & A03_Animal - gives error
class PrintAnimal2<T extends A03_Animal & Serializable & Cloneable> {  //T can have any name
    T toPrint;
    PrintAnimal2(T t) {
        this.toPrint = t;
    }

    public void print() {
        toPrint.type();
    }
}
