package utils.Bill_Calculations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import utils.menu;

public class bill_cal {
    static int sum = 0;
    static int stop_removing = 0;
    static menu mn = new menu();
    static Scanner sc = new Scanner(System.in);
    public ArrayList<ArrayList<String>> your_bill = new ArrayList<>();

    public void cal(String item, String quantity) {
        int[] prizes = mn.extracting_prizes_from_menu().clone();
        String[][] main_list = mn.list_of_items();
        int item_sum = 0;
        int itm = Integer.parseInt(item);
        int quant = Integer.parseInt(quantity);
        item_sum += prizes[itm - 1] * quant;
        sum += item_sum;
        if (your_bill.isEmpty() == false) {
            boolean found = false;
            for (int i = 0; i < your_bill.size(); i++) {
                ArrayList<String> sub_list = your_bill.get(i);
                if ((main_list[itm - 1][0]).equals(String.valueOf(sub_list.get(0)))) {
                    // ! Quantity Updation :
                    String get_quantity_s = "";
                    get_quantity_s = sub_list.get(1);
                    int get_quantity_i = 0;
                    get_quantity_i = Integer.parseInt(get_quantity_s);
                    get_quantity_i += quant;
                    String quantity_back_to_Str = Integer.toString(get_quantity_i);
                    sub_list.set(1, quantity_back_to_Str);
                    // ! Amount updation :
                    String get_amount_s = "";
                    get_amount_s = sub_list.get(2);
                    int get_amount_i = 0;
                    get_amount_i = Integer.parseInt(get_amount_s);
                    get_amount_i += item_sum;
                    String amount_back_to_Str = Integer.toString(get_amount_i);
                    sub_list.set(2, amount_back_to_Str);
                    found = true;
                    break;
                }
            }
            if (!found) {
                String total_temp = Integer.toString(item_sum);
                String[] temp = { main_list[itm - 1][0], quantity, total_temp };
                ArrayList<String> temp_2 = new ArrayList<>(Arrays.asList(temp));
                your_bill.add(temp_2);
            }
        } else {
            String total_temp = Integer.toString(item_sum);
            String[] temp = { main_list[itm - 1][0], quantity, total_temp };
            ArrayList<String> temp_2 = new ArrayList<>(Arrays.asList(temp));
            your_bill.add(temp_2);
        }

    }

    public void item_just_added() {
        System.out.println("\n\n\n");
        System.out.printf("                           -----------------------                        %n");
        System.out.printf("                           | Items Added To CART |                        %n");
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|\t%-20s |\t%-20s |\t%-20s |%n", "Items name", "Quantity", "Prizes");
        System.out.printf("--------------------------------------------------------------------------%n");
        for (ArrayList<String> i : your_bill) {
            for (int j = 0; j < i.size(); j++) {
                System.out.printf("|\t%-20s |", i.get(j));
            }
            System.out.println();
        }
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.println("\n\n\n");

    }

    public void print_your_bill() {
        System.out.println("\n");
        System.out.printf("-----------------------------------------------------------------------------%n");
        System.out.printf("                                YOUR TOTAL BILL                          %n");
        System.out.printf("-----------------------------------------------------------------------------%n");
        System.out.printf("|\t%-20s |\t%-20s |\t%-20s |%n", "Items name", "Quantity", "Prizes");
        System.out.printf("-----------------------------------------------------------------------------%n");
        int count = 1;
        for (ArrayList<String> i : your_bill) {
            System.out.print(count + ". ");
            count += 1;
            for (int j = 0; j < i.size(); j++) {
                System.out.printf("|\t%-15s |", i.get(j));
            }
            System.out.println();
        }
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|\tYour total bill is : %35s Rs/-\n", sum);
        if (stop_removing != 0) {
            if (sum > 3000 && sum < 8000) {
                int discount_10_per = (sum / 100) * 10;
                System.out.printf("|\tBill after 10%% discount is : %30s Rs/-", (sum - discount_10_per));
                pay_bill();
            } else if (sum > 8000) {
                int discount_20_per = (sum / 100) * 20;
                System.out.printf("|\tBill after 20%% discount is : %25s Rs/-", (sum - discount_20_per));
                pay_bill();
            } else {
                pay_bill();
            }
        }
        System.out.println("\n\n");
        if (stop_removing == 0) {
            stop_removing++;
            remove_any_items();
        }
    }

    public void remove_any_items() {
        System.out.println("Do You Wanna Remove any item ? ");
        System.out.println("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
        String inp = sc.next().toLowerCase();
        while ((inp.equals("y") || inp.equals("n")) == false) {
            System.out.println("\t<--- Please enter a valid input --->");
            System.out.print("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
            inp = sc.next().toLowerCase();
        }
        if (inp.equals("y")) {
            user_inp_validaition(your_bill);
        } else if (inp.equals("n")) {
            print_your_bill();
        }
    }

    public void user_inp_validaition(ArrayList<ArrayList<String>> last_aList) {
        int[] prizes = mn.extracting_prizes_from_menu().clone();
        // ! Getting item to Update it :
        int limit = last_aList.size();
        String limit_in_str = Integer.toString(limit);
        String regex = "[1-" + limit_in_str + "]";
        System.out.print("Enter the product id from (1 - " + limit + ") : ");
        String item_input = sc.next();
        while (item_input.matches(regex) != true) {
            System.out.println("<--- Enter valid input --->");
            System.out.println();
            System.out.print("Enter the product id from (1 - " + limit + ") : ");
            item_input = sc.next();
        }
        int item_input_int = Integer.parseInt(item_input);
        // ! <-------------------------------------------------------> :

        // ! Updating Quantity :
        String quan_limit_in_str = last_aList.get(item_input_int - 1).get(1);
        int quan_limit_in_int = Integer.parseInt(quan_limit_in_str);
        String quan_regex = "[1-" + quan_limit_in_str + "]";
        System.out.print("Enter the quantity from (1 - " + quan_limit_in_str + ") : ");
        String quan_item_input = sc.next();
        while (quan_item_input.matches(quan_regex) != true) {
            System.out.print("Enter the quantity from (1 - " + quan_limit_in_str + ") : ");
            System.out.println("<--- Enter valid input --->");
            quan_item_input = sc.next();
        }
        int quan_item_input_str = Integer.parseInt(quan_item_input);
        quan_limit_in_int -= quan_item_input_str;
        sum -= (prizes[item_input_int - 1]) * quan_item_input_str;
        String to_update_quan = Integer.toString(quan_limit_in_int);
        if (quan_limit_in_int == 0) {
            last_aList.remove(item_input_int - 1);
        } else {
            last_aList.get(item_input_int - 1).set(1, to_update_quan);
        }
        // ! <-------------------------------------------------------> :
        // ! Updating Prizes :
        if (quan_limit_in_int != 0) {
            String item_prize_get = last_aList.get(item_input_int - 1).get(2);
            int item_prize_int = Integer.parseInt(item_prize_get);
            item_prize_int -= (prizes[item_input_int - 1]) * quan_item_input_str;
            String item_prize_str = Integer.toString(item_prize_int);
            last_aList.get(item_input_int - 1).set(2, item_prize_str);
        }
        // ! <-------------------------------------------------------> :
        remove_any_items();
    }

    public static void pay_bill() {
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("\n\n                  BILL PAYMENT SECTION              ");
        System.out.println("\n\n----------------------------------------------------");
        System.out.println("\nKindly Pay Your Bill ---->");
        while (true) {
            try {
                System.out.print("Enter Amount : ");
                int bill_amount = sc.nextInt();
                if (bill_amount > sum) {
                    System.out.println("There is your extra Amount " + (bill_amount - sum) + " Rs/-");
                    System.out.println("Thanks For Coming to the Store");
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

}
