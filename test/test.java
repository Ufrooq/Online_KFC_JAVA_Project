import java.io.FileWriter;
import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        writeLine();
    }

    public static void writeLine() throws IOException {
        FileWriter fileWriter = new FileWriter("D:/Java/Java_Project/test.csv");
        String[][] data1 = { { "sdfddsfa", "28" }, { "sdfddsfa", "28" }, { "sdfddsfa", "28" }, { "sdfddsfa", "28" } };
        for (int i = 0; i < data1.length; i++) {
            for (int j = 0; j < data1[i].length; j++) {
                fileWriter.write(data1[i][j]);
                if (j < data1.length - 1) {
                    fileWriter.write(",");
                }
            }
            fileWriter.write("\n");
        }
        System.out.println("Data write successfully");
        fileWriter.close();
    }
}