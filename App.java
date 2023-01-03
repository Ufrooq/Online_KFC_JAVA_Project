import java.util.Scanner;
import utils.menu;
import utils.deals;
import utils.validation;
import utils.admin;

public class App {

  public static Scanner sc = new Scanner(System.in);
  public static menu bar = new menu();
  public static validation val = new validation();
  public static deals del = new deals();
  public static admin ad = new admin();

  public static void wc() {
    System.out.printf("---------------------------------------------------------------------%n");
    System.out.printf("                        ONLINE FOOD ORDERING                         %n");
    System.out.printf("---------------------------------------------------------------------%n");
    System.out.println("""
        Press 1 to Enter as a CUSTOMER\n
        Press 2 to Enter as an ADMIN
           """);
    System.out.print("Enter : ");
    int start = sc.nextInt();
    while (start != 1 && start != 2) {
      System.out.println("\n\t<--- Please enter a valid input --->\n");
      System.out.println("""
          Press 1 to Enter as a CUSTOMER\n
          Press 2 to Enter as an ADMIN
                  """);
      System.out.print("Enter : ");
      start = sc.nextInt();
    }

    if (start == 1) {
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
    } else if (start == 2) {
      ad.admin_authority();
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
