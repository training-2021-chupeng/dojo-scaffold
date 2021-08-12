package kata;

import static java.lang.String.*;

public class FizzBuzz {
    private final int rawNumber;

    public FizzBuzz(int number) {

        this.rawNumber = number;
    }

    public String translate() {
        String result = "";
        if (isDividedByOrContains(3)) {
            result += "Fizz";
        }
        if (isDividedByOrContains(5)) {
            result += "Buzz";
        }
        return result.isEmpty() ? valueOf(rawNumber) : result;
    }

    private boolean isDividedByOrContains(int number) {
        return rawNumber % number == 0 || valueOf(rawNumber).contains(valueOf(number));
    }
}
