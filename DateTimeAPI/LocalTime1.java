import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTime1 {
    public static void main(String[] args) {
        // 1. Current time
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        // 2. Creating specific time
        LocalTime lunchTime = LocalTime.of(13, 30); // 1:30 PM
        System.out.println("Lunch Time: " + lunchTime);

        // 3. Parsing from String
        LocalTime parsedTime = LocalTime.parse("20:15:30"); // HH:mm:ss
        System.out.println("Parsed Time: " + parsedTime);

        // 4. Getting individual fields
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());
        System.out.println("Nano: " + now.getNano());

        // 5. Adding and subtracting time
        LocalTime plusHours = now.plusHours(2);
        LocalTime minusMinutes = now.minusMinutes(45);
        System.out.println("2 hours later: " + plusHours);
        System.out.println("45 minutes earlier: " + minusMinutes);

        // 6. Comparing times
        if (now.isAfter(lunchTime)) {
            System.out.println("Now is after lunch time");
        } else if (now.isBefore(lunchTime)) {
            System.out.println("Now is before lunch time");
        }

        // 7. Using with methods (immutable)
        // withMinute(5) - returns a copy of LocalTime instance, with only minutes changed to 5
        LocalTime startOfDay = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println("Start of the day: " + startOfDay);

        LocalTime endOfDay = LocalTime.MAX;
        System.out.println("End of the day: " + endOfDay);

        // 8. Constants
        System.out.println("LocalTime.MIN (00:00): " + LocalTime.MIN);
        System.out.println("LocalTime.NOON (12:00): " + LocalTime.NOON);
        System.out.println("LocalTime.MIDNIGHT (00:00): " + LocalTime.MIDNIGHT);
        System.out.println("LocalTime.MAX (23:59:59.999999999): " + LocalTime.MAX);

        // 9. TruncatedTo example
        LocalTime truncatedToMinutes = now.truncatedTo(ChronoUnit.MINUTES);
        LocalTime truncatedToHours = now.truncatedTo(ChronoUnit.HOURS);
        System.out.println("Truncated to Minutes: " + truncatedToMinutes);
        System.out.println("Truncated to Hours: " + truncatedToHours);

        // 10. until() example
        long hoursUntilLunch = now.until(lunchTime, ChronoUnit.HOURS);
        long minutesUntilLunch = now.until(lunchTime, ChronoUnit.MINUTES);
        System.out.println("Hours until lunch: " + hoursUntilLunch);
        System.out.println("Minutes until lunch: " + minutesUntilLunch);
    }
}
