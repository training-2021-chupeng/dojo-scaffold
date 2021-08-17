package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TaxiMeterTest {
    @ParameterizedTest
    @CsvSource({
            "1,0,6",
            "3,0,7",
            "10,0,13",
            "2,3,7"
    })
    void assertResult(int distance, int waitingTime, int result) {
        assertThat(new TaxiMeter(distance, waitingTime).bill()).isEqualTo(result);
    }
}
