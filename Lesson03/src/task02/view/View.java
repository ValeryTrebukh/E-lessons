package task02.view;

import task02.carriage.Passenger;

public class View {

    public void print(Passenger[] carriages) {
        System.out.println("ID\tPASSENGERS\tLUGGAGE\tCOMFORT");
        for (Passenger c : carriages) {
            if(c != null)
                System.out.println(c.toString());
        }
        System.out.println();
    }

    public void print(int pass, int lugg) {
        System.out.println("Total train payloads: " + pass + " passengers and " + lugg + " luggage items.");
        System.out.println();
    }
}
