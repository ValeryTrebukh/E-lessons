package clinic03.utils;

import clinic03.model.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {

    public static Patient[] loadFromFile(String fileName) throws IOException {

        Patient[] patients = null;

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

            patients = new Patient[list.size()];

            for(int i = 0; i < list.size(); i++) {
                patients[i] = list.get(i);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("cnf");
        }

        return patients;
    }

    public static void saveToFile(String fileName, Patient[] patients) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

            for(Patient p : patients) {
                oos.writeObject(p);
            }

        } catch (IOException ignore) {
        }
    }
}
