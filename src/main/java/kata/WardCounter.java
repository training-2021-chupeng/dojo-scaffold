package kata;

import java.util.*;

public class WardCounter {
    private String text;

    public WardCounter(String text) {
        this.text = text;
    }

    public String wardCounting() {
        HashMap<String, Integer> wardStorage = new HashMap<>();
        addToWardMap(wardStorage);

        List<Map.Entry<String, Integer>> sortedWardList = new ArrayList<>(wardStorage.entrySet());
        Collections.sort(sortedWardList, (o1, o2) -> o2.getValue()-o1.getValue());

        String output = "";
        for (Map.Entry pair : sortedWardList) {
            output = formatWardList(output, pair);
        }
        return output;
    }

    private String formatWardList(String output, Map.Entry pair) {
        if (!output.isEmpty()) {
            output += "\r\n";
        }
        output += pair.getKey();
        output += " ";
        output += pair.getValue();
        return output;
    }

    private void addToWardMap(HashMap<String, Integer> wardStorage) {
        for (String ward : text.split("\\s+")) {
            if (wardStorage.putIfAbsent(ward, 1) != null) {
                wardStorage.put(ward, wardStorage.get(ward) + 1);
            }
        }
    }
}
