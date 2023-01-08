package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class admin {
    static BufferedReader reader = null;
    static ArrayList<ArrayList<String>> AV_STOCK_LIST = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String name = "";

    public void admin_authority() {
        System.out.println("\nPlease enter Your Name : ");
        name = sc.nextLine().toUpperCase();
        System.out.printf("\n\n---------------------------------------------------------%n");
        System.out.printf("|            WELCOME TO ADMIN PANEL %s            |%n", name);
        System.out.printf("---------------------------------------------------------%n");
        try {
            String line = "";
            reader = new BufferedReader(new FileReader("D:/Java/Java_Project/utils/Stock/data.csv"));
            while ((line = reader.readLine()) != null) {
                String[] myArray = line.split(",");
                ArrayList<String> temp_list = new ArrayList<>(Arrays.asList(myArray));
                AV_STOCK_LIST.add(temp_list);
            }
        } catch (Exception e) {
            System.out.println("Could'nt fetch the data !!! Error occured ! ");
        }
        while (true) {
            System.out.println("""
                    \nPress ------ >
                    1 for SHOW RECORD\n
                    2 for UPDATE RECORD\n
                    3 for DEALS
                    """);
            System.out.print("Enter : ");
            int data_so_inp = sc.nextInt();
            if (data_so_inp == 1) {
                show_available_stock();
            } else if (data_so_inp == 2) {
                update_record();
            } else if (data_so_inp == 3) {
                System.out.println("Comming Sooon !!");
            } else if (data_so_inp == 4) {
                System.out.println("Thanks for visiting Admin Panel " + name + " :)");
                break;
            }
        }
    }

    public static void writeLine() throws IOException {
        String[][] data = new String[AV_STOCK_LIST.size()][2];
        int count = 0;
        for (ArrayList<String> i : AV_STOCK_LIST) {
            String[] array = i.toArray(new String[0]);
            data[count++] = array;
        }
        System.out.println(Arrays.deepToString(data));
        FileWriter fileWriter = new FileWriter("D:/Java/Java_Project/utils/Stock/data.csv");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                fileWriter.write(data[i][j]);
                if (j < data.length - 1) {
                    fileWriter.write(",");
                }
            }
            fileWriter.write("\n");
        }
        System.out.println("Data write successfully");
        fileWriter.close();
    }

    public void show_available_stock() {
        System.out.printf("                   -----------------------                  %n");
        System.out.printf("                   |   AVAILABLE STOCK   |                  %n");
        System.out.printf("-------------------------------------------------------------%n");
        System.out.printf("|\t%-40s |%-2s |%n", "Items name", "Prizes");
        System.out.printf("-------------------------------------------------------------%n");
        for (int i = 0; i < AV_STOCK_LIST.size(); i++) {
            System.out.printf("%d\t%-40s %-2s Rs/-\n", (i + 1), AV_STOCK_LIST.get(i).get(0),
                    AV_STOCK_LIST.get(i).get(1));
        }
        System.out.printf("-------------------------------------------------------------%n");
        System.out.println(" ");
    }

    public void update_record() {
        while (true) {
            System.out.println("""
                    \nPress ---->
                    1 to update items
                    2 to remove items
                    3 to exit
                    """);
            int record_upd_option = sc.nextInt();
            if (record_upd_option == 1) {
                while (true) {
                    show_available_stock();
                    System.out.println("Enter item number : ");
                    int id = sc.nextInt();
                    System.out.println("""
                            You Wanna update its name ?\n
                            Press Y (Yes)  /  N (No)
                            """);
                    System.out.print("Enter : ");
                    String name_upd = sc.next().toLowerCase();
                    if (name_upd.contains("y")) {
                        sc.nextLine();
                        System.out.println("Old Item is " + AV_STOCK_LIST.get(id - 1).get(0));
                        System.out.print("Enter new Name : ");
                        String new_name = sc.nextLine();
                        while (new_name.matches("^[a-zA-Z ]*$") != true) {
                            System.out.println("<--- Please enter a valid product name --->");
                            System.out.print("Enter new Name : ");
                            new_name = sc.nextLine();
                        }
                        AV_STOCK_LIST.get(id - 1).set(0, new_name);
                    }
                    System.out.println("""
                            You Wanna update its Prize ?\n
                            Press Y (Yes)  /  N (No)
                            """);
                    System.out.print("Enter : ");
                    String prize_upd = sc.next().toLowerCase();
                    if (prize_upd.contains("y")) {
                        sc.nextLine();
                        System.out.println("Old Prize is " + AV_STOCK_LIST.get(id - 1).get(1) + " Rs/-");
                        System.out.print("Enter new Prize : ");
                        String new_prize = sc.nextLine();

                        while (new_prize.matches("^[0-9]*$") != true) {
                            System.out.println("<--- Please enter a valid product name --->");
                            System.out.print("Enter new Name : ");
                            new_prize = sc.nextLine();
                        }
                        AV_STOCK_LIST.get(id - 1).set(1, new_prize);
                        System.out.println(AV_STOCK_LIST.get(id - 1).get(1));
                    }
                    System.out.println(AV_STOCK_LIST.get(id - 1));
                    System.out.println("You Wanna Update more Items ?");
                    sc.next();
                    String more_update_option = sc.nextLine().toLowerCase();
                    if (more_update_option.contains("y")) {
                        continue;
                    } else {
                        break;
                    }
                }
                try {
                    writeLine();
                    System.out.println("\nData is updated SuccessFully in the DAta base\n");
                } catch (Exception e) {
                    System.out.println("\nCould'nt push the data\n");
                }

            } else if (record_upd_option == 2) {
                show_available_stock();
                System.out.println("Thanks for visiting the CONTROLL PANEL " + name);
                break;
            } else {
                System.out.println("Thanks for visiting the CONTROLL PANEL " + name);
                break;
            }
        }

    }
}