package clinic03.controller;

import clinic03.model.Clinic;
import clinic03.utils.Helper;
import clinic03.view.ClinicView;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ClinicController {

    private Clinic clinic;

    private ClinicView view;

    private static Logger rootLogger = Logger.getRootLogger();

    public ClinicController(Clinic clinic, ClinicView view) {
        this.clinic = clinic;
        this.view = view;
    }

    public void run() {

        while(true) {

            rootLogger.info("printing menu");
            view.printMenu();
            int input = Helper.requestInt();
            rootLogger.info("user input: " + input);

            switch (input) {
                case 1:
                    showByDiagnosis();
                    break;
                case 2:
                    showById();
                    break;
                case 3:
                    rootLogger.info("sorting data");
                    clinic.sort();
                    break;
                case 4:
                    loadFromFile();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 0:
                    view.println("Bye!");
                    rootLogger.info("Application closed");
                    System.exit(0);
                    break;
                default:
                    view.println("No such option in menu.");
                    break;
            }
        }
    }

    private void saveToFile() {
        view.println("Enter destination location: ");

        String path = Helper.requestString();

        rootLogger.info("saving data to " + path);

        clinic.saveToFile(path);

        rootLogger.info("saved");
    }

    private void loadFromFile() {
        view.println("Enter destination location: ");
        String path;

        while(true) {
            try {
                path = Helper.requestString();
                rootLogger.info("reading from " + path);
                clinic.loadFromFile(path);
                rootLogger.info("read");
                break;
            } catch (FileNotFoundException e) {
                rootLogger.error("file not found");
                view.println("No such file found, try again.");
            } catch (IOException ignore) {
                rootLogger.fatal("unexpected exception during file reading. ignored");
            }
        }
    }

    private void showByDiagnosis() {
        view.println("Enter diagnosis: ");
        String diagnosis = Helper.requestString();

        rootLogger.info("filtering data by diagnosis: " + diagnosis);
        view.print(clinic.getByDiagnosis(diagnosis));
    }

    private void showById() {
        view.println("Enter first value: ");
        int from = Helper.requestInt();
        view.println("Enter second value: ");
        int to = Helper.requestInt();

        rootLogger.info("filtering data by id: " + from + "-" + to);
        view.print(clinic.getByCardId(from, to));
    }
}
