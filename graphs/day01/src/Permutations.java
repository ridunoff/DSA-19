import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        List<Integer> unused = A;
        permutationsHelper(current,unused,permutations);
        return permutations;
    }

    public static void permutationsHelper(List<Integer> current, List<Integer> unused, List<List<Integer>> permutationsList){


        //base case
        if(unused.size() == 0) permutationsList.add(current);
        else {
            //iterate through each character
            for (Integer num : unused) {
                List<Integer> currentTemp = new ArrayList<>(current);
                List<Integer> unusedTemp = new ArrayList<>(unused);
                currentTemp.add(num);
                unusedTemp.remove(num);
                permutationsHelper(currentTemp, unusedTemp, permutationsList);
                //currentTemp.remove(num);
                //unusedTemp.add(num);
            }
        }
    }

}
