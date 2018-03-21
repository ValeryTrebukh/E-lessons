package task02.view;

import task02.carriage.Carriage;

import java.util.List;

public class View<T extends Carriage> {

    public void print(List<T > carriages) {
        System.out.println("ID\tPASSENGERS\tLUGGAGE\tCOMFORT");
        for (T c : carriages) {
            System.out.println(c.toString());
        }
        System.out.println();
    }

    public void print(int pass, int lugg) {
        System.out.println("Total train payloads: " + pass + " passengers and " + lugg + " luggage items.");
        System.out.println();
    }
}
