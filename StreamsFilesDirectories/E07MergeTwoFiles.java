package Advanced.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathFirstFile = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\inputOne.txt";
        String pathSecondFile = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\inputTwo.txt";

        List<String> firstLines = Files.readAllLines(Path.of(pathFirstFile));
        List<String> secondLines = Files.readAllLines(Path.of(pathSecondFile));

        BufferedWriter writer = new BufferedWriter(new FileWriter("outputE07.txt"));

        writeToFile(writer, firstLines);
        writeToFile(writer, secondLines);

        writer.close();
    }

    private static void writeToFile(BufferedWriter writer, List<String> lines) throws IOException {
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
    }
}
