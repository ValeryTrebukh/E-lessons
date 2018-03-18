package task02.carriage;

import java.util.Arrays;
import java.util.Comparator;

public class Train<T extends Passenger> {

    private Passenger[] carriages;

    public Train(int number) {
        carriages = new Passenger[number];
    }


    public void addCarriage(T carriage) {
        for (int i = 0; i < carriages.length; i++) {
            if(carriages[i] == null) {
                carriages[i] = carriage;
                break;
            }
        }
    }


//    Sort carriages by comfort level
    public void sort() {
        Arrays.sort(carriages, Comparator.comparingInt(Passenger::getComfortLevel));
    }

//    Get total number of passengers in train
    public int calcPass() {
        int result = 0;

        for(Passenger p : carriages) {
            result += p.getPassengers();
        }

        return result;
    }

//    Get total number of luggage items in train
    public int calcLug() {
        int result = 0;

        for(Passenger p : carriages) {
            result += p.getLuggage();
        }

        return result;
    }

//    Find carriages which contains requested (or greater) number of passengers
    public Passenger[] find(int size) {
        Passenger[] result = Arrays.copyOf(carriages, carriages.length);

        for(int i = 0; i < result.length; i++) {
            if(carriages[i].getPassengers() < size) {
                result[i] = null;
            }
        }
        return result;
    }


    public Passenger[] getCarriages() {
        return carriages;
    }
}
