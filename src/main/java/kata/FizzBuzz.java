package kata;

import static java.lang.String.valueOf;

public class FizzBuzz {
    public static final int FIZZ_NUMBER = 3;
    public static final int BUZZ_NUMBER = 5;
    private final int number;

    public FizzBuzz(int number) {
        this.number = number;
    }

    public String report() {
        String result = "";
        if (isContainOrDividedBy(FIZZ_NUMBER)) {
            result += "Fizz";
        }
        if (isContainOrDividedBy(BUZZ_NUMBER)) {
            result += "Buzz";
        }
        return result.isEmpty() ? valueOf(number) : result;
    }

    private boolean isContainOrDividedBy(int checkNumber) {
        return isDividedBy(checkNumber) || isContains(checkNumber);
    }

    private boolean isContains(int checkNumber) {
        return valueOf(number).contains(valueOf(checkNumber));
    }

    private boolean isDividedBy(int checkNumber) {
        return number % checkNumber == 0;
    }
}
