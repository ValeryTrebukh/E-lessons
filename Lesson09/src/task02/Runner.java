package task02;

class Runner {
    private int value = 0;
    private int MAX_VALUE = 1_000_000;

    private boolean printed = false;

    void run() {

        Thread counter = new Thread(() -> {
            while (value < MAX_VALUE) {
                synchronized (this) {
                    while (!printed) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    value++;
                    printed = false;
                    notify();
                }
            }
        });

        Thread printer = new Thread(() -> {
            while (value < MAX_VALUE) {
                synchronized (this) {
                    while (printed) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(value);
                    printed = true;
                    notify();
                }
            }
        });

        printer.start();
        counter.start();
    }
}
