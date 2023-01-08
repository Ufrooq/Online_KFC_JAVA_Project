import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class sadia {

    static BufferedReader reader = null;
    static BufferedWriter writer = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] nested = new String[20][2];
        int count = 0;
        try {
            String line = "";
            reader = new BufferedReader(new FileReader("D:/Java/Java_Project/seats.csv"));
            while ((line = reader.readLine()) != null) {
                String[] myArray = line.split(",");
                nested[count] = myArray;
                count++;
            }
        } catch (Exception e) {

            System.out.println("Could'nt fetch the data !!! Error occured ! ");
        }
        int count_2 = 0;
        String[] seats = new String[30];
        for (String[] i : nested) {
            seats[count_2] = i[0];
            count_2++;
        }
        ArrayList<String> temp_2 = new ArrayList<>(Arrays.asList(seats));
        ck(temp_2);
    }

    public static void ck(ArrayList<String> seats) {
        while (true) {
            System.out.println("Enter seat lumber : ");
            String seat_lumber = sc.next();
            int seat_lumber_int = Integer.parseInt(seat_lumber);
            if (seats.contains(seat_lumber)) {
                System.out.println("<--- Seat Already reserved ---->");
            } else {
                seats.set(seat_lumber_int, seat_lumber);
                break;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter("D:/Java/Java_Project/seats.csv");
            seats.removeIf(s -> s == null);
            String[] data1 = seats.toArray(new String[0]);
            writeLine(fileWriter, data1);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("fffffffffffffff");
        }
    }

    public static void writeLine(FileWriter fileWriter, String[] data) throws IOException {
        for (int i = 0; i < data.length; i++) {
            fileWriter.write(data[i]);
            if (i < data.length - 1) {
                fileWriter.write(",");
            }
            fileWriter.write("\n");
        }
        System.out.println("Your seat is booked !!");
    }
}
