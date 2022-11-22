import java.util.Scanner;

public class file {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final String CODE_FOR_ABC = "[a-zA-Z]";

    System.out.print("Enter the item_No you wanna Buy : ");
    String input = sc.next();
    Boolean isValid = input.matches(CODE_FOR_ABC);
    while (isValid != true) {
      System.out.print("Enter Valid input : ");
      input = sc.next();
      isValid = input.matches(CODE_FOR_ABC);
    }
    System.out.println("Your No is : " + input);
  }
}
