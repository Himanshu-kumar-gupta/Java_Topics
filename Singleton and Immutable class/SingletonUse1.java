class Singleton {
    
    private static Singleton instance;

    //Ensures other constructor cannot be used/ so cannot be accessed by object
    private Singleton()
    {
        System.out.println("Singleton is Instantiated.");
    } 

    //single point of access for instance
    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public static void doSomething()
    {
        System.out.println("Somethong is Done.");
    }
}

public class SingletonUse1 {
    public static void main(String[] args)
    {
        Singleton.getInstance().doSomething();

        // Singleton ab = new Singleton(); //error: Singleton() has private access in Singleton
        // Singleton ab = new Singleton(5); //error:constructor Singleton in class Singleton cannot be applied to given types
    }
}
