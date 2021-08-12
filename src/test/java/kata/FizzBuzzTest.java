package kata;

import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @ParameterizedTest
    @MethodSource("dataList")
    public void assertResult(int number, String expectation) {
        assertThat(fizzBuzz.translate(number)).isEqualTo(expectation);
    }

    private static Stream<Arguments> dataList() {
        return Stream.of(
                Arguments.arguments(1,"1"),
                Arguments.arguments(67,"67"),
                Arguments.arguments(3,"Fizz"),
                Arguments.arguments(66,"Fizz"),
                Arguments.arguments(5,"Buzz"),
                Arguments.arguments(20,"Buzz"),
                Arguments.arguments(15,"FizzBuzz"),
                Arguments.arguments(300,"FizzBuzz"),
                Arguments.arguments(37,"Fizz"),
                Arguments.arguments(131,"Fizz"),
                Arguments.arguments(58,"Buzz"),
                Arguments.arguments(157,"Buzz"),
                Arguments.arguments(352,"FizzBuzz"),
                Arguments.arguments(53,"FizzBuzz")
        );
    }
}
