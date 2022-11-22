import java.util.Scanner;

public class App {

  public static Boolean items_validation() {
    return 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final String VALIDATION = "[1-9]";
    System.out.print("Enter an input : ");
    String input = sc.next();
    Boolean isValid = input.matches(VALIDATION);
    System.out.println(isValid);
    while (isValid != true) {
      System.out.print("Enter Valid input : ");
      input = sc.next(); 
      isValid = input.matches(VALIDATION);
    }
    System.out.println("Your No is : " + input);
  }
}
