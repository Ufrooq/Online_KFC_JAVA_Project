package utils;

public class menu {

    public void my_menu() {
        String[][] list = list_of_items().clone();
        System.out.println(" ");
        System.out.printf("---------------------------------------------------------%n");
        System.out.printf("|\t%-31s |\t%-15s |%n", "Items name", "Prizes");
        System.out.printf("---------------------------------------------------------%n");
        // System.out.println("No \tItems Available\t\t\tPrizes");
        // System.out.println(
        // "<---------------------------------------------------->");
        for (int i = 0; i < list.length; i++) {
            System.out.println((i + 1) + ". " + "\t" + list[i][0] + "\t\t|\t" + list[i][1] + "\t");
        }
        System.out.printf("---------------------------------------------------------%n");
        System.out.println(" ");
    }

    public String[][] list_of_items() {
        String[][] list = {
                { "Medium-Size Pizza", "700/ Rs-" },
                { "Small-Size Pizza", "343/ Rs-" },
                { "Cheeze Burger   ", "433/ Rs-" },
                { "Zinger Pizza    ", "876/ Rs-" },
                { "Fries           ", "343/ Rs-" },
                { "Tacos           ", "654/ Rs-" },
                { "Shawarma           ", "543/ Rs-" },
                { "Pratha roll           ", "987/ Rs-" },
                { "Ice Cream          ", "456/ Rs-" },
        };
        return list;
    };
}
