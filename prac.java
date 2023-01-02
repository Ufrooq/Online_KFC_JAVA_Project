import java.util.Calendar;

public class prac {
    public static void main(String[] args) {
        // Get the current month and year
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        // Print the calendar for the current month
        printCalendar(month, year);
    }

    public static void printCalendar(int month, int year) {
        // Create a Calendar object for the specified month and year
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);

        // Print the calendar header
        System.out.println("Su Mo Tu We Th Fr Sa");

        // Get the first day of the month
        int firstDay = calendar.get(Calendar.DAY_OF_WEEK);

        // Print the appropriate number of leading spaces
        for (int i = 1; i < firstDay; i++) {
            System.out.print("   ");
        }

        // Print the dates for the rest of the month
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            System.out.printf("%2d ", i);
            if ((i + firstDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}