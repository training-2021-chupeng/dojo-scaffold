package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WordCounterTest {
    @ParameterizedTest
    @MethodSource("TestCases")
    void should_words_be_counted(String cases, String result) {
        WordCounter wordcounter = new WordCounter();
        assertThat(wordcounter.count(cases)).isEqualTo(result);
    }

    private static Stream<Arguments> TestCases() {
        return Stream.of(
                Arguments.arguments("", ""),
                Arguments.arguments("hello", "hello 1"), // 一般等价类
                Arguments.arguments("hello he", "hello 1\r\nhe 1"),
                Arguments.arguments("hello hello he", "hello 2\r\nhe 1"),
                Arguments.arguments("hello he he", "he 2\r\nhello 1"),
                Arguments.arguments("hello  he", "hello 1\r\nhe 1")
        );
    }
}
