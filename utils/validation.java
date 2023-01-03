package utils;

import java.util.Scanner;

import utils.Bill_Calculations.bill_cal;

public class validation {
    public static Scanner sc = new Scanner(System.in);
    public static bill_cal bl = new bill_cal();

    public static Boolean items_validation(String inp, String id) {
        if (id == "nm") {
            final String CODE_FOR_123 = "[1-9]";
            Boolean validation = inp.matches(CODE_FOR_123);
            return validation;
        } else {
            final String CODE_FOR_quan = "[1-5]";
            Boolean validation_quan = inp.matches(CODE_FOR_quan);
            return validation_quan;
        }
    }

    public void user_inp_validaition() {
        System.out.print("Enter the product id (1 - 9) : ");
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
