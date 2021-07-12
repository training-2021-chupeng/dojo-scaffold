package kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DemoTest {
    @Test
    void example() {
        Demo demo = new Demo();

        Integer result = demo
                .add(1, 1);
        assertThat(result).isEqualTo(2);
    }
}
