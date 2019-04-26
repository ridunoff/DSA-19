import java.util.*;

public class DiceRollSum {

    // Runtime: O(n)
    // Space: O(n)
    //static int total=0;
    //static List<Integer> rolls = List.of(1,2,3,4,5,6);
    static HashMap<Integer,Integer> dpMap = new HashMap<Integer, Integer>();


    public static int diceRollSum(int N) {
        // TODO
        //List<Integer> rolls = List.of(1,2,3,4,5,6);

        return diceRollHelper(N, 0);

        }

        public static int diceRollHelper(int N, int sum){

            if(dpMap.containsKey(N)){
                return dpMap.get(N);
            }
            else if(N==0){
                dpMap.put(N,1);
                return 1;
            }
            else if(N<0){
                return 0;
            }
            else{
                for(int j=1;j<=6;j++) {
                    sum += diceRollSum(N - j);

                }
                dpMap.put(N,sum);
            }
            return dpMap.get(N);

        }

}
