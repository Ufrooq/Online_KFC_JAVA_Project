package utils;

public class menu {

    public void my_menu() {
        String[][] list = {
                { "1.\tMedium-Size Pizza", "700/Rs-" },
                { "2.\tSmall-Size Pizza", "343/Rs-" },
                { "3.\tCheeze Burger   ", "433/Rs-" },
                { "4.\tZinger Pizza    ", "876/Rs-" },
                { "5.\tFries           ", "343/Rs-" },
                { "6.\tFries           ", "654/Rs-" },
                { "7.\tFries           ", "543/Rs-" },
                { "8.\tFries           ", "987/Rs-" },
                { "9.\tFries           ", "456/Rs-" },
        };
        System.out.println(" ");
        System.out.println("No \tItems Available\t\t\t\tPrizes");
        System.out.println(
                "<---------------------------------------------------->");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i][0] + "\t\t\t" + list[i][1] + "\t");
        }
        System.out.println(
                "<---------------------------------------------------->");
        System.out.println(" ");
    }

    public static void main(String[] args) {
    }
}
