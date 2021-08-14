package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TaxiMeterTest {
    @ParameterizedTest
    @MethodSource("TestCase")
    void assertResult(int distance, int waitTime, int price) {
        assertThat(new TaxiMeter(distance, waitTime).calculatePrice()).isEqualTo(price);
    }

    public static Stream<Arguments> TestCase() {
        return Stream.of(
                Arguments.arguments(1, 0, 6),
                Arguments.arguments(3, 0, 7),
                Arguments.arguments(10, 0, 13),
                Arguments.arguments(2, 3, 7)
        );
    }
}
