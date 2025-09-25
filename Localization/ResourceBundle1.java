import java.util.*;

public class ResourceBundle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose language (hi/fr): ");
        String choice = sc.nextLine().trim().toLowerCase();

        Locale locale;
        switch (choice) {
            case "fr":
                locale = new Locale("fr", "FR");
                break;
            case "hi":
                locale =  new Locale("hi", "IN");
                break;
            default:
                locale = Locale.getDefault();
                break;
        }

        // Load resource bundle based on chosen locale
        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);

        System.out.println("\n=== Messages ===");
        System.out.println(bundle.getString("greeting"));
        System.out.println(bundle.getString("inquiry"));
        System.out.println(bundle.getString("farewell"));

        sc.close();
    }
}
