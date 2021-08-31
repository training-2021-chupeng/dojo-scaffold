package kata;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Anagram {
    private final String text;

    public Anagram(String text) {
        this.text = text;
    }

    public ArrayList<String> display() {
        ArrayList<String> list = new ArrayList<>();
        if (text.isEmpty()) {
            return list;
        }
        if (text.length() == 1) {
            list.add(text);
        }
        if (text.length() >= 2) {
            generateList(list);
        }
        return list;
    }

    private void generateList(ArrayList<String> list) {
        for (int i = 0; i < text.length(); i++) {
            for (String word : new Anagram(deleteAt(i)).display()) {
                list.add(text.charAt(i) + word);
            }
        }
    }

    private String deleteAt(int location) {
        String deleteString = "";
        for (int i = 0; i < text.length(); i++) {
            if (i != location)
                deleteString += text.charAt(i);
        }
        return deleteString;
    }
}
