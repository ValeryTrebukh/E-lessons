package clinic02.controller;

import clinic02.model.Clinic;
import clinic02.utils.Helper;
import clinic02.view.ClinicView;

import java.io.FileNotFoundException;
import java.io.IOException;

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
                    showByDiagnosis();
                    break;
                case 2:
                    showById();
                    break;
                case 3:
                    clinic.sort();
                    break;
                case 4:
                    loadFromFile();
                    break;
                case 5:
                    view.println("Enter destination location: ");
                    clinic.saveToFile(Helper.requestString());
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

    private void loadFromFile() {
        view.println("Enter destination location: ");

        while(true) {
            try {
                clinic.loadFromFile(Helper.requestString());
                break;
            } catch (FileNotFoundException e) {
                view.println("File not found, try again with correct file name");
            } catch (IOException ignore) {

            }
        }

    }

    private void showByDiagnosis() {
        view.println("Enter diagnosis: ");
        view.print(clinic.getByDiagnosis(Helper.requestString()));
    }

    private void showById() {
        view.println("Enter first value: ");
        int from = Helper.requestInt();
        view.println("Enter second value: ");
        int to = Helper.requestInt();
        view.print(clinic.getByCardId(from, to));
    }
}
