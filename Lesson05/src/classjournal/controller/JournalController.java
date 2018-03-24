package classjournal.controller;

import classjournal.entity.Student;
import classjournal.model.JournalModel;
import classjournal.utils.Helper;
import classjournal.view.JournalView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JournalController {

    private JournalModel model = new JournalModel();
    private JournalView view = new JournalView();

    private static final String INCORRECT_INPUT = "Incorrect entry. Try again.";

    public JournalController(JournalModel model, JournalView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.printMenu();
            switch (Helper.requestInt()) {
                case 1:
                    view.printStudents(model.getStudents());
                    break;
                case 2:
                    model.addStudent(createStudent());
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private Student createStudent() {

        view.printMessage("Enter student's first name");
        String firstName = requestName();

        view.printMessage("Enter student's last name");
        String lastName = requestName();

        view.printMessage("Enter student's date of birth in format 'mm.dd.yyyy'");
        String dateOfBirth = requestDateOfBirth();

        view.printMessage("Enter student's address in format 'Street, building, apartments'");
        String address = requestAddress();

        view.printMessage("Enter student's phone number");
        String phoneNumber = requestPhoneNumber();

        return new Student(lastName, firstName, dateOfBirth, phoneNumber, address);
    }


    private String requestName() {

        String name = Helper.requestString();

        while (!isValidName(name)) {
            view.printMessage(INCORRECT_INPUT);
            name = Helper.requestString();
        }

        return name;
    }

    private boolean isValidName(String name) {

        String regex = "[a-z]{2,}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);

        return m.matches();
    }


    private String requestDateOfBirth() {

        String dob = Helper.requestString();

        while (!isValidDateOfBirth(dob)) {
            view.printMessage(INCORRECT_INPUT);
            dob = Helper.requestString();
        }

        return dob;
    }

    private boolean isValidDateOfBirth(String dob) {

        String regex = "(\\d{2}\\.){2}\\d{4}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(dob);

        return m.matches();
    }


    private String requestAddress() {

        String address = Helper.requestString();

        while (!isValidAddress(address)) {
            view.printMessage(INCORRECT_INPUT);
            address = Helper.requestString();
        }

        return address;
    }

    private boolean isValidAddress(String address) {

        String regex = "(\\d+|[a-zA-Z]+)( [a-zA-Z]+)*, \\d{1,5}[a-zA-Z]?, \\d{1,5}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(address);

        return m.matches();
    }


    private String requestPhoneNumber() {

        String phoneNumber = Helper.requestString();

        while (!isValidPhoneNumber(phoneNumber)) {
            view.printMessage(INCORRECT_INPUT);
            phoneNumber = Helper.requestString();
        }

        return phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {

        String regex = "[+]?\\d{1,2}([(]\\d{3}[)]|\\d{3})\\d{7}";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(phoneNumber);

        return m.matches();
    }
}
