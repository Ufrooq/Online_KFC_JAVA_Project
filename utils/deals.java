package utils;

import java.time.LocalDate;
import java.util.Scanner;

import utils.Deals_Data.deals_data;

public class deals {

    static LocalDate currenDate = LocalDate.now();
    static deals_data ddt = new deals_data();
    static Scanner sc = new Scanner(System.in);

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
                "2023-03-23",
                "2023-07-25",
                "2023-08-14",
                "2023-09-06",
        };
        String date = currenDate.toString();
        int count = 0;
        for (int i = 0; i < events_list.length; i++) {
            if (date.equals(events_list[i])) {
                count++;
                System.out.println("\u001b[33m" + ddt.deals_list[i][0] + "\u001b[0m");
                deal_bill(i);
            }
        }
        if (count == 0) {
            System.out.println("Sorry :(  No DEALS are Available rightnow !!");
        }
    }

    public static void deal_bill(int item_block) {
        int[][] prizes = {
                { 3000, 5000, 2200 },
                { 3000, 5000, 2200 },
                { 3000, 5000, 2200 },
                { 3000, 5000, 2200 },
                { 3000, 5000, 2200 },
        };
        System.out.println("Enter Deal ( #1 #2 #3 ) :  ");
        int item = sc.nextInt();
        while (item != 1 && item != 2 && item != 3) {
            System.out.println("\n<-- Enter a valid input -->\n");
            System.out.println("Enter Deal ( #1 #2 #3 ) :  ");
            item = sc.nextInt();
        }
        pay_bill(prizes[item_block][item - 1]);
    }

    public static void pay_bill(int sum) {
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("\n\n                  BILL PAYMENT SECTION              ");
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("\nKindly Pay Your Bill ---->");
        System.out.println("Your Total bill is : " + sum);
        while (true) {
            try {
                System.out.print("Enter Amount : ");
                int bill_amount = sc.nextInt();
                if (bill_amount > sum) {
                    System.out.println("There is your extra Amount " + (bill_amount - sum) + " Rs/-");
                    System.out.println("\n\nThanks For Coming to the Store");
                    break;
                } else if (bill_amount < sum) {
                    System.out.println("<--- Kindly Enter Valid Amount --->");
                }

            } catch (Exception e) {
                System.out.println("<--- Enter Valid Input --->");
                sc.nextLine();
            }

        }
    }

    public void my_deals() {
        System.out.println("\n");
        Loading();
        showDeals();

    }

}
