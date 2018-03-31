package clinic02.model;

import clinic02.utils.FileWorker;
import clinic02.utils.Helper;

import java.io.*;
import java.util.*;

public class Clinic {

    private Patient[] patients = Helper.getPatients(27);

    public Patient[] getByDiagnosis(String diagnosis) {

        int count = 0;

        for (Patient p : patients) {
            if(p.getDiagnosis().equals(diagnosis)) {
                count++;
            }
        }

        Patient[] result = new Patient[count];

        int i = 0;

        for (Patient p : patients) {
            if(p.getDiagnosis().equals(diagnosis)) {
                result[i] = p;
                i++;
            }
        }
        return result;
    }

    public Patient[] getByCardId(int from, int to) {
        int count = 0;
        if(to < from) {
            from = from - to;
            to = to + from;
            from = to - from;
        }

        for (Patient p : patients) {
            if(p.getCardId() >= from && p.getCardId() <= to) {
                count++;
            }
        }

        Patient[] result = new Patient[count];

        int i = 0;

        for (Patient p : patients) {
            if(p.getCardId() >= from && p.getCardId() <= to) {
                result[i] = p;
                i++;
            }
        }
        return result;
    }

    public void sort() {
        Arrays.sort(patients, Comparator.comparing(Patient::getLastName));
    }

    public void loadFromFile(String fileName) throws IOException {

        patients =  FileWorker.loadFromFile(fileName);

    }

    public void saveToFile(String fileName) {

        FileWorker.saveToFile(fileName, patients);

    }
}
