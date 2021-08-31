package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PrimeFactorTest {
    @ParameterizedTest
    @MethodSource("dataList")
    void assertResult(int number, List<Integer> expected) {
        assertThat(PrimeFactor.of(number)).isEqualTo(expected);
    }

    private static Stream<Arguments> dataList() {
        return Stream.of(
                Arguments.of(2, Collections.singletonList(2)),
                Arguments.of(3, Collections.singletonList(3)),
                Arguments.of(4, Arrays.asList(2, 2)),
                Arguments.of(6, Arrays.asList(2, 3)),
                Arguments.of(9, Arrays.asList(3, 3)),
                Arguments.of(12, Arrays.asList(2, 2, 3)),
                Arguments.of(15, Arrays.asList(3, 5)),
                Arguments.of(60, Arrays.asList(2, 2, 3, 5)),
                Arguments.of(420, Arrays.asList(2, 2, 3, 5, 7))
        );
    }
}
