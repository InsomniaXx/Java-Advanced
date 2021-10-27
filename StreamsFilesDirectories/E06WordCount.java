package Advanced.StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E06WordCount {
    public static void main(String[] args) throws IOException {
        String pathStringWords = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\words.txt";
        String pathStringText = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\Excercise\\text.txt";

        String[] words = Files.readString(Path.of(pathStringWords)).split(" ");
        Map <String, Integer> foundWordsCount = new LinkedHashMap<>();

        String[] text = Files.readString(Path.of(pathStringText)).split(" ");

        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (text[i].equals(words[j])) {
                    if (foundWordsCount.containsKey(words[j])) {
                        foundWordsCount.put(words[j], foundWordsCount.get(words[j]) + 1);
                    } else {
                        foundWordsCount.put(words[j], 1);
                    }
                }
            }
        }

        for (Map.Entry<String, Integer> foundText : foundWordsCount.entrySet()) {
            System.out.printf("%s - %d%n", foundText.getKey(), foundText.getValue());
        }

    }
}
