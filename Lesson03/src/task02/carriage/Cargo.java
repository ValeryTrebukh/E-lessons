package task02.carriage;

public class Cargo extends Carriage {
    @Override
    int getPassengers() {
        return 0;
    }

    @Override
    int getComfortLevel() {
        return -1;
    }

    @Override
    int getLuggage() {
        return 0;
    }
}
