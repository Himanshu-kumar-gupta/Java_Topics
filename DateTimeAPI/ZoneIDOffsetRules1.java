import java.time.*;
import java.time.zone.*;
import java.util.Set;

public class ZoneIDOffsetRules1 {
    public static void main(String[] args) {
        // -------------------------------
        // ZoneId Examples
        // -------------------------------
        System.out.println("=== ZoneId ===");
        ZoneId systemZone = ZoneId.systemDefault();
        ZoneId kolkataZone = ZoneId.of("Asia/Kolkata");
        ZoneId newYorkZone = ZoneId.of("America/New_York");

        System.out.println("System Default Zone: " + systemZone);
        System.out.println("Asia/Kolkata Zone: " + kolkataZone);
        System.out.println("America/New_York Zone: " + newYorkZone);

        // List a few available zone IDs
        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println("\nTotal Zones available: " + zones.size());
        zones.stream().limit(10).forEach(System.out::println);

        // -------------------------------
        // ZoneOffset Examples
        // -------------------------------
        System.out.println("\n=== ZoneOffset ===");
        ZoneOffset offsetPlus530 = ZoneOffset.of("+05:30");
        ZoneOffset offsetMinus400 = ZoneOffset.ofHoursMinutes(-4, 0);

        System.out.println("ZoneOffset +05:30: " + offsetPlus530);
        System.out.println("ZoneOffset -04:00: " + offsetMinus400);

        // Treat ZoneOffset as ZoneId
        ZoneId zoneFromOffset = offsetPlus530;
        System.out.println("ZoneId created from ZoneOffset: " + zoneFromOffset); 

        // -------------------------------
        // ZoneRules Examples
        // -------------------------------
        System.out.println("\n=== ZoneRules ===");
        ZoneRules kolkataRules = kolkataZone.getRules();
        ZoneRules nyRules = newYorkZone.getRules();

        System.out.println("Kolkata ZoneRules: " + kolkataRules);
        System.out.println("New York ZoneRules: " + nyRules);

        // Current offsets
        Instant now = Instant.now();
        System.out.println("Current Offset in Kolkata: " + kolkataRules.getOffset(now));
        System.out.println("Current Offset in New York: " + nyRules.getOffset(now));

        // Check if DST applies in New York
        boolean isNYInDST = nyRules.isDaylightSavings(now);
        System.out.println("Is New York in Daylight Savings now? " + isNYInDST);

        // Next transition in New York (if exists)
        ZoneOffsetTransition nextTransition = nyRules.nextTransition(now);
        System.out.println("Next DST transition in New York: " + nextTransition);

        if (nextTransition != null) {
            System.out.println("Transition DateTime: " + nextTransition.getDateTimeBefore());

            // Check if it's a gap or overlap
            if (nextTransition.isGap()) {
                System.out.println("This transition is a GAP (time skipped, clocks jump forward).");
            } else if (nextTransition.isOverlap()) {
                System.out.println("This transition is an OVERLAP (time repeated, clocks go backward).");
            }

            // Show offsets before and after transition
            System.out.println("Offset Before: " + nextTransition.getOffsetBefore());
            System.out.println("Offset After : " + nextTransition.getOffsetAfter());
        }
    }
}