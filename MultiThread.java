class EvenThread extends Thread {

    int limit;

    EvenThread(int limit) {
        this.limit = limit;
    }

    public void run() {

        for (int i = 2; i <= limit; i += 2) {

            System.out.println("Even: " + i);

            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class OddThread extends Thread {

    int limit;

    OddThread(int limit) {
        this.limit = limit;
    }

    public void run() {

        for (int i = 1; i <= limit; i += 2) {

            System.out.println("Odd: " + i);

            try {
                Thread.sleep(500);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class MultiThread {

    public static void main(String[] args) {

        int limit = 20;

        EvenThread t1 = new EvenThread(limit);
        OddThread t2 = new OddThread(limit);

        t1.start();
        t2.start();
    }
}