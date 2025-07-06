class AnonymousDemo {

    // Method of helper class
    void show()
    {
        // Print statement
        System.out.println(
            "i am in show method of Anonymous super class");
    }
}

interface Hello {
    void show();
    void great();
}

class Outer {

    private String outerName = "OuterClass";

    // 1. Member (non-static) inner class
    public class MemberInner {
        public void show() {
            System.out.println("Member Inner Class: Accessing outerName = " + outerName);
        }
    }
    private static void outerMethod()
    {
        System.out.println("inside outerMethod");
    }

    // 2. Static nested class
    public static class StaticNested {
        public void show() {
            System.out.println("Static Nested Class: Cannot access non-static members directly.");
        }

        public static void display()
        {
            System.out.println("inside inner class Method");

            //can access static member/methods of outerclass
            outerMethod();
        }
    }

    // Method demonstrating local inner class
    public void demonstrateLocalInner() {
        int localValue = 10;

        // 3. Local inner class
        class LocalInner {
            public void show() {
                System.out.println("Local Inner Class: localValue = " + localValue);
                System.out.println("Local Inner Class: outerValue = " + outerName);
            }
        }

        LocalInner li = new LocalInner();
        li.show();
    }

    // Method demonstrating anonymous inner class
    public void demonstrateAnonymousInner() {
        // 4. Anonymous inner class
       AnonymousDemo d1 = new AnonymousDemo() {

            @Override
            void show()
            {
                // Calling method show() via super keyword
                // which refers to parent class
                super.show();

                System.out.println("i am in Anonymous Inner class1");
            }
        };

        d1.show();

        // 4. Anonymous inner class using interface
        Hello h1 = new Hello() {
      
            @Override
            public void show()
            {
                System.out.println("i am in Anonymous Inner class2");
            }

            @Override
            public void great()
            {
                System.out.println("God is great");
            }
        };

        h1.show();
        h1.great();
    }
}

public class InnerClass1 {

    //can also be used like this or like any Inner class
    static Hello h = new Hello() {
        public void show()
        {
            System.out.println("i am in static Anonymous Inner class");
        }

        public void great()
        {
            System.out.println("God is great");
        }
    };
    public static void main(String[] args) {
        Outer outer = new Outer();

        // 1. Member (non-static) inner class
        Outer.MemberInner member = outer.new MemberInner();
        member.show();

        //1. can also be done like this
        Outer.MemberInner member2 = new Outer().new MemberInner();
        member2.show();

        // 2. Static nested class
        Outer.StaticNested nested = new Outer.StaticNested();
        // here we are accessing a non-static method
        nested.show();

        //2. A static method/variable in a staticNested Inner class can be accessed directly
        Outer.StaticNested.display();

        // 3. Local inner class
        outer.demonstrateLocalInner();

        // 4. Anonymous inner class
        outer.demonstrateAnonymousInner();

        // Static Anonymous Inner class can be used directly
        h.show();
        h.great();
    }
}
