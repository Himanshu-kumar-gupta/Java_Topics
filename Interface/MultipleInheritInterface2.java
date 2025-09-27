interface One {

    // public, static and final
    int a = 10;
    public void print_geek();
}

interface Two {
    public void print_for();
}

interface Three extends One, Two {
    public void print_geek();
}

class Child implements One,Two {  //Three can be used instead of One,Two and result would be same
    @Override 
    public void print_geek()
    {
        System.out.println("Geeks");
    }

    public void print_for() { System.out.println("for"); }
}

// Drived class
public class MultipleInheritInterface2 {
    public static void main(String[] args)
    {
        Child a = new Child();
        System.out.println(a instanceof One);
        Two c = new Child();
        System.out.println(c instanceof Child);
        // c.a =15; error as a is final

        //As c is of Two type this operation os not allowed
        // System.out.println(c.a);

        //As field is static it can be accessed directly
        System.out.println(One.a);

        //As object is of Child, it can be cast to One type
        System.out.println(((One)c).a);
        ((One)c).print_geek();
        c.print_for();

        // c.print_geek(); //error as c is of Two type it cannot access print_greek
        // not able to do virtual method invocation

        a.print_geek();
    }
}
