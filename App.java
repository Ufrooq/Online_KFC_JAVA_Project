import java.util.Scanner;

public class App {
  public static Scanner sc = new Scanner(System.in);

  public static void calc() {}

  public static void menu() {
    String[][] list = {
      { "1.\tMedium-Size Pizza", "700" },
      { "2.\tSmall-Size Pizza", "343" },
      { "3.\tCheeze Burger   ", "433" },
      { "4.\tZinger Pizza    ", "343" },
      { "5.\tFries           ", "343" },
      { "6.\tFries           ", "343" },
      { "7.\tFries           ", "343" },
      { "8.\tFries           ", "343" },
      { "9.\tFries           ", "343" },
    };
    System.out.println(" ");
    System.out.println("No \tItems Available\t\t\t\tPrizes");
    System.out.println(
      "<---------------------------------------------------->"
    );
    for (int i = 0; i < list.length; i++) {
      System.out.println(list[i][0] + "\t\t\t" + list[i][1] + "\t");
    }
    System.out.println(
      "<---------------------------------------------------->"
    );
    System.out.println(" ");
  }

  public static Boolean items_validation(String inp) {
    final String CODE_FOR_123 = "[1-9]";
    Boolean validation = inp.matches(CODE_FOR_123);
    return validation;
  }

  public static void wc() {
    System.out.println("<--------------------------------------->");
    System.out.println("<------ Welcome to the store ----->");
    System.out.println("<--------------------------------------->");
    System.out.println(
      "Do you wanna have custom shopping OR wanna go with deals ???"
    );
    System.out.print("\t YES or NO : ");
    String inp = sc.next().toLowerCase();
    if (inp.equals("yes")) {
      menu();
    } else {
      System.out.println("<----------------------------------------------->");
      System.out.println("<\t\t\t\t\t\t>");
      System.out.println("<\t\t\t\t\t\t>");
      System.out.println("<\tThanks for coming to the store -->\t>");
      System.out.println("<\t\t\t\t\t\t>");
      System.out.println("<\t\t\t\t\t\t>");
      System.out.println("<----------------------------------------------->");
    }
  }

  public static void main(String[] args) {
    wc();
    //   System.out.print("Enter the item_No you wanna Buy : ");
    //   String input = sc.next();
    //   Boolean isValid = items_validation(input);
    //   while (isValid != true) {
    //     System.out.print("Enter Valid input : ");
    //     input = sc.next();
    //     isValid = items_validation(input);
    //   }
    //   System.out.println("Your No is : " + input);
    // }
  }
}
