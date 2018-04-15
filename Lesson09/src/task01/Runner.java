package task01;

class Runner {

    void run() {
        Runnable r = () -> {
            for(int i = 10; i >= 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Bomb");
        };

        new Thread(r).start();
    }
}
