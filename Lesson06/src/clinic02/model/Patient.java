package clinic02.model;

import java.io.Serializable;

public class Patient implements Serializable {

    private String lastName;

    private String firstName;

    private String fatherName;

    private String address;

    private String phoneNumber;

    private int cardId;

    private String diagnosis;

    public Patient(String lastName, String firstName, String fatherName, String address, String phoneNumber, int cardId, String diagnosis) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fatherName = fatherName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cardId = cardId;
        this.diagnosis = diagnosis;
    }

    public Patient() {

    }

    public String getLastName() {
        return lastName;
    }

    public int getCardId() {
        return cardId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Name: " + lastName + " " + firstName + " " + fatherName +
                "; address: " + address +
                "; phone: " + phoneNumber +
                "; cardId: " + cardId +
                "; diagnosis: " + diagnosis;
    }
}
