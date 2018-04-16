package task03;

public class Main {
    public static void main(String[] args) {
        try {
            new Runner().run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
