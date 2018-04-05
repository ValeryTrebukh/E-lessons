package clinic03;

import clinic03.controller.ClinicController;
import clinic03.model.Clinic;
import clinic03.view.ClinicView;
import org.apache.log4j.Logger;


public class Main {

    private static Logger rootLogger = Logger.getRootLogger();

    public static void main(String[] args) {

        Clinic clinic = new Clinic();
        ClinicView view = new ClinicView();

        rootLogger.info("Application started");

        ClinicController controller = new ClinicController(clinic, view);

        controller.run();

    }
}
