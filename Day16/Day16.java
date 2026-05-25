

class EvenPrinter extends Thread {
    private int limit;

    EvenPrinter(int limit) {
        this.limit = limit;
    }

    public void run() {
        for (int i = 2; i <= limit; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class OddPrinter extends Thread {
    private int limit;

    OddPrinter(int limit) {
        this.limit = limit;
    }

    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Day16 {
    public static void main(String[] args) {
        int limit = 20; 

        EvenPrinter evenThread = new EvenPrinter(limit);
        OddPrinter oddThread = new OddPrinter(limit);

        evenThread.start();
        oddThread.start();
    }
}
