package Advanced.StreamsFilesDirectories;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class E01SumLines {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\input.txt";

        Path path = Path.of(pathString);
        List<String> allLines = Files.readAllLines(path);

//        for (String line : allLines) {
//            int sum = 0;
//            for (int index = 0; index < line.length(); index++) {
//                char currentSymbol = line.charAt(index);
//                sum += currentSymbol;
//            }
//            System.out.println(sum);
//        }
        allLines.stream().map(line -> line.toCharArray()).forEach(
                charArray -> {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                }
        );
    }
}
