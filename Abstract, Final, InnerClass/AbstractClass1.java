// Java program to illustrate the
// concept of Abstraction & Abstract class
abstract class Shape {
    String color;

    // these are abstract methods
    abstract double area();
    public abstract String toString();

    // abstract class can have the constructor, but can only be used by inherited classes
    public Shape(String color)
    {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // this is a concrete method
    public String getColor() { return color; }
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius)
    {

        // calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override 
    double area()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override 
    public String toString()
    {
        return "Circle color is " + super.getColor()
            + " and area is : " + area();
    }
}

class Rectangle extends Shape {

    double length;
    double width;

    public Rectangle(String color, double length,
                     double width)
    {
        // calling Shape constructor
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }

    @Override 
    double area() { return length * width; }

    @Override 
    public String toString()
    {
        return "Rectangle color is " + super.getColor()
            + " and area is : " + area();
    }
}

abstract class TestAbstractClass {

    //abstract class can have only concrete method also
    void printName(String name) {
        System.out.println("Name is "+name);
    }

    // staic method
    static void demofun()
    {
        System.out.println("Static method in abstract class");
    }
}

class ExtendFormality extends TestAbstractClass{}

public class AbstractClass1 {
    public static void main(String[] args)
    {
        // error: Shape is abstract; cannot be instantiated
        // Shape notPossible = new Shape("Green");

        //We can have reference of Abstract class type. 
        Shape s1 = new Circle("Red", 2.2);
        Shape s2 = new Rectangle("Yellow", 2, 4);

        // Shape s3 = new Circle(); // error: this constructor cannot be applied
        Rectangle rect1 = new Rectangle("Blue", 5, 2);

        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(rect1.toString());

        TestAbstractClass t1 = new ExtendFormality();
        t1.printName("Himanshu");

        //Can call static methods directly
        TestAbstractClass.demofun();

        t1.demofun();
    }
}
