package firstquickstart.app;

// using java utility to generate random numbers
import java.util.Random;

public class App {
    public static void main(String[] args) {
        // Hello World and Pie Fun
        System.out.println("Hello World!");
        double pie = 3.14;
        System.out.println("Who wants pie baby?! \n" + Double.toString(pie));
        // Birthday Check
        Integer birthday = 5;
        Integer birthmonth = 7;
        String name = "Anthony";
        boolean birthdayCheck = false;
        System.out.println("Greetings" + name + "\n it looks like your birthday is on" + Integer.toString(birthmonth)
                + "/" + Integer.toString(birthday));
        String greeting;
        if (birthdayCheck) {
            greeting = "Happy Birthday!";
        } else {
            greeting = "Its not your birthday yet!";
        }
        System.out.println(greeting);
        // Gravity Calculator
        Random rand;
        Integer origin;
        Integer velocity;
        Integer time;
        for (Integer i = 0; i < 3; i += 1) {
            rand = new Random();
            origin = rand.nextInt(1000) + 300;
            velocity = rand.nextInt(10) + 2;
            time = rand.nextInt(20) + 5;
            System.out.println("The skydiver begins at " + origin + " with a speed of " + velocity);
            // final key work similar to const for vars
            final double accGravity = -9.8;
            System.out.println("Where is the skydiver located after " + time + " seconds?");
            // x(t) = 0.5 × at2 + vi*t + xi

            Double skydiverPosition = 0.5 * accGravity * Math.pow(time, 2) + 5 * time + origin;
            System.out.println(Double.toString(skydiverPosition) + " meters off the ground \n");
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_GREEN = "\u001B[32m";
            if (skydiverPosition < 0) {
                System.out.println(ANSI_RED + "Oh... yep he's dead." + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + "Better deploy the shute!" + ANSI_RESET);
            }
        }
    }
}