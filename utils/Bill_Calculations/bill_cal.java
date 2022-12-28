package utils.Bill_Calculations;

public class bill_cal {
    static int sum = 0;

    public void cal(String item, String quantity) {
        int itm = Integer.parseInt(item);
        int quant = Integer.parseInt(quantity);
        int[] prizes = { 700, 343, 433, 876, 343, 654, 543, 987, 456 };
        sum += prizes[itm - 1] * quant;
    }

    public void bill_menu() {
    }

    public void print_your_bill() {
        System.out.println("Your total bill is :" + sum);
    }

    public static void main(String[] args) {
    }
}
