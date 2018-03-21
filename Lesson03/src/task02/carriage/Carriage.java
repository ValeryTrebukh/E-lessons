package task02.carriage;

public abstract class Carriage {

    protected static int number = 1;

    protected int id;

    protected static int nextId() {
        return number++;
    }

    abstract int getPassengers();

    abstract int getComfortLevel();

    abstract int getLuggage();

}
