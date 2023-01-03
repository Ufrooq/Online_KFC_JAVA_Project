package utils;

public class menu {

    public void my_menu() {
        String[][] list = list_of_items().clone();
        System.out.println(" ");
        System.out.printf("---------------------------------------------------------%n");
        System.out.printf("|\t%-31s |\t%-15s |%n", "Items name", "Prizes");
        System.out.printf("---------------------------------------------------------%n");
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + "\t" + list[i][0] + "\t\t|\t" + list[i][1] + " Rs/-\t");
        }
        System.out.printf("---------------------------------------------------------%n");
        System.out.println(" ");
    }

    public String[][] list_of_items() {
        String[][] list = {
                { "Medium-Size Pizza\t", "700" },
                { "Small-Size Pizza \t", "343" },
                { "Cheeze Burger    \t", "433" },
                { "Zinger Pizza     \t", "87" },
                { "Fries            \t", "343" },
                { "Tacos            \t", "654" },
                { "Shawarma         \t", "543" },
                { "Pratha roll      \t", "987" },
                { "Ice Cream        \t", "456" },
        };
        return list;
    };
}
