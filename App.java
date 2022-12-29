import java.util.Scanner;
import utils.menu;
import utils.deals;
import utils.validation;

public class App {

  public static Scanner sc = new Scanner(System.in);
  public static menu bar = new menu();
  public static validation val = new validation();
  public static deals del = new deals();

  public static void wc() {
    System.out.println("<--------------------------------------->");
    System.out.println("<\tWelcome to the store\t\t>");
    System.out.println("<--------------------------------------->");
    System.out.println(
        "Do you wanna have custom shopping OR wanna go with deals ???");
    System.out.print("Press 'C' for Custom or 'D' for Deals : ");
    String inp = sc.next().toLowerCase();
    while ((inp.equals("c") || inp.equals("d")) == false) {
      System.out.println("\t<--- Please enter a valid input --->");
      System.out.print("Press 'C' for Custom or 'D' for Deals : ");
      inp = sc.next().toLowerCase();
    }
    if (inp.equals("c")) {
      bar.my_menu();
      val.user_inp_validaition();
    } else if (inp.equals("d")) {
      del.my_deals();
    }
  }

  public static void main(String[] args) {
    try {
      wc();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
