package firstquickstart.app;

public class App 
{
    public static void main( String[] args )
    {
        // Hello World and Pie Fun
        System.out.println( "Hello World!" );
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
        System.out.println("Where is the skydiver located?");
        // x(t) = 0.5 × at2 + vi*t + xi
        Integer origin = 500;
        Double skydiverPosition = 0.5 * -9.8*Math.pow(10, 2) + 5*10 + origin;
        
        System.out.println(Double.toString(skydiverPosition) + "Meters off the ground");
        if(skydiverPosition < 0){
            System.out.println("Oh... yep he's dead.");
        } else {
            System.out.println("Better deploy the shute!");
        }
    }
}