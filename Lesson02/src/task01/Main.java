package task01;

import task01.controller.ClinicController;
import task01.model.Clinic;
import task01.model.ClinicImpl;
import task01.view.ClinicView;


public class Main {
    public static void main(String[] args) {

        Clinic clinic = new ClinicImpl();
        ClinicView view = new ClinicView();

        ClinicController controller = new ClinicController(clinic, view);
        controller.run();
    }
}
