package Advanced.StreamsFilesDirectories;

import java.io.*;

public class L05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Scarabey\\IdeaProjects\\JavaFundamentials\\Basic Syntax, Conditional statements and Loops\\src\\Advanced\\StreamsFilesDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader reader = new BufferedReader(inputStreamReader);

        BufferedWriter writer = new BufferedWriter(new PrintWriter("out-third-line.txt"));
        String line = reader.readLine();

        int count = 1;

        while (line != null) {
            if (count % 3 == 0) {
                writer.write(line + System.lineSeparator());
            }
            count++;
            line = reader.readLine();
        }
       writer.flush();
    }
}
