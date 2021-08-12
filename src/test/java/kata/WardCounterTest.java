package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WardCounterTest {
    @ParameterizedTest
    @MethodSource("testSample")
    void WardCounterTest(String text, String result) {
        assertThat(new WardCounter(text).wardCounting()).isEqualTo(result);
    }

    private static Stream<Arguments> testSample() {
        return Stream.of(
                Arguments.arguments("hello", "hello 1"),
                Arguments.arguments("hello he", "hello 1\r\nhe 1"),
                Arguments.arguments("hello hello he", "hello 2\r\nhe 1"),
                Arguments.arguments("hello he he", "he 2\r\nhello 1"),
                Arguments.arguments("hello  he", "hello 1\r\nhe 1")
        );
    }
}
