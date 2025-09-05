import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class DateTimeFormatter1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Original LocalDateTime: " + now);

        // ===============================
        // 1. Predefined Formatters
        // ===============================
        System.out.println("\n=== Predefined Formatters ===");
        System.out.println("ISO_LOCAL_DATE: " + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("ISO_LOCAL_DATE_TIME: " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("ISO_ZONED_DATE_TIME (with zone): " +
                ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        System.out.println("BASIC_ISO_DATE: " + now.format(DateTimeFormatter.BASIC_ISO_DATE));

        // ===============================
        // 2. Localized Formatters
        // ===============================
        System.out.println("\n=== Localized Formatters ===");
        DateTimeFormatter shortFmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                                                      .withLocale(Locale.US);
        DateTimeFormatter mediumFmt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                                       .withLocale(Locale.UK);
        DateTimeFormatter longFmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                                                     .withLocale(Locale.FRANCE);

        System.out.println("Short (US): " + now.format(shortFmt));
        System.out.println("Medium (UK): " + now.format(mediumFmt));
        System.out.println("Long (France): " + now.format(longFmt));

        // ===============================
        // 3. Custom Patterns
        // ===============================
        System.out.println("\n=== Custom Patterns ===");
        DateTimeFormatter custom1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter custom2 = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy hh:mm a", Locale.US);
        DateTimeFormatter custom3 = DateTimeFormatter.ofPattern("yyyy/MM/dd G 'at' HH:mm:ss z")
                                                     .withZone(ZoneId.of("Asia/Tokyo"));

        System.out.println("Pattern 1: " + now.format(custom1));
        System.out.println("Pattern 2: " + now.format(custom2));
        System.out.println("Pattern 3 (Tokyo): " + custom3.format(Instant.now())); //it expects a time-zone abbreviation

        // ===============================
        // 4. Parsing Examples
        // ===============================
        System.out.println("\n=== Parsing Strings into Dates ===");
        String dateStr = "05-09-2025 19:30:45";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateStr, custom1);
        System.out.println("Parsed LocalDateTime: " + parsedDateTime);

        String simpleDate = "2025-09-04";
        LocalDate parsedDate = LocalDate.parse(simpleDate, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Parsed LocalDate: " + parsedDate);

        String timeStr = "11:45:30";
        LocalTime parsedTime = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Parsed LocalTime: " + parsedTime);


        //Fluent approach
        System.out.println("\n=== Fluent Approach ===");
        LocalDate myBday = Year.of(1970)
                .atMonth(Month.JUNE)   // attach month
                .atDay(11);            // attach day
        System.out.println("My Birthday: " + myBday);

        ZonedDateTime flight = LocalDate.of(2025, Month.SEPTEMBER, 10)
                .atTime(22, 15)                  // local time
                .atZone(ZoneId.of("Asia/Tokyo")) // attach zone
                .plusHours(12);                  // add flight duration
        System.out.println("Flight arrival Tokyo+12h: " + flight);
    }
}