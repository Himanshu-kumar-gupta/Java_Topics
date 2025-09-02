import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Month;

public class LocalDateTime1 {
    public static void main(String[] args) {
        // 1. Current Date-Time
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current DateTime: " + now);

        // 2. Creating a specific Date-Time
        LocalDateTime independenceDay = LocalDateTime.of(1947, Month.AUGUST, 15, 0, 0);
        System.out.println("India's Independence DateTime: " + independenceDay);

        // 3. Parsing from String
        LocalDateTime parsedDateTime = LocalDateTime.parse("2025-12-31T23:59:59");
        System.out.println("Parsed DateTime: " + parsedDateTime);

        // 4. Getting individual fields
        System.out.println("Year: " + now.getYear());
        System.out.println("Month: " + now.getMonth());
        System.out.println("Day of Month: " + now.getDayOfMonth());
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Second: " + now.getSecond());

        // 5. Adding and subtracting
        LocalDateTime nextWeek = now.plusWeeks(1);
        LocalDateTime yesterday = now.minusDays(1);
        System.out.println("One week later: " + nextWeek);
        System.out.println("One day before: " + yesterday);

        // 6. Comparing
        if (now.isAfter(independenceDay)) {
            System.out.println("Now is after Independence Day 1947");
        }
        if (independenceDay.isBefore(now)) {
            System.out.println("Independence Day 1947 is before now");
        }

        // 7. Immutable updates (withXxx)
        LocalDateTime firstDayOfMonth = now.withDayOfMonth(1).withHour(0).withMinute(0);
        System.out.println("First day of this month at midnight: " + firstDayOfMonth);

        // 8. Formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        System.out.println("Formatted DateTime: " + formattedDateTime);

        // 9. truncatedTo()
        LocalDateTime truncatedToHours = now.truncatedTo(ChronoUnit.HOURS);
        LocalDateTime truncatedToMinutes = now.truncatedTo(ChronoUnit.MINUTES);
        System.out.println("Truncated to Hours: " + truncatedToHours);
        System.out.println("Truncated to Minutes: " + truncatedToMinutes);

        // 10. until()
        long daysUntilNewYear = now.until(LocalDateTime.of(now.getYear(), 12, 31, 23, 59), ChronoUnit.DAYS);
        long hoursUntilNewYear = now.until(LocalDateTime.of(now.getYear(), 12, 31, 23, 59), ChronoUnit.HOURS);
        System.out.println("Days until New Year: " + daysUntilNewYear);
        System.out.println("Hours until New Year: " + hoursUntilNewYear);

        // 11. Working with LocalDate + LocalTime
        LocalDate datePart = LocalDate.of(2025, Month.SEPTEMBER, 2);
        LocalTime timePart = LocalTime.of(15, 45, 30);
        LocalDateTime combined = LocalDateTime.of(datePart, timePart);
        System.out.println("Combined LocalDate + LocalTime: " + combined);

        // Extract back LocalDate and LocalTime from LocalDateTime
        LocalDate extractedDate = combined.toLocalDate();
        LocalTime extractedTime = combined.toLocalTime();
        System.out.println("Extracted LocalDate: " + extractedDate);
        System.out.println("Extracted LocalTime: " + extractedTime);

        // 12. Constants
        System.out.println("LocalDateTime.MIN: " + LocalDateTime.MIN);
        System.out.println("LocalDateTime.MAX: " + LocalDateTime.MAX);
    }
}