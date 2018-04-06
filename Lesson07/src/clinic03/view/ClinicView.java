package clinic03.view;

import clinic03.model.Patient;
import org.apache.log4j.Logger;


public class ClinicView {

    private static Logger rootLogger = Logger.getRootLogger();


    public void print(Patient [] patients, String errMessage) {

        rootLogger.info("printing patients list size of " + patients.length);

        if (patients.length == 0) {
            System.out.println(errMessage);
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

}
