package kata;

import static java.lang.String.*;

public class FizzBuzz {
    public String translate(int number) {
        String output = "";
        if (isDividedContains(number, 3)) {
            output += "Fizz";
        }
        if (isDividedContains(number, 5)) {
            output += "Buzz";
        }

        return output.isEmpty() ? valueOf(number) : output;
    }

    private boolean isDividedContains(int rawNumber, int Number) {
        return isDividedBy(rawNumber, Number) || isContains(rawNumber, valueOf(Number));
    }

    private boolean isContains(int rawNumber, String Number) {
        return valueOf(rawNumber).contains(Number);
    }

    private boolean isDividedBy(int rawNumber, int number) {
        return rawNumber % number == 0;
    }
}
