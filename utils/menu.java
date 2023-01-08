package utils;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class menu {
    static int prize_controll = 0;
    static ArrayList<ArrayList<String>> Menu_LIST = new ArrayList<>();
    static BufferedReader reader = null;

    public void my_menu() {
        String[][] list = list_of_items().clone();
        System.out.println(" ");
        System.out.printf("-----------------------------------------------------------%n");
        System.out.printf("|\t%-40s %-2s |%n", "Items name", "Prizes");
        System.out.printf("-----------------------------------------------------------%n");
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%s\t%-40s %-2s Rs/-\n", (i + 1), list[i][0], list[i][1]);
        }
        System.out.printf("-----------------------------------------------------------%n");
        System.out.println(" ");
    }

    public String[][] list_of_items() {
        if (prize_controll == 0) {
            try {
                String line = "";
                reader = new BufferedReader(new FileReader("D:/Java/Java_Project/utils/Stock/data.csv"));
                while ((line = reader.readLine()) != null) {
                    String[] myArray = line.split(",");
                    ArrayList<String> temp_list = new ArrayList<>(Arrays.asList(myArray));
                    Menu_LIST.add(temp_list);
                }
                prize_controll++;
                reader.close();
            } catch (Exception e) {
                System.out.println("Could'nt fetch the data !!! Error occured ! ");
            }
        }
        String[][] list = new String[Menu_LIST.size()][2];
        int count = 0;
        for (ArrayList<String> i : Menu_LIST) {
            String[] array = i.toArray(new String[0]);
            list[count++] = array;
        }
        extracting_prizes_from_menu();
        return list;
    };

    public int[] extracting_prizes_from_menu() {
        int[] prizes = new int[Menu_LIST.size()];
        for (int i = 0; i < Menu_LIST.size(); i++) {
            String temp_data_in_str = Menu_LIST.get(i).get(1);
            int temp_data_in_int = Integer.parseInt(temp_data_in_str);
            prizes[i] = temp_data_in_int;
        }
        return prizes;
    }

    public static void main(String[] args) {

    }

}
