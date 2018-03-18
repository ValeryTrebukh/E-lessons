package task02.carriage;

public class PassElite extends Passenger {

    public PassElite() {
        capacity = 36;
        comfortLevel = 2;
    }

    @Override
    public void addLuggage(int count) {
        if (count > 0) {
            luggage = (luggage + count) > passengers ? passengers: luggage + count;
        } else {
            luggage = (luggage + count) < 0 ? 0 : (luggage + count);
        }
    }

}
