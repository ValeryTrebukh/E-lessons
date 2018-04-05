package clinic03.view;

import clinic03.model.Patient;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class ClinicView {

    private static Logger rootLogger = Logger.getRootLogger();

//    ResourceBundle bundle = ResourceBundle.getBundle("location.lang", new Locale("ru", "RU"));
    ResourceBundle bundle = ResourceBundle.getBundle("location.lang");

    public void print(Patient [] patients) {

        rootLogger.info("printing patients list size of " + patients.length);

        if (patients.length == 0) {
            System.out.println("No results matching your request.");
        } else {
            for (Patient p : patients) {
                rootLogger.debug(p.toString());
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public void println(String message) {
        System.out.println(message);
    }


   /* public void printMenu() {
        System.out.println("\n1 - SELECT BY DIAGNOSIS    2 - SELECT BY ID    " +
                "3 - SORT BY NAME    4 - LOAD    5 - SAVE    0 - EXIT");
    }*/
    public void printMenu() {
        System.out.println(bundle.getString("menu"));
    }
}
