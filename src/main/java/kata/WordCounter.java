package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    String text;

    public WordCounter(String test) {
        this.text = test;
    }

    public String count() {
        if (text.isEmpty()) {
            return "";
        }
        String[] words;
        words = text.split(" ");
        for (String word : words) {
            word += " 1";
        }
        return text + " 1";
    }
}
