package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "67,67",
            "3,Fizz",
            "5,Buzz",
            "15,FizzBuzz",
            "37,Fizz",
            "58,Buzz",
            "53,FizzBuzz"
    })
    public void FizzBuzzTest(int number, String expectation) {
        assertThat(new FizzBuzz(number).translate()).isEqualTo(expectation);
    }
}
