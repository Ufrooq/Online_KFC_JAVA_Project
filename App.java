import java.util.Scanner;

public class App {

  public static Boolean items_validation(String inp) {
    final String CODE_FOR_123 = "[1-9]";
    Boolean validation = inp.matches(CODE_FOR_123);
    return validation;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // ! Input Validation code for integer :
    System.out.print("Enter the item_No you wanna Buy : ");
    String input = sc.next();
    Boolean isValid = items_validation(input);
    while (isValid != true) {
      System.out.print("Enter Valid input : ");
      input = sc.next();
      isValid = items_validation(input);
    }
    System.out.println("Your No is : " + input);
  }
}
