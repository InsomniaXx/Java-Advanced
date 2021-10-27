package Advanced.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class L01ReadFile {
    public static void main(String[] args) throws IOException{
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt";

//        try {
//            FileInputStream inputStream = new FileInputStream(path);
//
//            int value = inputStream.read();
//
//            while (value != -1) {
//                System.out.print(Integer.toBinaryString(value) + " ");
//                value = inputStream.read();
//            }
//        } catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }

        FileInputStream inputStream = new FileInputStream(path);

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
