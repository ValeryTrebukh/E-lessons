package clinic02;

import clinic02.controller.ClinicController;
import clinic02.model.Clinic;
import clinic02.view.ClinicView;


public class Main {
    public static void main(String[] args) {

        Clinic clinic = new Clinic();
        ClinicView view = new ClinicView();

        ClinicController controller = new ClinicController(clinic, view);
        controller.run();
    }
}
