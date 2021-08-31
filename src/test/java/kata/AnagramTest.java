package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AnagramTest {
    @ParameterizedTest
    @MethodSource("Testcase")
    void TestResult(String text, List<Object> expected) {
        assertThat(new Anagram(text).display()).isEqualTo(expected);
    }

    public static Stream<Arguments> Testcase() {
        return Stream.of(
                Arguments.arguments("", new ArrayList<>()),
                Arguments.arguments("b", Arrays.asList("b")),
                Arguments.arguments("bi", Arrays.asList("bi", "ib")),
                Arguments.arguments("bio", Arrays.asList("bio", "boi", "ibo", "iob", "obi", "oib")),
                Arguments.arguments("biro", Arrays.asList(
                        "biro", "bior", "brio", "broi", "boir", "bori",
                        "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                        "rbio", "rboi", "ribo", "riob", "robi", "roib",
                        "obir", "obri", "oibr", "oirb", "orbi", "orib"
                ))
        );
    }
}
