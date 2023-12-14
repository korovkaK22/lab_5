package task1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MyCustomStringReader {
    private File file;

    public String getTheLongestString() {
        String longestString = "";
        int maxWordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader( file))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] words = currentLine.split("\\b\\w+\\b");
                if (words.length > maxWordCount) {
                    maxWordCount = words.length;
                    longestString = currentLine;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestString;
    }
}




