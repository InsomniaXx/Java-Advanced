package Advanced.StreamsFilesDirectories;

import java.io.File;

public class E08GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\04. Java-Advanced-Advanced.Files-and-Streams-Exercises-Resources";

        File folder = new File(path);
        File[] filesInFolder = folder.listFiles();

        int folderSize = 0;

        for (File file : filesInFolder) {
            folderSize += file.length();
        }

        System.out.println(folderSize);

    }
}
