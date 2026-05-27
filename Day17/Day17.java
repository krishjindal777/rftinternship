import java.util.Scanner;

public class Day17{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Task Scheduler!");
        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter task name: ");
            String taskName = sc.nextLine();

            System.out.print("Enter delay in seconds: ");
            int delay = sc.nextInt();
            sc.nextLine(); 

           
            Thread taskThread = new Thread(() -> {
                try {
                    Thread.sleep(delay * 1000); 
                    System.out.println("Task \"" + taskName + "\" executed after " + delay + " seconds.");
                } catch (InterruptedException e) {
                    System.out.println("Task \"" + taskName + "\" was interrupted.");
                }
            });

            taskThread.start();
        }

        sc.close();
    }
}
