import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list_1 = new ArrayList<>();
        list_1.add(1);
        list_1.add(2);
        list_1.add(3);
        System.out.println(list_1);
        list_1.removeAll(list_1);
        System.out.println(list_1);

    }
}