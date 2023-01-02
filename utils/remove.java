package utils;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Bill_Calculations.bill_cal;

public class remove {
    int stop_removing = 0;
    static Scanner sc = new Scanner(System.in);
    static bill_cal obj = new bill_cal();
    ArrayList<ArrayList<String>> your_bill_for_removal = obj.your_bill;

    public void remove_more() {
        System.out.println("Do You Wanna Remove items ? ");
        System.out.println("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
        String inp = sc.next().toLowerCase();
        while ((inp.equals("y") || inp.equals("n")) == false) {
            System.out.println("\t<--- Please enter a valid input --->");
            System.out.print("Press 'Y' for (Yes) OR Press 'N' for (No) : ");
            inp = sc.next().toLowerCase();
        }
        if (inp.equals("y")) {
            stop_removing += 1;
            System.out.println("Your bill is : " + stop_removing);
        } else if (inp.equals("n")) {
            System.out.println(your_bill_for_removal);
        }
    }

    public void remove_function() {

    }
}
