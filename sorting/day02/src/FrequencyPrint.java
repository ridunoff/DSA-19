import java.util.HashMap;
import java.util.Stack;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO
        String output = "";
        String[] words = s.split(" ");

        Stack<String> stack = new Stack<>();

        if(s.length() == 0) return null;

        //key: word hashed
        //value: string appended

        HashMap<String, Integer> frequency = new HashMap<>();
        HashMap<String, String> printFrequency = new HashMap<>();

        //O(N) time
        for(String word:words){
            if(!frequency.containsKey(word)){
                frequency.put(word, 1);
                printFrequency.put(word, word + " ");
            }
            else{
                frequency.put(word, frequency.get(word)+1);
                printFrequency.put(word, printFrequency.get(word)+word+ " ");
            }
        }



        //O(N^2)
        for(int i=1;i<words.length; i++) {
            for (HashMap.Entry<String, Integer> entry : frequency.entrySet()) {
                if (entry.getValue() == i) {
                    output = output + printFrequency.get(entry.getKey());
                }
            }
        }


        return output.substring(0,output.length()-1);
    }

}
