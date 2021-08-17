package kata;

import java.util.*;

public class WordCounter {
    private final String text;

    public WordCounter(String text) {
        this.text = text;
    }

    public String countReport() {
        if (text.isEmpty()) {
            return "";
        }
        return countWord();
    }

    private String countWord() {
        String[] words = text.split("\\s+");
        HashMap<String, Integer> groupWords = grouping(words);
        ArrayList<Map.Entry<String, Integer>> sortedGroup = sorting(groupWords);
        return format(sortedGroup);
    }

    private String format(ArrayList<Map.Entry<String, Integer>> sortedGroup) {
        ArrayList<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> word : sortedGroup) {
            output.add(word.getKey() + " " + word.getValue());
        }
        return String.join("\r\n", output);
    }

    private ArrayList<Map.Entry<String, Integer>> sorting(HashMap<String, Integer> wordCounter) {
        ArrayList<Map.Entry<String, Integer>> resultCollector = new ArrayList<>(wordCounter.entrySet());
        Collections.sort(resultCollector, (o1, o2) -> o2.getValue() - o1.getValue());
        return resultCollector;
    }

    private HashMap<String, Integer> grouping(String[] wordLayout) {
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word : wordLayout) {
            if (wordCounter.putIfAbsent(word, 1) != null) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            }
        }
        return wordCounter;
    }
}
