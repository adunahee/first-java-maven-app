package firstquickstart.app.classes;

// used to run poop task after delay
import java.util.concurrent.*;

public class Baby{
    String name;
    int age;
    double weight;
    int poops = 0;
    boolean isFemale;

    // static applies to fields and methods and means they are non unique for each
    // instance,
    // eg you could have a static counter for a class that increments every time the
    // constructor is called
    static int babiesMade = 0;

    // constructor, defaults to CLASSNAME (args){}
    Baby(String myName, int myAge, double myWeight, boolean femaleCheck){
        name = myName;
        age = myAge; 
        weight = myWeight;
        isFemale = femaleCheck;
        babiesMade = babiesMade++;
    }

  
    public static void main(String[] args){

    }
    // static method example
    // however this does not make sense as a static method because it refers to the object
    // static methods are best used when a methods functionality has value without the rest of the object its a part of
    // for this reason static methods cannot reference non-static methods because non-static methods require the object
    static void cry(Baby theBaby){
        System.out.println(theBaby.name + " has started crying.");
    }
    void sayHi(){
        System.out.println("Hi my name is " + name + ".");
    }
    void eat(double foodWeight){
        // add to baby weight a portion of food consumed
        weight = weight + (.1 * foodWeight);
        poop();
    }

    void poop(){
        // creates instance of scheduler task from imported utility concurrent
        ScheduledExecutorService metabolizeFood = Executors.newSingleThreadScheduledExecutor();
        // creates runnable of task to be run after delay
        Runnable excreteFoodWaste = new Runnable() {
            public void run(){
                poops = poops + 1;
                System.out.println(name + " pooped! That's the " + poops + "time.");
            }
        };
        // delay time, unit of time specified in scheduler args
        int digestionTime = 5;
        metabolizeFood.schedule(excreteFoodWaste, digestionTime, TimeUnit.SECONDS);
        metabolizeFood.shutdown();
    }
}

// Baby karen = new Baby("Karen", 1, 12.2, true);
// karen.eat(1);
