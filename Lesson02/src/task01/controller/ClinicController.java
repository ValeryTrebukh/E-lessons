package task01.controller;

import task01.model.Clinic;
import task01.utils.Helper;
import task01.view.ClinicView;

public class ClinicController {

    private Clinic clinic;

    private ClinicView view;

    public ClinicController(Clinic clinic, ClinicView view) {
        this.clinic = clinic;
        this.view = view;
    }

    public void run() {
        boolean exit = false;

        while(!exit) {

            view.printMenu();
            int input = Helper.requestInt();

            switch (input) {
                case 1:
                    view.print(clinic.getByDiagnosis(Helper.requestString()));
                    break;
                case 2:
                    view.print("Enter first value: ");
                    int from = Helper.requestInt();
                    view.print("Enter second value: ");
                    int to = Helper.requestInt();
                    view.print(clinic.getByCardId(from, to));
                    break;
                case 3:
                    clinic.sort();
                    view.println("Data has been sorted.");
                    break;
                case 0:
                    exit = true;
                    view.println("Bye!");
                    break;
                default:
                    view.println("No such option in menu.");
                    break;
            }
        }
    }
}
