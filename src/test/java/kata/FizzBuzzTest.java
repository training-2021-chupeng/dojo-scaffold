package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FizzBuzzTest {
    @ParameterizedTest
    @CsvSource({
            "1,1",
            "3,Fizz",
            "5,Buzz",
            "60,FizzBuzz",
            "37,Fizz",
            "58,Buzz",
            "537,FizzBuzz"
    })
    void assertResult(int number, String result) {
        assertThat(new FizzBuzz(number).report()).isEqualTo(result);
    }
}
