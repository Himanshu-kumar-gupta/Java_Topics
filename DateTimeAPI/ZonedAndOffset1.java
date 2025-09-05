import java.time.*;
import java.time.zone.ZoneRules;

public class ZonedAndOffset1 {
    public static void main(String[] args) {
        // -------------------------------
        // ZonedDateTime Basics
        // -------------------------------
        System.out.println("=== ZonedDateTime Basic Usage ===");

        ZonedDateTime nowDefault = ZonedDateTime.now();
        ZonedDateTime nowKolkata = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime nowNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println("System Default ZonedDateTime: " + nowDefault);
        System.out.println("Asia/Kolkata ZonedDateTime:   " + nowKolkata);
        System.out.println("America/New_York ZonedDateTime: " + nowNewYork);

        // Convert between zones (same instant, different representation)
        ZonedDateTime converted = nowKolkata.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("Kolkata -> London (same instant): " + converted);

        // Same local time, different region
        ZonedDateTime shifted = nowKolkata.withZoneSameLocal(ZoneId.of("Europe/London"));
        System.out.println("Kolkata -> London (same local): " + shifted);

        // -------------------------------
        // Gap & Overlap Example
        // -------------------------------
        System.out.println("\n=== ZonedDateTime Gap/Overlap Example ===");

        ZoneId nyZone = ZoneId.of("America/New_York");
        ZoneRules nyRules = nyZone.getRules();

        // Spring forward (Gap) – DST starts, local time jumps forward 1 hour
        LocalDate gapDate = LocalDate.of(2025, 3, 9); // 2 AM is skipped in New York
        LocalTime gapTime = LocalTime.of(2, 30);
        LocalDateTime gapLocal = LocalDateTime.of(gapDate, gapTime);
        ZonedDateTime gapZdt = ZonedDateTime.ofLocal(gapLocal, nyZone, null);

        System.out.println("Trying to create 2025-03-09T02:30 in New York:");
        System.out.println("Result (adjusted forward to valid time): " + gapZdt);

        // Fall back (Overlap) – DST ends, local time repeats 1 hour
        LocalDate overlapDate = LocalDate.of(2025, 11, 2); // 2 AM happens twice
        LocalTime overlapTime = LocalTime.of(1, 30);
        LocalDateTime overlapLocal = LocalDateTime.of(overlapDate, overlapTime);

        /* 
        Why in below lines Instant.parse() has that time:

        | UTC Instant           | Local NY Time | Offset |
        | --------------------- | ------------- | ------ |
        | 2025-11-02 **05:00Z** | 01:00 **EDT** | -04:00 |
        | 2025-11-02 **06:00Z** | 01:00 **EST** | -05:00 |
        | 2025-11-02 **07:00Z** | 02:00 EST     | -05:00 |

        ofLocal(LocalDateTime localDateTime, ZoneId zone, ZoneOffset preferredOffset) needs a specific offset to resolve ambiguity when the same local time happens twice (DST overlap).

        In New York on 2025-11-02, the local time 01:30 occurs two times:
            First with DST offset -04:00 (before clocks roll back).
            Then with Standard offset -05:00 (after clocks roll back).
        To tell Java which offset you want, you need to pass a ZoneOffset.
        Thus we take ZoneOffSet from nyRules

        */
        ZonedDateTime overlapFirst = ZonedDateTime.ofLocal(overlapLocal, nyZone, nyRules.getOffset(Instant.parse("2025-11-02T05:00:00Z")));
        ZonedDateTime overlapSecond = ZonedDateTime.ofLocal(overlapLocal, nyZone, nyRules.getOffset(Instant.parse("2025-11-02T06:00:00Z")));

        System.out.println("\nTrying to create 2025-11-02T01:30 in New York:");
        System.out.println("First occurrence (DST offset):  " + overlapFirst);
        System.out.println("Second occurrence (Standard offset): " + overlapSecond);

        // -------------------------------
        // OffsetDateTime Usage
        // -------------------------------
        System.out.println("\n=== OffsetDateTime Usage ===");

        OffsetDateTime offsetNow = OffsetDateTime.now();
        OffsetDateTime offset530 = OffsetDateTime.now(ZoneOffset.ofHoursMinutes(5, 30));
        OffsetDateTime offsetMinus400 = OffsetDateTime.now(ZoneOffset.ofHours(-4));

        System.out.println("OffsetDateTime (system default offset): " + offsetNow);
        System.out.println("OffsetDateTime (+05:30): " + offset530);
        System.out.println("OffsetDateTime (-04:00): " + offsetMinus400);

        // Conversion between ZonedDateTime and OffsetDateTime
        OffsetDateTime fromZdt = nowNewYork.toOffsetDateTime();
        System.out.println("ZonedDateTime (New York) -> OffsetDateTime: " + fromZdt);

        // -------------------------------
        // Working with Multiple Zones
        // -------------------------------
        System.out.println("\n=== Working with Multiple Time Zones ===");

        // Suppose we schedule a meeting 6 hours from now
        Instant meetingInstant = Instant.now().plus(Duration.ofHours(6)); //Remember this in UTC not IST, and IST is already +5:30
        ZonedDateTime meetingNY = meetingInstant.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime meetingIndia = meetingInstant.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("Meeting Instant (UTC): " + meetingInstant);
        System.out.println("Meeting Time in New York: " + meetingNY);
        System.out.println("Meeting Time in India: " + meetingIndia);

        // Convert same instant to other zones using atZoneSameInstant()
        ZonedDateTime meetingLondon = meetingNY.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime meetingTokyo = meetingNY.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        System.out.println("Meeting Time in London:   " + meetingLondon);
        System.out.println("Meeting Time in Tokyo:    " + meetingTokyo);

        // Difference between withZoneSameInstant() and withZoneSameLocal()
        ZonedDateTime londonSameLocal = meetingNY.withZoneSameLocal(ZoneId.of("Europe/London"));
        System.out.println("\nLondon (same local time, not same instant): " + londonSameLocal);
    }
}