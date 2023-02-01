package utils;

import java.time.LocalDate;
import utils.Deals_Data.deals_data;

public class deals {

    static LocalDate currenDate = LocalDate.now();
    static deals_data ddt = new deals_data();

    public static void Loading() {
        System.out.println("Lets see the Deals available -----> ");
        System.out.print("\tLoading");
        int counter = 0;
        try {
            while (counter < 6) {
                for (int i = 0; i < 2000000000L; i++) {
                    for (int j = 0; j < 2000000000L; j++) {
                    }
                }
                System.out.print(".");
                counter++;
            }
        } catch (Exception e) {
            System.out.println("Not valid");
        }
        System.out.println("\n\n");
    }

    public static void showDeals() {
        String[] events_list = {
                "2023-01-01",
                "2023-02-02",
                "2023-03-03",
                "2023-04-04",
                "2023-05-05",
                "2023-06-06",
                "2023-07-07",
                "2023-08-08",
                "2023-09-09",
                "2023-10-10",
        };
        String date = currenDate.toString();
        for (int i = 0; i < events_list.length; i++) {
            if (date.equals(events_list[i])) {
                System.out.println("\u001b[33m" + ddt.deals_list[i][0] + "\u001b[0m");
            }
        }
    }

    public void my_deals() {
        System.out.println("\n");
        // Loading();
        showDeals();
    }

}
