// any class declared in app directory belongs to this package
package firstquickstart.app;

// used to run poop task after delay
import java.util.concurrent.*;

// introduced "access control" to baby class. helps separate implementation from interfacing
public class Baby {
    private String name;
    private int age;
    private double weight;
    private int poops = 0;
    private boolean isFemale;

    // static applies to fields and methods and means they are non unique for each
    // instance,
    // eg you could have a static counter for a class that increments every time the
    // constructor is called
    static int babiesMade = 0;

    // constructor, defaults to CLASSNAME (args){}
    Baby(String myName, int myAge, double myWeight, boolean femaleCheck) {
        name = myName;
        age = myAge;
        weight = myWeight;
        isFemale = femaleCheck;
        babiesMade = babiesMade++;
    }

    // static method example
    // however this does not make sense as a static method because it refers to the
    // object
    // static methods are best used when a methods functionality has value without
    // the rest of the object its a part of
    // for this reason static methods cannot reference non-static methods because
    // non-static methods require the object
    public static void cry(Baby theBaby) {
        System.out.println(theBaby.name + " has started crying.");
    }

    // a getter of sorts, but does not return actual value just displays it
    public void weigh() {
        System.out.println(name + " weighs " + weight + ".");
    }
    // a getter of sorts, but does not return actual value just displays it
    public void sayHi() {
        System.out.println("Hi my name is " + name + ".");
    }
    // a setter that calls a getter before and after setting
    public void eat(double foodWeight) {
        weigh();
        // add to baby weight a portion of food consumed
        weight = weight + (.1 * foodWeight);
        weigh();
        poop();
    }
    // two setters in one for poop count and baby weight, made private so can 
    // only be called after eating, wouldnt want to poop a baby massless
    private void poop() {
        // creates instance of scheduler task from imported utility concurrent
        ScheduledExecutorService metabolizeFood = Executors.newSingleThreadScheduledExecutor();
        // creates runnable of task to be run after delay
        Runnable excreteFoodWaste = new Runnable() {
            public void run() {
                poops = poops + 1;
                System.out.println(name + " pooped! That's the " + poops + "time.");
                weight -= .1;
                weigh();
            }
        };
        // delay time, unit of time specified in scheduler args
        int digestionTime = 5;
        metabolizeFood.schedule(excreteFoodWaste, digestionTime, TimeUnit.SECONDS);
        metabolizeFood.shutdown();
    }

    public void birthday(int newAge){
        age = newAge;
        System.out.println("Happy Birthday! " + name + " just turned " + age + ".");
    }
    public static void ageCheck(Baby theBaby){
        System.out.println(theBaby.name + " is " + theBaby.age + " years old.");
    }
    public static void main(){
        Baby karen = new Baby("Karen", 1, 12.2, true);
        karen.eat(1);
        karen.birthday(2);
        Baby.ageCheck(karen);
    }
}


