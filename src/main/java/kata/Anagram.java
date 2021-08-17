package kata;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
    private String text;

    public Anagram(String text) {
        this.text = text;
    }

    public List<String> display() {
        List<String> list = new ArrayList<>();
        if (!text.isEmpty()) {
            list.add(text);
        }
        return list;
    }
}
