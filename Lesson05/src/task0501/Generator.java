package task0501;

import java.util.*;

class Generator {

    static List<Integer> getList(int number, int lowerLimit, int upperLimit) {
        List<Integer> result = new ArrayList<>();

        while (result.size() < number) {
            int value = (int)(Math.random()*(upperLimit - lowerLimit + 1)) + lowerLimit;
            result.add(value);
        }
        return result;
    }


    static Set<Integer> getSet(int number, int lowerLimit, int upperLimit) {
        Set<Integer> result = new HashSet<>();

        if(upperLimit - lowerLimit +1 < number) {
            return Collections.emptySet();
        }

        while (result.size() < number) {
            int value = (int)(Math.random()*(upperLimit - lowerLimit + 1)) + lowerLimit;
            result.add(value);
        }
        return result;
    }
}
