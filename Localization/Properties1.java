import java.io.*;
import java.util.*;

public class Properties1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        String fileName = "app.properties";

        // System property (put in cmd using -D option)
        System.out.println("Running as user: " + System.getProperty("username"));
        System.out.println("User home: " + System.getProperty("userhome"));

        // Take input from console
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter app version: ");
            String version = sc.nextLine();

            System.out.print("Enter author name: ");
            String author = sc.nextLine();

            // Write to properties file
            props.setProperty("app.version", version);
            props.setProperty("app.author", author);

            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                props.store(fos, "Application Settings");
                System.out.println("Properties saved to " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Read back properties file
        try (FileInputStream fis = new FileInputStream(fileName)) {
            props.load(fis);
            System.out.println("=== Loaded Properties ===");
            props.forEach((k, v) -> System.out.println(k + ": " + v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Output with commands used:
 * 
 * PS C:\Oracle Data\Learning\Java SE 8 Developer\Codes\Localization> javac Properties1.java                                                         
PS C:\Oracle Data\Learning\Java SE 8 Developer\Codes\Localization> java -Dusername=Himanshu -Duserhome=Gkp Properties1        
Running as user: Himanshu
User home: Gkp
Enter app version: 1.2
Enter author name: golu
Properties saved to app.properties
=== Loaded Properties ===
app.author: golu
app.version: 1.2
 */
