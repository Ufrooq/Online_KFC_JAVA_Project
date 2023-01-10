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
    static int stop_read = 0;

    public void admin_authority() {
        System.out.println("\nPlease enter Your Name : ");
        name = sc.nextLine().toUpperCase();
        System.out.printf("\n\n---------------------------------------------------------%n");
        System.out.printf("|            WELCOME TO ADMIN PANEL %s            |%n", name);
        System.out.printf("---------------------------------------------------------%n");
        if (stop_read == 0) {
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
            stop_read++;
        }
        while (true) {
            System.out.println("""
                    \nPress ------ >
                    1 for SHOW RECORD\n
                    2 for UPDATE RECORD\n
                    3 for DEALS\n
                    4 for Exit
                    """);
            System.out.print("Enter : ");
            String data_so_inp = sc.next();
            while (data_so_inp.matches("[1-4]") != true) {
                System.out.println("\n<-- Enter a Valid input -->\n");
                System.out.print("Enter : ");
                data_so_inp = sc.next();
            }
            if (data_so_inp.matches("1")) {
                show_available_stock();
            } else if (data_so_inp.matches("2")) {
                update_record();
            } else if (data_so_inp.matches("3")) {
                System.out.println("Comming Sooon !!");
            } else if (data_so_inp.matches("4")) {
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
                    3 to add items
                    4 to exit
                    """);
            System.out.println("Enter : ");
            String record_upd_option = sc.next();
            while (record_upd_option.matches("[1-4]") != true) {
                System.out.println("<--- Enter a Valid input --->");
                System.out.println("Enter : ");
                record_upd_option = sc.next();
            }
            if (record_upd_option.matches("1")) {
                update_items_in_inventory();
            } else if (record_upd_option.matches("2")) {
                del_items();
            } else if (record_upd_option.matches("3")) {
                add_new_items();
            } else if (record_upd_option.matches("4")) {
                break;
            }
        }
    }

    public void update_items_in_inventory() {
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
                    System.out.print("Enter new Prize : ");
                    new_prize = sc.nextLine();
                }
                AV_STOCK_LIST.get(id - 1).set(1, new_prize);
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
            System.out.println("\nData is updated SuccessFully in the Data base\n");
        } catch (Exception e) {
            System.out.println("\nCould'nt push the data\n");
        }
    }

    public void del_items() {
        show_available_stock();
        while (true) {
            System.out.print("\nEnter Item id to Delete :  ");
            // Getting the item Input to remove it ---------->
            String temp_1 = sc.next();
            // ---------------------------------------------->
            int temp_2 = AV_STOCK_LIST.size();
            String item_limit = Integer.toString(temp_2);
            String regex = "[1-" + item_limit + "]";
            while (temp_1.matches(regex) != true) {
                System.out.println("<--- Please Enter a Valid input --->");
                System.out.print("\nEnter Item id from (1 - " + item_limit + ") to Delete :  ");
                temp_1 = sc.next();
            }
            int item_id = Integer.parseInt(temp_1);
            AV_STOCK_LIST.remove(item_id - 1);
            System.out.println("Do You Wannt <-- REMOVE --> more items ?");
            System.out.println("Enter ('y') for Yes || ('n') for No : ");
            String option = sc.next().toLowerCase();
            while (true) {
                if ((option.contains("y")) || (option.contains("n"))) {
                    break;
                } else {
                    System.out.println("<--- Enter a Valid input --->");
                    System.out.println("Enter : ");
                    option = sc.next();
                }

            }
            if (option.contains("y")) {
                continue;
            } else if (option.contains("n")) {
                break;
            }
        }
        try {
            writeLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add_new_items() {
        sc.nextLine();
        while (true) {
            show_available_stock();
            ArrayList<String> new_item = new ArrayList<>();
            System.out.print("Enter NEW Product Name : ");
            String name = sc.nextLine();
            while (name.matches("^[a-zA-Z ]*$") != true) {
                System.out.println("<--- Please enter a valid product name --->");
                System.out.print("Enter new Name : ");
                name = sc.nextLine();
            }
            new_item.add(0, name);
            System.out.print("Enter Its Prize : ");
            String prize = sc.nextLine();
            while (prize.matches("^[0-9]*$") != true) {
                System.out.println("<--- Please enter a valid product name --->");
                System.out.print("Enter Its Prize ");
                prize = sc.nextLine();
            }
            new_item.add(1, prize);
            AV_STOCK_LIST.add(new_item);
            System.out.println("Do You Wanna ADD more Items ?");
            String more_update_option = sc.nextLine().toLowerCase();
            if (more_update_option.contains("y")) {
                continue;
            } else {
                break;
            }
        }
    }
}