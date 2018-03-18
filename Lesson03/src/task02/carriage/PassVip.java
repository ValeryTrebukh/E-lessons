package task02.carriage;

public class PassVip extends PassElite {

    public PassVip() {
        capacity = 20;
        comfortLevel = 3;
    }


    @Override
    public void addLuggage(int count) {
        if (count > 0) {
            luggage = luggage + count;
        } else {
            luggage = (luggage + count) < 0 ? 0 : (luggage + count);
        }
    }
}
