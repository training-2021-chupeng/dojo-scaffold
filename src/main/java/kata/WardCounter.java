package kata;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class WardCounter {
    private final String text;

    public WardCounter(String text) {
        this.text = text;
    }

    public String wardCounting() {
        String[] wordsArray = text.split("\\s+");
        Map<String, Integer> groupMap = group(wordsArray);
        Stream<Map.Entry<String, Integer>> sort = sort(groupMap);
        return format(sort);
    }

    private Map<String, Integer> group(String[] wordsArray) {
        return Arrays.stream(wordsArray).collect(groupingBy(item -> item)).entrySet().stream()
                .collect(toMap(Map.Entry::getKey, item -> item.getValue().size()));
    }

    private Stream<Map.Entry<String, Integer>> sort(Map<String, Integer> group) {
        return group.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue());
    }

    private String format(Stream<Map.Entry<String, Integer>> sortedWardList) {
        return sortedWardList
                .map(pair -> pair.getKey() + " " + pair.getValue()).collect(Collectors.joining("\r\n"));
    }
}
