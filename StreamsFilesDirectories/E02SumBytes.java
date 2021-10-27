package Advanced.StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E02SumBytes {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(pathString));
        long sum = 0;

        for (byte value : allBytes) {
            if (value != 10 && value != 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
