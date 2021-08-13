package kata;

import java.util.ArrayList;

public class WordCounter {
    public String count(String words) {
        String output = "";
        for (String word : words.split("\\s+")) {
            if (!output.isEmpty()) {
                output += "\r\n";
            }
            output += word + " 1";
        }
        return output;
    }
}
