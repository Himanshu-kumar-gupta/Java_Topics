interface Vehicle {
    void start(); // abstract

    default void stop() {
        System.out.println("Stopping...");
    }

    static void info() {
        System.out.println("Vehicle Interface");
    }
}

class GetVehicle implements Vehicle {

    @Override
    public void start(){
        System.out.println("Starting...");
    }

    @Override
    public void stop(){  //default method is overridden
        System.out.println("Stopping in GetVehicle");
    }
}
public class Interface1 {

    public static void main(String[] args) {
        //Static method of Interface can be accessed directly
        Vehicle.info();

        Vehicle v1 = new GetVehicle();
        v1.stop();
        v1.start();

        //Static method of Interface cannot be accessed via a object
        // v1.info(); //error
    }

}
