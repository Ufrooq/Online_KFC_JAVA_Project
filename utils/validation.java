package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import utils.Bill_Calculations.bill_cal;

public class validation {
    public static Scanner sc = new Scanner(System.in);
    public static bill_cal bl = new bill_cal();
    public static menu menu_len = new menu();

    public static int limit() {
        ArrayList<ArrayList<String>> lim = new ArrayList<>();
        try {
            String line = "";
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("D:/Java/Java_Project/utils/Stock/data.csv"));
            while ((line = reader.readLine()) != null) {
                String[] myArray = line.split(",");
                ArrayList<String> temp_list = new ArrayList<>(Arrays.asList(myArray));
                lim.add(temp_list);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Could'nt fetch the data !!! Error occured ! ");
        }
        return lim.size();
    }

    public static Boolean items_validation(String inp, String id) {
        String LIMIT = Integer.toString(limit());
        String regex_id = "[1-" + LIMIT + "]";
        if (id == "nm") {
            final String CODE_FOR_123 = regex_id;
            Boolean validation = inp.matches(CODE_FOR_123);
            return validation;
        } else {
            final String CODE_FOR_quan = "[1-5]";
            Boolean validation_quan = inp.matches(CODE_FOR_quan);
            return validation_quan;
        }
    }

    public void user_inp_validaition() {
        String LIMIT = Integer.toString(limit());
        System.out.print("Enter the product id (1 - " + LIMIT + ") : ");
        String item_input = sc.next();
        Boolean isValid = items_validation(item_input, "nm");
        while (isValid != true) {
            System.out.print("Enter Valid input : ");
            item_input = sc.next();
            isValid = items_validation(item_input, "nm");
        }

        System.out.print("Enter the product quantity (1 - 5) : ");
        String quan_input = sc.next();
        Boolean isValid_quan = items_validation(quan_input, "qn");
        while (isValid_quan != true) {
            System.out.print("Enter Valid input : ");
            quan_input = sc.next();
            isValid_quan = items_validation(quan_input, "qn");
        }
        if (isValid == true && isValid_quan == true) {
            bl.cal(item_input, quan_input);
            bl.item_just_added();
            Add_more();
        }
    }

    public void Add_more() {
        System.out.println("Do You Wanna Add more items ? ");
        System.out.println("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
        String inp = sc.next().toLowerCase();
        while ((inp.equals("y") || inp.equals("n")) == false) {
            System.out.println("\t<--- Please enter a valid input --->");
            System.out.print("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
            inp = sc.next().toLowerCase();
        }
        if (inp.equals("y")) {
            user_inp_validaition();
        } else if (inp.equals("n")) {
            bl.print_your_bill();
        }
    }
}
