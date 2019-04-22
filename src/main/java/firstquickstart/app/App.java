package firstquickstart.app;

// using java utility to generate random numbers
import java.util.Random;
// utility for formatting number from NumberFormat
import java.text.DecimalFormat;

public class App {
    // main is called automatically
    // fxnType fxnName (type argName, type argName, type argName){
    //  statements like logic, maths, and calling other functions
    // }
    // fxnType can be void for no return or type for return type
    public static void main(String[] args) {
        // Hello World and Pie Fun
        System.out.println("Hello World!");
        pie();
        // function called with number of skydivers and their initial jump height
        gravityCalculator(4, 1000);
        operatorFun();
        System.out.println(boomerang(2));
        System.out.println("Expect 320");
        fooCorpPay(40, 8);
        System.out.println("Expect 200");
        fooCorpPay(20, 10);
        System.out.println("Expect 700");
        fooCorpPay(60, 10);
        System.out.println("Expect 700");
        fooCorpPay(70, 10);
    }

    public static void pie() {
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

    }

    // Gravity Calculator
    public static void gravityCalculator(Integer arg1, Integer arg2) {
        Random rand;
        Integer origin;
        Integer velocity;
        Integer time;
        Integer skydiverCount = arg1;
        int jumpHeight = arg2;
        for (Integer i = 0; i < skydiverCount; i += 1) {
            // randomize skydiver before jump
            rand = new Random();
            origin = rand.nextInt(jumpHeight) + 300;
            velocity = rand.nextInt(10) + 2;
            time = rand.nextInt(20) + 5;
            System.out.println("The skydiver begins at " + origin + " with a speed of " + velocity);

            // final key work similar to const for vars
            final double accGravity = -9.8;
            System.out.println("Where is the skydiver located after " + time + " seconds?");

            // x(t) = 0.5 × at2 + vi*t + xi
            Double skydiverPosition = 0.5 * accGravity * Math.pow(time, 2) + 5 * time + origin;

            // format position before displaying
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(skydiverPosition) + " meters off the ground");
            final String ANSI_RED = "\u001B[31m";
            final String ANSI_RESET = "\u001B[0m";
            final String ANSI_GREEN = "\u001B[32m";
            if (skydiverPosition < 0) {
                System.out.println(ANSI_RED + "Oh... yep he's dead." + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + "Better deploy the shute!" + ANSI_RESET);
            }
            System.out.println("\n\n");
        }
    }

    public static void operatorFun() {
        // division operator is weird with integers and doubles
        System.out.println("5 divided by 2 when integers is actually 2");
        System.out.println(5 / 2);
        System.out.println(4 / 2);
        System.out.println(5.0 / 2.5);
        System.out.println("what happens when 5/2.5");
        System.out.println(5 / 2.5);

        // Conversion by casting, type casting needs to happen when some maths involved
        // or java may default to unexpected value/error
        // double fraction = 2/3;
        // fraction = 0
        double fractionTwo = (double) 2 / 3;
        System.out.println(fractionTwo);
    }

    public static int boomerang(int arg) {
        return arg;
    }

    public static void fooCorpPay(double hours, double wage){
        double regularTime = hours;
        double overtime = 0;
        if(hours < 40) {
            regularTime = hours;
        }else if(hours > 40){
            regularTime = 40;
            overtime = hours - 40;
            if(overtime > 20){
                overtime = 20;
            }
        }
        double earnings = regularTime * wage + (overtime * wage * 1.5);
        System.out.println(earnings);
    }
}