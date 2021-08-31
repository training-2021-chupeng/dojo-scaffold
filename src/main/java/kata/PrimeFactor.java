package kata;

import java.util.ArrayList;

public class PrimeFactor {
    public static ArrayList<Integer> of(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < number; i++) {
            number = getFactor(number, list, i);
        }
        if (number >= 2) {
            list.add(number);
        }
        return list;
    }

    private static int getFactor(int number, ArrayList<Integer> list, int i) {
        while (number % i == 0) {
            number /= i;
            list.add(i);
        }
        return number;
    }
}
