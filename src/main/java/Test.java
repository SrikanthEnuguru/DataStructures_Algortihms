import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {

        String input = "Test Paper Today Time Test Test Test Test test    paper";
        counts(input);
    }
    public static Map<String, Integer> counts(String input){

        Map<String, Integer> countsMap = new ConcurrentHashMap<>();
        // base conditions
        if(input==null || input.trim().length()==0) {
            return countsMap;
        }

        String[] arr = input.split(" "); // doesn't support multiple spaces, need a proper regex

        for(String str: arr){
            countsMap.put(str.trim().toLowerCase(), countsMap.getOrDefault(str.trim().toLowerCase(),0)+1);
        }

        for(Map.Entry<String, Integer> entry: countsMap.entrySet()){
            System.out.println(entry.getKey() + " -> "+ entry.getValue());
        }

        return countsMap;
    }

}
