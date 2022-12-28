import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        // create an arraylist
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        // add elements to arraylist
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("Prime Numbers: " + primeNumbers);

        // create another arraylist
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        // Add all elements from primeNumbers to numbers
        numbers.addAll(primeNumbers);

        System.out.println("Numbers: " + numbers);
    }
}