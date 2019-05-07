package firstquickstart.app;

//java util for maps, stores key:value, look up key returns value, Hash are unorderd, Tree or lowest to highest
import java.util.HashMap;
// interface
import java.util.Map;

class EmailList{
    public static void main(){
        HashMap<String, String> emails = new HashMap<String, String>();
        emails.put("Anthony", "anthony@gmail.com");
        emails.put("Brenda", "brenda@gmail.com");
        emails.put("Tony", "tony@gmail.com");
        emails.put("Breana", "breana@gmail.com");
        emails.put("Colleen", "colleen@gmail.com");

        System.out.println(emails.size());
        emails.remove("Colleen");
        // loops through emails hashmap key set and uses that to print key name 
        // and get emails value from hashmap
        for(String nameKey : emails.keySet()){
            System.out.println(nameKey +"'s email address is " + emails.get(nameKey) + ".");
        }
        // similar to above but only loops over emails hashmap values
        for(String emailValue : emails.values()){
            System.out.println(emailValue);
        }
        // similar to first loops but groups pairs together 
        for(Map.Entry<String, String> pairs: emails.entrySet()){
            // prints like name=example@email.com
            System.out.println(pairs);
        }
        

    }
}