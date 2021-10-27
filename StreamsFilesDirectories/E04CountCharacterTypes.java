package Advanced.StreamsFilesDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class E04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathString));

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;

        for (String line : allLines) {
            for (int index = 0; index < line.length(); index++) {
                char currentChar = line.charAt(index);
                if (currentChar == ' ') {
                    continue;
                }
                if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                    countVowels++;
                } else if (currentChar == '!' || currentChar == '?' || currentChar == '.' || currentChar == ',' ) {
                    countPunctuation++;
                } else {
                    countConsonants++;
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output_4.txt"));

        writer.write("Vowels: " + countVowels);
        writer.newLine();
        writer.write("Consonants: " + countConsonants);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuation);
        writer.newLine();

        writer.close();
    }
}
