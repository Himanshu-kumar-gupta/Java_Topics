import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimeStorage1 {
    public static void main(String[] args) throws InterruptedException {
        // ===============================
        // Instant (a machine timestamp, UTC-based)
        // ===============================
        System.out.println("=== Instant Demo ===");
        Instant now = Instant.now();
        System.out.println("Current Instant: " + now);

        // Sleep for 1 second to show passage of time
        Thread.sleep(1000);
        Instant later = Instant.now();
        System.out.println("Later Instant: " + later);

        // Compare instants
        System.out.println("Is now before later? " + now.isBefore(later));
        System.out.println("Seconds elapsed: " + now.until(later, ChronoUnit.SECONDS));
        System.out.println("Millis elapsed: " + now.until(later, ChronoUnit.MILLIS));

        // ===============================
        // Duration (time-based amount, hours/min/sec/nanos)
        // ===============================
        System.out.println("\n=== Duration Demo ===");
        Duration twoHours = Duration.ofHours(2);
        System.out.println("Duration of 2 hours: " + twoHours);

        LocalTime t1 = LocalTime.of(10, 0);
        LocalTime t2 = LocalTime.of(12, 30);
        Duration betweenTimes = Duration.between(t1, t2);
        System.out.println("Duration between 10:00 and 12:30 = " + betweenTimes);

        // Add/Subtract durations
        LocalTime newTime = t1.plus(twoHours);
        System.out.println("10:00 + 2 hours = " + newTime);

        // ===============================
        // Period (date-based amount, years/months/days)
        // ===============================
        System.out.println("\n=== Period Demo ===");
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusMonths(5).plusDays(10);
        Period period = Period.between(today, futureDate);
        System.out.println("Today: " + today);
        System.out.println("Future date: " + futureDate);
        System.out.println("Period between = " + period);
        System.out.println("Years: " + period.getYears() +
                           ", Months: " + period.getMonths() +
                           ", Days: " + period.getDays());

        // Adding a period
        LocalDate oneYearLater = today.plus(Period.ofYears(1));
        System.out.println("One year later: " + oneYearLater);

        // ===============================
        // ChronoUnit (general purpose units)
        // ===============================
        System.out.println("\n=== ChronoUnit Demo ===");
        LocalDate birthday = LocalDate.of(2000, 1, 1);
        long daysAlive = birthday.until(today, ChronoUnit.DAYS);
        long monthsAlive = birthday.until(today, ChronoUnit.MONTHS);
        long yearsAlive = birthday.until(today, ChronoUnit.YEARS);

        System.out.println("Birthday: " + birthday);
        System.out.println("Today: " + today);
        System.out.println("Alive for " + yearsAlive + " years, " +
                           monthsAlive + " months, " +
                           daysAlive + " days.");

        // Using ChronoUnit with Instant
        long millisBetween = ChronoUnit.MILLIS.between(now, later);
        System.out.println("Millis between instants: " + millisBetween);

        // ===============================
        // DST Effect: Period vs Duration
        // ===============================
        System.out.println("\n=== DST Effect: Period vs Duration ===");
        ZoneId newYork = ZoneId.of("America/New_York");

        // DST transition in March 2025: clocks move forward at 2 AM → 3 AM
        LocalDateTime beforeDST = LocalDateTime.of(2025, 3, 9, 1, 30);
        ZonedDateTime zdtBefore = beforeDST.atZone(newYork);
        System.out.println("Original ZonedDateTime: " + zdtBefore);

        // Add 1 day using Period (calendar-based)
        ZonedDateTime plusPeriod = zdtBefore.plus(Period.ofDays(1));
        System.out.println("After +1 Day (Period): " + plusPeriod);

        // Add 1 day using Duration (24h-based)
        ZonedDateTime plusDuration = zdtBefore.plus(Duration.ofDays(1));
        System.out.println("After +1 Day (Duration): " + plusDuration);

        // Compare wall-clock times
        System.out.println("Period result wall-clock hour: " + plusPeriod.getHour());
        System.out.println("Duration result wall-clock hour: " + plusDuration.getHour());  //get hour of day
    }
}