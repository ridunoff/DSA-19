import java.util.HashMap;

public class LongestIncreasingSubsequence {

    // Runtime: O(n^2)
    // Space: O(n)


    public static int LIS(int[] A) {
        // TODO

        if(A.length==0) return 0;

        int[] count = new int[A.length];

        for(int i=1; i<A.length; i++){
            for(int j=0; j<i; j++){
                //System.out.println(A[j]);
                if(A[j]<A[i] && count[i]<count[j]+1){
                    count[i]++;

                }
            }
        }


        int max = count[0];

        for(int i=1; i<A.length; i++){
            System.out.println(count[i]);
            if(count[i]>max){
                max = count[i];
            }
        }

        return max+1;

    }


}