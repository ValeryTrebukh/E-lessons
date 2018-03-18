package task01.model;

import task01.utils.Helper;

import java.util.Arrays;
import java.util.Comparator;

public class ClinicImpl implements Clinic {

    private Patient[] patients = Helper.getPatients(7);

    @Override
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

    @Override
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

    @Override
    public void sort() {
        Arrays.sort(patients, Comparator.comparing(Patient::getLastName));
    }

}
