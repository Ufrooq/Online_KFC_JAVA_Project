package utils;

import java.time.LocalDate;

public class deals {

    static LocalDate currenDate = LocalDate.now();

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
        System.out.println();
    }

    public static void showDeals() {
        String my_date = "2023-12-23";
        String system_date = currenDate.toString();
        if (my_date.matches(system_date)) {
            System.out.println("You are done !!");
        } else {
            System.out.println("Sorrryyy !!");
        }
    }

    public void my_deals() {
        Loading();
        showDeals();

    }

}
