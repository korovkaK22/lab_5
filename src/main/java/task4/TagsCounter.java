package task4;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class TagsCounter {
    File file;

    public Map<String, Integer> countAll() {
        Map<String, Integer> tagCount = new HashMap<>();
        Pattern tagPattern = Pattern.compile("</?([a-zA-Z]+)[^>.]*>");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = tagPattern.matcher(line);
                while (matcher.find()) {
                    String tag = matcher.group(1).toLowerCase();
                    tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tagCount;
    }

    public Map<String, Integer> countAllSortedByAlphabet() {
        Map<String, Integer> unsortedMap = countAll();
        return new TreeMap<>(unsortedMap);
    }

    public Map<String, Integer> countAllSortedByIncreasing() {
        Map<String, Integer> unsortedMap = countAll();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(unsortedMap.entrySet());

        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}