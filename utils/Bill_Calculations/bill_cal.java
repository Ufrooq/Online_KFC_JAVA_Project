package utils.Bill_Calculations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import utils.menu;

public class bill_cal {
    static int remove_any_items_fn_stop = 0;
    static int sum = 0;
    static int stop_removing = 0;
    static int count_var_to_print_bill = 0;
    static menu it = new menu();
    static Scanner sc = new Scanner(System.in);
    public ArrayList<ArrayList<String>> your_bill = new ArrayList<>();

    public void cal(String item, String quantity) {
        String[][] main_list = it.list_of_items();
        int item_sum = 0;
        int itm = Integer.parseInt(item);
        int quant = Integer.parseInt(quantity);
        int[] prizes = { 700, 343, 433, 876, 343, 654, 543, 987, 456 };
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

    public void print_your_bill() {
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("                                Your Bill                               %n");
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|\t%-15s |\t%-15s |\t%-15s |%n", "Items name", "Quantity", "Prizes");
        System.out.printf("--------------------------------------------------------------------------%n");
        for (ArrayList<String> i : your_bill) {
            for (int j = 0; j < i.size(); j++) {
                System.out.printf("|\t%-15s |", i.get(j));
            }
            System.out.println();
        }
        System.out.printf("--------------------------------------------------------------------------%n");
        System.out.printf("|\tYour total bill is : %30s Rs/-", sum);
        System.out.println("");
        if (remove_any_items_fn_stop == 0) {
            remove_any_items();
            remove_any_items_fn_stop++;
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
        int limit = last_aList.size();
        String limit_in_str = Integer.toString(limit);
        String regex = "[1-" + limit_in_str + "]";
        System.out.print("Enter the product id from (1 - " + limit + ") : ");
        String item_input = sc.next();
        while (item_input.matches(regex) != true) {
            System.out.println("<--- Enter valid input --->");
            item_input = sc.next();
        }
        int item_input_str = Integer.parseInt(item_input);
        last_aList.remove(item_input_str - 1);
        remove_any_items();
        System.out.println(last_aList);
    }

}
