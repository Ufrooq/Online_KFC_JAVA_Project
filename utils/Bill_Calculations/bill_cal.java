package utils.Bill_Calculations;

import java.util.ArrayList;
import java.util.Arrays;
import utils.menu;

public class bill_cal {
    static int sum = 0;
    menu it = new menu();
    ArrayList<ArrayList<String>> your_bill = new ArrayList<>();

    public void cal(String item, String quantity) {
        int itm = Integer.parseInt(item);
        int quant = Integer.parseInt(quantity);
        int[] prizes = { 700, 343, 433, 876, 343, 654, 543, 987, 456 };
        sum += prizes[itm - 1] * quant;
        String[] temp = { item, quantity };
        ArrayList<String> temp_2 = new ArrayList<>(Arrays.asList(temp));
        your_bill.add(temp_2);
    }

    public void print_your_bill() {
        String[][] main_list = it.list_of_items();
        System.out.println("-\tItems name \t Quantity");
        for (ArrayList<String> i : your_bill) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.print(main_list[j][0] + "\t");
                } else if (j == 1) {
                    System.out.println(i.get(1));
                }
            }
            System.out.println();
        }
    }

}
