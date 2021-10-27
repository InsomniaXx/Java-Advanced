package Advanced.StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class L02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("newInput.txt");

        int value = inputStream.read();

        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        while (value != -1) {
            char current = (char) value;
            if (!punctuations.contains(current)) {
                outputStream.write(current);
            }
            value = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
