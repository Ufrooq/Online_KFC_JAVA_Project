import java.io.BufferedReader;
import java.io.FileReader;

class Main {
    static BufferedReader reader = null;

    public static void main(String[] args) {
        try {
            String line = "";
            reader = new BufferedReader(new FileReader("./Book1.csv"));
            while ((line = reader.readLine()) != null) {
                String[] myArray = line.split(",");
                for (String i : myArray) {
                    System.out.printf(i + "\t\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Could'nt fetch the data !!! Error occured ! ");
        }

    }
}