// An Enum class
enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

// Driver class that contains an object of "day" and
// main().
public class Enum1 {
    // Prints a line about Day using switch
    public void dayIsLike(Day day) {
        switch (day) {
        case MONDAY:
            System.out.println("Mondays are bad.");
            break;
        case FRIDAY:
            System.out.println("Fridays are better.");
            break;
        case SATURDAY:
        case SUNDAY:
            System.out.println("Weekends are best.");
            break;
        default:
            System.out.println("Midweek days are so-so.");
            break;
        }
    }

    // Driver method
    public static void main(String[] args) {
        String str = "MONDAY";
        Day d1 = Day.FRIDAY;
        Enum1 t1 = new Enum1();

        // Using valueOf(). Returns an object of
        // Day with given constant.
        t1.dayIsLike(Day.valueOf(str));

        t1.dayIsLike(Day.SATURDAY);
        t1.dayIsLike(d1);

        System.out.println("Printing days directly:");
        // We can iterate thorugh constants of Enum like this
        for(Day d:Day.values())
            System.out.print(d+ "   ");
        
        // Also we can assign values to array
        Day arr[] = Day.values();
        System.out.println("Printing days with array iteration:");
        for(Day d:arr)
            System.out.print(d+ "  :  ");

        // We can get index of enum values by ordinal() method
        System.out.println("\nIndex of Wednesday: "+Day.WEDNESDAY.ordinal());
    }
}
