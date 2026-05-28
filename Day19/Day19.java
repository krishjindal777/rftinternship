import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

class ChatUser extends Thread {
    private String userName;
    private Random random;

    public ChatUser(String name) {
        this.userName = name;
        this.random = new Random();
    }

    public void run() {
        for (int i = 0; i < 5; i++) { 
            try {
                int delay = 1000 + random.nextInt(2000);
                Thread.sleep(delay);

                String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

                System.out.println(timeStamp + " | " + userName + ": Hello, this is message " + (i+1));

            } catch (InterruptedException e) {
                System.out.println(userName + " was interrupted.");
            }
        }
    }
}

public class Day19 {
    public static void main(String[] args) {
        
        ChatUser user1 = new ChatUser("User1");
        ChatUser user2 = new ChatUser("User2");
        ChatUser user3 = new ChatUser("User3");

      
        user1.start();
        user2.start();
        user3.start();
    }
}
