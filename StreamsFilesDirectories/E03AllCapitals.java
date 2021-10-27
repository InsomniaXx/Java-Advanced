package Advanced.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class E03AllCapitals {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        Files.readAllLines(Path.of(pathString)).forEach(
                line -> {
                    try {
                        writer.write(line.toUpperCase());
                        writer.newLine();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
        );
        writer.close();
    }
}
