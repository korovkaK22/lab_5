package task4;

import task1.MyCustomStringReader;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/task4/dostoievskyy-fedir-mykhaylovych-zlochyn-i-kara798.html";
        File file = new File(path);

        TagsCounter tagsCounter = new TagsCounter(file);


        //Непосортована мапа
        System.out.println("\n\nUnsorted map:");
        Map<String, Integer> tags = tagsCounter.countAll();
        tags.forEach((key, value) -> System.out.println(key + ": " + value));

        //Сортована за алфавітом
        System.out.println("\n\nSorted by alphabet map:");
        Map<String, Integer> sortedByAlphabetTags = tagsCounter.countAllSortedByAlphabet();
        sortedByAlphabetTags.forEach((key, value) -> System.out.println(key + ": " + value));

        //Сортована за зростанням
        System.out.println("\n\nSorted by increasing map:");
        Map<String, Integer> sortedByIncreasingTags = tagsCounter.countAllSortedByIncreasing();
        sortedByIncreasingTags.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
