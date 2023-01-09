import java.util.InputMismatchException;
import java.util.Scanner;
import utils.menu;
import utils.admin;
import utils.deals;
import utils.validation;

public class App {
  public static Scanner sc = new Scanner(System.in);
  public static menu bar = new menu();
  public static validation val = new validation();
  public static deals del = new deals();
  public static admin ad = new admin();

  public static void wc() {
    System.out.printf("\n\n---------------------------------------------------------------------%n");
    System.out.printf("                        ONLINE FOOD ORDERING                         %n");
    System.out.printf("---------------------------------------------------------------------%n");
    int start;
    while (true) {
      try {
        System.out.println("""
            \n\n\nPress 1 to Enter as a CUSTOMER\n
            Press 2 to Enter as an ADMIN\n
            Press 3 to Exit :)
               """);
        System.out.print("Enter : ");
        start = sc.nextInt();
        sc.nextLine();
        if (start == 1 || start == 2 || start == 3) {
          if (start == 1) {
            System.out.println(
                "Do you wanna have custom shopping OR wanna go with deals ???");
            System.out.print("Press ------>\n'C' for Custom\n'D' for Deals : ");
            String inp = sc.next().toLowerCase();
            while ((inp.equals("c") || inp.equals("d")) == false) {
              System.out.println("\t<--- Please enter a valid input --->");
              System.out.print("Press ------>\n'C' for Custom\n'D' for Deals : ");
              inp = sc.next().toLowerCase();
            }
            if (inp.equals("c")) {
              bar.my_menu();
              val.user_inp_validaition();
            } else if (inp.equals("d")) {
              del.my_deals();
            }
          } else if (start == 2) {
            passwd();
          } else if (start == 3) {
            System.out.println("Thanks for visiting :)");
            System.exit(0);
          }
          break;
        } else {
          System.out.println("\n\t\t\t< ---- Enter a Valid Input ----- >");
        }
      } catch (InputMismatchException e) {
        System.out.println("\n\t\t\t< ---- Enter a Valid Input ----- >");
        sc.nextLine();
      }
    }
  }

  public static void passwd() {
    System.out.println("<-- Please Enter Password to get Access -->");
    int count = 0;
    while (true) {
      System.out.print("Password : ");
      String passcode = sc.next();
      if (passcode.matches("12345")) {
        System.out.println("----------------------------");
        System.out.println("     Access granted !!!");
        System.out.println("----------------------------");
        ad.admin_authority();
        wc();
      } else {
        if (count > 1) {
          System.out.println("Thanks for visiting :)");
          break;
        } else {
          System.out.println("\n----------------------------");
          System.out.println("     Incorrect Password     ");
          System.out.println("----------------------------");
          System.out.println("Enter again --->\n");
          count++;
          continue;
        }
      }
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
