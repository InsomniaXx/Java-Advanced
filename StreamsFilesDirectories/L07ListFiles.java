package Advanced.StreamsFilesDirectories;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class L07ListFiles {
    public static void main(String[] args) {

        Path path = Paths.get("C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt");

        File file = path.toFile();
    }
}
