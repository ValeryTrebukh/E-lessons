package clinic03.controller;

import clinic03.model.Clinic;
import clinic03.utils.Helper;
import clinic03.view.ClinicView;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

public class ClinicController {

    private Clinic clinic;
    private ClinicView view;
    private static Logger rootLogger = Logger.getRootLogger();
    private ResourceBundle bundle = ResourceBundle.getBundle("location.lang");

    public ClinicController(Clinic clinic, ClinicView view) {
        this.clinic = clinic;
        this.view = view;
    }

    public void run() {
        while (true) {

            rootLogger.info("printing menu");
            view.println(bundle.getString("menu"));
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
                case 9:
                    changeLang();
                    break;
                case 0:
                    view.println("Bye!");
                    rootLogger.info("Application closed");
                    System.exit(0);
                    break;
                default:
                    view.println(bundle.getString("incorrectinput"));
                    break;
            }
        }
    }

    private void changeLang() {

        view.println("1 - ENGLISH\t2 - RUSSIAN");
        int input = Helper.requestInt();

        while (input != 1 && input != 2) {
            view.println(bundle.getString("incorrectinput"));
            input = Helper.requestInt();
        }

        if (input == 1) {
            bundle = ResourceBundle.getBundle("location.lang_en");
        } else {
            bundle = ResourceBundle.getBundle("location.lang_ru");
        }

    }


    private void saveToFile() {
        view.println(bundle.getString("filedestination"));
        String path = Helper.requestString();
        rootLogger.info("saving data to " + path);
        clinic.saveToFile(path);
        rootLogger.info("saved");
    }

    private void loadFromFile() {
        view.println(bundle.getString("filedestination"));
        String path;

        while (true) {
            try {
                path = Helper.requestString();
                if(path.toUpperCase().equals("CANCEL")) {
                    break;
                }
                rootLogger.info("reading from " + path);
                clinic.loadFromFile(path);
                rootLogger.info("read");
                break;
            } catch (FileNotFoundException e) {
                rootLogger.error("file not found");
                view.println(bundle.getString("nosuchfile"));
            } catch (IOException ignore) {
                rootLogger.fatal("unexpected exception during file reading. ignored");
            }
        }
    }

    private void showByDiagnosis() {
        view.println(bundle.getString("diagnosis"));
        String diagnosis = Helper.requestString();
        rootLogger.info("filtering data by diagnosis: " + diagnosis);
        view.print(clinic.getByDiagnosis(diagnosis), bundle.getString("emptylist"));
    }

    private void showById() {
        view.println(bundle.getString("firstvalue"));
        int from = Helper.requestInt();
        view.println(bundle.getString("secondvalue"));
        int to = Helper.requestInt();
        rootLogger.info("filtering data by id: " + from + "-" + to);
        view.print(clinic.getByCardId(from, to), bundle.getString("emptylist"));
    }
}
