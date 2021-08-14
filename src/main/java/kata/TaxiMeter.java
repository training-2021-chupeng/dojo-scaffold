package kata;

public class TaxiMeter {
    private final int distance;
    private final int waitTime;

    public TaxiMeter(int distance, int waitTime) {
        this.distance = distance;
        this.waitTime = waitTime;
    }

    public int calculatePrice() {
        return Rounding(calculate());
    }

    private int Rounding(Double price) {
        return (int) Math.round(price);
    }

    private double calculate() {
        double price = 0;
        if (distance <= 2) {
            price = 6;
        } else if (distance <= 8) {
            price = 6 + (distance - 2) * 0.8;
        } else {
            price = 10.8 + 1.2 * (distance - 8);
        }
        price += waitTime * 0.25;
        return price;
    }
}
