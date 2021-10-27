package Advanced.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class L04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("ExtractInteger.txt");

        PrintStream out = new PrintStream(outputStream);
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                out.println(i);
            }
            scanner.next();
        }
        inputStream.close();
        outputStream.close();


    }
}
