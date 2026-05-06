import java.util.Scanner;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int sub(int a, int b) {
        return a - b;
    }

    int mul(int a, int b) {
        return a * b;
    }

    int mod(int a, int b) {
        return a % b;
    }

    int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}

class CommandProcessor {

    Calculator calc = new Calculator();

    void process(String input) {
        input = input.toUpperCase();
        Scanner sc = new Scanner(input);
       

        String command = sc.next();   // reads ADD / SUB / MUL etc
        int a = sc.nextInt();         // reads first number
        int b = sc.nextInt();         // reads second number

        switch (command) {

            case "ADD":
                System.out.println("Result = " + calc.add(a, b));
                break;

            case "SUB":
                System.out.println("Result = " + calc.sub(a, b));
                break;

            case "MUL":
                System.out.println("Result = " + calc.mul(a, b));
                break;

            case "MOD":
                System.out.println("Result = " + calc.mod(a, b));
                break;

            case "POW":
                System.out.println("Result = " + calc.pow(a, b));
                break;

            default:
                System.out.println("Invalid Command!");
        }
    }
}

public class Day2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CommandProcessor cp = new CommandProcessor();

        System.out.println("Enter command (ex: ADD 10 20): ");
        String input = sc.nextLine();

        cp.process(input);
    }
}