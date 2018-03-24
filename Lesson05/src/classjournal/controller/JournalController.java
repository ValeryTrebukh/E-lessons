package classjournal.controller;

import classjournal.entity.Address;
import classjournal.entity.Student;
import classjournal.model.JournalModel;
import classjournal.utils.Helper;
import classjournal.view.JournalView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JournalController {

    private JournalModel model = new JournalModel();
    private JournalView view = new JournalView();

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

        final String regexName = "[a-z]{2,}";
        final String regexDateOfBirth = "(\\d{2}\\.){2}\\d{4}";
        final String regexPhone = "[+]?\\d{1,2}([(]\\d{3}[)]|\\d{3})\\d{7}";

        view.printMessage("Enter student's first name");
        String firstName = getMatchingString(regexName);

        view.printMessage("Enter student's last name");
        String lastName = getMatchingString(regexName);

        view.printMessage("Enter student's date of birth in format 'mm.dd.yyyy'");
        String dateOfBirth = getMatchingString(regexDateOfBirth);

        view.printMessage("Enter student's phone number");
        String phoneNumber = getMatchingString(regexPhone);

        view.printMessage("Enter student's address");
        Address address = requestAddress();

        return new Student(lastName, firstName, dateOfBirth, phoneNumber, address);
    }


    private Address requestAddress() {

        final String regexStreet = "(\\d+|[a-z]+)( [a-z]+)*";
        final String regexBuilding = "\\d{1,5}[a-z]?";
        final String regexRoom = "\\d{1,5}";

        view.printMessage("Enter street name");
        String street = getMatchingString(regexStreet);

        view.printMessage("Enter building number");
        String building = getMatchingString(regexBuilding);

        view.printMessage("Enter room number");
        String room = getMatchingString(regexRoom);

        return new Address(street, building, room);
    }


    private String getMatchingString(String regex) {

        String name = Helper.requestString();

        while (!isValidString(name, regex)) {
            view.printMessage("Incorrect entry. Try again.");
            name = Helper.requestString();
        }

        return name;
    }

    private boolean isValidString(String string, String regex) {

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);

        return m.matches();
    }
}