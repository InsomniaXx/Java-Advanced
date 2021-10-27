package Advanced.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L06SortLines {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Path path = Paths.get("C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt");

       List<String> lines = Files.readAllLines(path)
                .stream()
                .sorted()
                .collect(Collectors.toList());

       BufferedWriter writer = Files.newBufferedWriter(Paths.get("outSorted.txt"));
       writer.write(lines.stream().collect(Collectors.joining(System.lineSeparator())));
       writer.flush();
    }
}
