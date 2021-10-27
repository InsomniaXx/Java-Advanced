package Advanced.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class L03CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int value = inputStream.read();

        while (value != -1) {
            if (value != 32 && value != 10){
                System.out.print(value);
            } else{
                System.out.print((char) value);
            }
            value = inputStream.read();
        }
        System.out.println();
    }
}
