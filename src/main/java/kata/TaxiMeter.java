package kata;

public class TaxiMeter {
    public static final int STARTING_PRICE = 6;
    public static final int STARTING_DISTANCE = 2;
    public static final double PRICE_PER_KILOMETER = 0.8;
    public static final int STARTING_LONG_DISTANCE = 8;
    public static final double LONG_DISTANCE_PRICE_RATE = 1.5;
    public static final double PRICE_PER_MINUTE_WAITING = 0.25;
    private final int distance;
    private final int waitingTime;

    public TaxiMeter(int distance, int waitingTime) {
        this.distance = distance;
        this.waitingTime = waitingTime;
    }

    public int bill() {
        return (int) Math.round(distancePrice(distance) + waitingPrice());
    }

    private double waitingPrice() {
        return waitingTime * PRICE_PER_MINUTE_WAITING;
    }

    private double distancePrice(int distance) {
        if (distance <= STARTING_DISTANCE) {
            return STARTING_PRICE;
        } else if (distance <= STARTING_LONG_DISTANCE) {
            return distancePrice(STARTING_DISTANCE) + extraDistancePrice(distance - STARTING_DISTANCE);
        } else {
            return distancePrice(STARTING_LONG_DISTANCE) + extraDistancePrice(distance - STARTING_LONG_DISTANCE) * LONG_DISTANCE_PRICE_RATE;
        }
    }

    private double extraDistancePrice(int distance) {
        return distance * PRICE_PER_KILOMETER;
    }
}
