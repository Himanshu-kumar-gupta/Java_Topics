import java.text.NumberFormat;
import java.util.Locale;

public class LocalCurrency1 {
    public static void main(String[] args) {
        double amount = 1234567.89;

        // Different locales
        Locale us = Locale.US;
        Locale france = Locale.FRANCE;
        Locale india = new Locale("en", "IN");
        Locale japan = Locale.JAPAN;

        // Format currency
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(us);
        NumberFormat frFormat = NumberFormat.getCurrencyInstance(france);
        NumberFormat inFormat = NumberFormat.getCurrencyInstance(india);
        NumberFormat jpFormat = NumberFormat.getCurrencyInstance(japan);

        System.out.println("=== Currency Localization ===");
        System.out.println("US:      " + usFormat.format(amount));
        System.out.println("France:  " + frFormat.format(amount));
        System.out.println("India:   " + inFormat.format(amount));
        System.out.println("Japan:   " + jpFormat.format(amount));
    }
}
