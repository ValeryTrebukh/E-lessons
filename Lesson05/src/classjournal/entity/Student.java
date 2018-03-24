package classjournal.entity;

import java.util.Date;

public class Student {

    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String phoneNumber;
    private String address;

    public Student(String lastName, String firstName, String dateOfBirth, String phoneNumber, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", DoB: " + dateOfBirth +
                ", phone: " + phoneNumber + ", address: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!lastName.equals(student.lastName)) return false;
        if (!firstName.equals(student.firstName)) return false;
        return address.equals(student.address);
    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}