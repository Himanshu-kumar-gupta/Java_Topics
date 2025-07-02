class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }

    void legs() {
        System.out.println("No of legs in animal");
    }
}

class Dog extends Animal {

    //Overriden method cannot be less accessible than parent method
    // private void makeSound(){  // results in error (attempting to assign weaker access privileges; was package)
    //     System.out.println("Dog barks");
    // }

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }

    void fetch() {
        System.out.println("Dog fetches");
    }
}

public class OverrideUpAndDownCasting1 {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Upcasting: Dog object assigned to Animal reference, it is implicitly allowed in java

        //When overidden method is called then upcasting uses subclass method
        //Also called virtual method invocation
        myAnimal.makeSound(); // Calls Dog's overridden makeSound()


        //We can easily use any methods of Animal class
        //As the object reference is of Animal type
        myAnimal.legs();

        // We cannot use any method of subclass that is not 
        // overidden for myAnimal object, which is of superclass type(Animal) but has object of subclass
        //myAnimal.fetch(); //results in error (variable myAnimal of type Animal)
        
        if (myAnimal instanceof Dog) { // Check before downcasting for safety
            Dog myDog = (Dog) myAnimal; // Downcasting: Animal reference explicitly cast to Dog
            myDog.fetch(); // Accesses Dog-specific method

            System.out.println(myDog instanceof Animal);
            //We can use method of Animal class/superclass, after Downcasting also
            myDog.legs();
        } else {
            System.out.println("Cannot downcast to Dog.");
        }
    }
}