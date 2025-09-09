import java.io.*;

class MyObject implements Serializable {
    private String name;
    private int id;
    private transient String secretInfo; // This field will not be serialized
    static int base = 100; //not serialized

    public MyObject(String name, int id, String secretInfo) {
        this.name = name;
        this.id = id;
        this.secretInfo = secretInfo;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getSecretInfo() {return secretInfo;}
}

public class Serialization1 {
    public static void main(String[] args) {
        MyObject originalObject = new MyObject("TestUser", 123, "confidential");
        String filename = "object.ser";
        MyObject.base = 500;

        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(originalObject);
            System.out.println("Object serialized and saved to " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }

        // Deserialization
        MyObject deserializedObject = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedObject = (MyObject) in.readObject();
            System.out.println("Object deserialized from " + filename);
        } catch (IOException | ClassNotFoundException c) {
            c.printStackTrace();
        }

        if (deserializedObject != null) {
            System.out.println("Deserialized Object Name: " + deserializedObject.getName());
            System.out.println("Deserialized Object ID: " + deserializedObject.getId());
            // secretInfo will be null because it was transient
            System.out.println("Deserialized Object Secret: " + deserializedObject.getSecretInfo());
            System.out.println("Deserialized Object Base: " + deserializedObject.base);
        }
        //static field value are sourced from current class value
        System.out.println("Original Object Base: " + originalObject.base);
    }
}