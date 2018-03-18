package task02.carriage;

public class Passenger extends Carriage {

    protected int capacity;

    protected int passengers;

    protected int luggage;

    protected int comfortLevel;


    public Passenger() {
        id = nextId();
    }

    public void addPassengers(int count) {
        if (count > 0) {
            passengers = (passengers + count) > capacity ? capacity : (passengers + count);
        } else {
            passengers = (passengers + count) < 0 ? 0 : (passengers + count);
        }
    }

    public void addLuggage(int count) {

    }

    int getPassengers() {
        return passengers;
    }

    int getLuggage() {
        return luggage;
    }

    int getComfortLevel() {
        return comfortLevel;
    }

    @Override
    public String toString() {

        return String.format("%-1s", id) + "\t" + String.format("%-10s", passengers) + "\t" + String.format("%-7s", luggage) + "\t" + String.format("%-10s", comfortLevel);
    }
}
