import java.util.Scanner;

// Abstract base class
abstract class Device {
    String name;
    boolean isOn;

    Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    abstract void turnOn();
    abstract void turnOff();
    abstract void displayStatus();
    abstract void extraFeature(Scanner sc);
}

// Light class
class Light extends Device {
    Light(String name) {
        super(name);
    }

    @Override
    void turnOn() {
        isOn = true;
        System.out.println(name + " Light is ON");
    }

    @Override
    void turnOff() {
        isOn = false;
        System.out.println(name + " Light is OFF");
    }

    @Override
    void displayStatus() {
        System.out.println(name + " Light status: " + (isOn ? "ON" : "OFF"));
    }

    @Override
    void extraFeature(Scanner sc) {
        System.out.println("No extra feature for Light.");
    }
}

// Fan class
class Fan extends Device {
    int speed;

    Fan(String name) {
        super(name);
        this.speed = 0;
    }

    @Override
    void turnOn() {
        isOn = true;
        speed = 1;
        System.out.println(name + " Fan is ON at speed " + speed);
    }

    @Override
    void turnOff() {
        isOn = false;
        speed = 0;
        System.out.println(name + " Fan is OFF");
    }

    @Override
    void displayStatus() {
        if (isOn) {
            System.out.println(name + " Fan status: ON, Speed = " + speed);
        } else {
            System.out.println(name + " Fan status: OFF");
        }
    }

    @Override
    void extraFeature(Scanner sc) {
        if (isOn) {
            System.out.print("Enter speed: ");
            int s = sc.nextInt();
            speed = s;
            System.out.println(name + " Fan speed set to " + s);
        } else {
            System.out.println("Turn on the fan first!");
        }
    }
}

// AC class
class AC extends Device {
    int temperature;

    AC(String name) {
        super(name);
        this.temperature = 24;
    }

    @Override
    void turnOn() {
        isOn = true;
        System.out.println(name + " AC is ON at " + temperature + "°C");
    }

    @Override
    void turnOff() {
        isOn = false;
        System.out.println(name + " AC is OFF");
    }

    @Override
    void displayStatus() {
        if (isOn) {
            System.out.println(name + " AC status: ON, Temperature = " + temperature + "°C");
        } else {
            System.out.println(name + " AC status: OFF");
        }
    }

    @Override
    void extraFeature(Scanner sc) {
        if (isOn) {
            System.out.print("Enter temperature: ");
            int t = sc.nextInt();
            temperature = t;
            System.out.println(name + " AC temperature set to " + t + "°C");
        } else {
            System.out.println("Turn on the AC first!");
        }
    }
}

// Main controller
public class Day4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Device[] devices = {
            new Light("Living Room"),
            new Fan("Ceiling"),
            new AC("Bedroom")
        };

        while (true) {
            System.out.println("\nChoose device: 1-Light 2-Fan 3-AC 0-Exit");
            int d = sc.nextInt();

            if (d == 0) {
                System.out.println("Exiting Smart Home Controller...");
                break;
            }

            if (d < 1 || d > 3) {
                System.out.println("Invalid choice!");
                continue;
            }

            Device device = devices[d - 1];

            System.out.println("Action: 1-ON 2-OFF 3-Status 4-Extra");
            int a = sc.nextInt();

            switch (a) {
                case 1:
                    device.turnOn();
                    break;
                case 2:
                    device.turnOff();
                    break;
                case 3:
                    device.displayStatus();
                    break;
                case 4:
                    device.extraFeature(sc);
                    break;
                default:
                    System.out.println("Invalid action!");
            }
        }

        sc.close();
    }
}
