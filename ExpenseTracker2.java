import java.lang.reflect.Array;
import java.util.*;

public class ExpenseTracker2 {
    
    public static void main(String[] args) {
        
        List<Integer> userlist = Arrays.asList(100, 102,103,104,102,101);

        Set<Integer> uniqueUser = new HashSet<>();
        
        int duplicate = 0;

        for (int user : userlist) {
            if (!uniqueUser.add(user)) {
                duplicate++;
            }
        }
         
        System.out.println("Unique user " + uniqueUser);
        System.out.println("Total user" + uniqueUser.size());
        System.out.println("Duplicate" + duplicate);



    }
}
