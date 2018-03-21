package task02.carriage;

import java.util.*;

public class Train<T extends Carriage> {

    private List<T> carriages = new ArrayList<>();


    public void addCarriage(T carriage) {
        carriages.add(carriage);
    }


//    Sort carriages by comfort level
    public void sort() {
        Collections.sort(carriages, Comparator.comparingInt(Carriage::getComfortLevel));
    }

//    Get total number of passengers in train
    public int calcPass() {
        int result = 0;

        for(T p : carriages) {
            result += p.getPassengers();
        }

        return result;
    }

//    Get total number of luggage items in train
    public int calcLug() {
        int result = 0;

        for(T p : carriages) {
            result += p.getLuggage();
        }

        return result;
    }

//    Find carriages which contains requested (or greater) number of passengers
    public List<T> find(int size) {
        List<T> result = new ArrayList<>();

        for(T car : carriages) {
            if(car.getPassengers() > size) {
                result.add(car);
            }
        }

        return result;
    }


    public List<T> getCarriages() {
        return carriages;
    }
}
