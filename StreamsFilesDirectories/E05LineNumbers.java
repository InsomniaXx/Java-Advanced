package Advanced.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E05LineNumbers {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\inputLineNumbers.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathString));
        BufferedWriter writer = new BufferedWriter(new FileWriter("outputE05.txt"));

        int currentLine = 1;

        for (String line : allLines) {
            writer.write(currentLine + ". " + line);
            writer.newLine();
            currentLine++;
        }
        writer.close();
    }
}
