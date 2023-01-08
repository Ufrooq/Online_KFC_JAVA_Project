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
        String[][] imported_deals_list = ddt.deals_list;
        System.out.println(imported_deals_list[0][0]);
        System.out.println("\n\n");
        // String[][][] events_list = {
        // { { "2023 - 07 - 14" }, { "2 - Large Pizza" } },
        // { { "2023 - 07 - 14" }, {} },
        // { { "2023 - 07 - 14" }, {} },
        // { { "2023 - 07 - 14" }, {} },
        // { { "2023 - 07 - 14" }, {} },
        // { { "2023 - 07 - 14" }, {} }
        // };
        // String august_14_ = "2023-07-14";
        // System.out.println(currenDate);
    }

    public void my_deals() {
        Loading();
        showDeals();

    }

}
