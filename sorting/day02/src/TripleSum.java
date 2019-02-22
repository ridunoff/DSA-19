import java.util.ArrayList;
import java.util.HashMap;

public class TripleSum {


    static int tripleSum(int[] arr, int sum) {
        // TODO


        //sort(arr);

        HashMap<Integer, ArrayList<Integer[]>> doubles = new HashMap<>();


        //An array of linked lists of int arrays that is twice the length of the sum because we would need to make the
        // negative numbers positive TODO


        int key;
        Integer[] value = {0,1};
        int total = 0;


        //Key: the sum - i - j
        //Value: ArrayList of [i,j]

        for(int i=0;i<arr.length;i++){
            for(int j=i; j<arr.length;j++){
                if (i == j) {
                    continue;
                }
                ArrayList<Integer[]> pairs = new ArrayList<>();
                pairs.clear();

                    if(doubles.containsKey(arr[j] + arr[i])){
                        pairs.addAll(doubles.get(arr[j] + arr[i]));
                        pairs.add(new Integer[]{i,j});
                        doubles.put(arr[j] + arr[i],pairs);
                    }
                    else{
                        pairs.add(new Integer[]{i,j});
                        doubles.put(arr[j] + arr[i],pairs);
                    }
            }
        }


        for(int k=0;k<arr.length;k++){
            if(doubles.containsKey(sum - arr[k])){
                for(Integer[] val:doubles.get(sum - arr[k])){
                    if(val[0]==k || val[1]==k){
                        continue;
                    }
                    total++;
                }
            }
        }


        return total/3;
    }
}
