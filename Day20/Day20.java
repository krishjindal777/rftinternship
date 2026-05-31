import java.util.Random;

class RequestHandler extends Thread {
    private int requestId;

    public RequestHandler(int requestId) {
        this.requestId = requestId;
    }

    public void run() {
        Random random = new Random();
        int processingTime = random.nextInt(3000) + 1000;
        System.out.println("Handling Request " + requestId + " | Processing Time: " + processingTime + "ms");
        try {
            Thread.sleep(processingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed Request " + requestId);
    }
}

public class Day20 {
    public static void main(String[] args) {
        int totalRequests = 5;
        for (int i = 1; i <= totalRequests; i++) {
            RequestHandler handler = new RequestHandler(i);
            handler.start();
        }
    }
}
