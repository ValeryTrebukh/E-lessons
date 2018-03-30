package clinic02.model;

import clinic02.utils.Helper;

import java.io.*;
import java.util.*;

public class Clinic implements Serializable {

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

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            List<Patient> list = new ArrayList<>();

            while(true) {
                Patient p;

                try{
                    p = (Patient)ois.readObject();
                    list.add(p);
                } catch (EOFException ignore) {
                    break;
                }
            }

            patients = (Patient[]) list.toArray();
            patients = new Patient[list.size()];

            for(int i = 0; i < list.size(); i++) {
                patients[i] = list.get(i);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("cnf");
        }
    }

    public void saveToFile(String fileName) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            for(Patient p : patients) {
                oos.writeObject(p);
            }

        } catch (IOException ignore) {
        }
    }
}
