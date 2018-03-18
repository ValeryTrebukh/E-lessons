package task01.model;


public interface Clinic {

    Patient[] getByDiagnosis (String diagnosis);

    Patient[] getByCardId (int from, int to);

    void sort();
}
