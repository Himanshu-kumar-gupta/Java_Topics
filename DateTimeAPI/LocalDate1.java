import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;

public class LocalDate1 {
    public static void main(String[] args) {
        // 1. Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        // 2. Creating a specific date
        LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
        System.out.println("India's Independence Day: " + independenceDay);

        // 3. Parsing from String
        LocalDate parsedDate = LocalDate.parse("2025-09-02"); // ISO format yyyy-MM-dd
        System.out.println("Parsed Date: " + parsedDate);

        // 4. Getting individual fields
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Month Value: " + today.getMonthValue());
        System.out.println("Day of Month: " + today.getDayOfMonth());
        System.out.println("Day of Week: " + today.getDayOfWeek());
        System.out.println("Day of Year: " + today.getDayOfYear());

        // 5. Adding and subtracting dates
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("One week later: " + nextWeek);
        System.out.println("One month before: " + lastMonth);

        // 6. Comparing dates
        if (today.isAfter(independenceDay)) {
            System.out.println(today + " is after " + independenceDay);
        }
        if (independenceDay.isBefore(today)) {
            System.out.println(independenceDay + " is before " + today);
        }
        System.out.println("Is leap year? " + today.isLeapYear());

        // 7. With methods (immutable)
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        System.out.println("First day of this month: " + firstDayOfMonth);

        // 8. Getting constants
        LocalDate maxDate = LocalDate.MAX;
        LocalDate minDate = LocalDate.MIN;
        System.out.println("Max LocalDate: " + maxDate);
        System.out.println("Min LocalDate: " + minDate);

        // 9. DayOfWeek example
        DayOfWeek dow = today.getDayOfWeek();
        System.out.println("Today is: " + dow);
    }
}
