package kata;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {
    public String count(String words) {
        if (words.isEmpty()) {
            return "";
        }
        return frequency(words);
    }

    private String frequency(String words) {
        Stream<String> wordsArray = split(words);
        Set<Map.Entry<String, List<String>>> groupWords = group(wordsArray);
        Stream<Map.Entry<String, List<String>>> sortedWords = sort(groupWords);
        return format(sortedWords);
    }

    private String format(Stream<Map.Entry<String, List<String>>> sort) {
        return sort
                .map(item -> item.getKey() + " " + item.getValue().size())
                .collect(Collectors.joining("\r\n"));
    }

    private Stream<Map.Entry<String, List<String>>> sort(Set<Map.Entry<String, List<String>>> group) {
        return group.stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size());
    }

    private Set<Map.Entry<String, List<String>>> group(Stream<String> split) {
        return split
                .collect(Collectors.groupingBy(item -> item)).entrySet();
    }

    private Stream<String> split(String words) {
        return Arrays.stream(words.split(" "))
                .filter(word -> !word.isEmpty());
    }
}
