public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(n+k)
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO
        int place=0;
        int element;

        if(A != null){
            int k = max(A);
            int[] counts = new int[k+1];
            for(int i=0; i<A.length;i++) {
                element = A[i];
                counts[element]+=1;
            }
            for(int j=0; j<k+1;j++) {
                while (counts[j] > 0) {
                    A[place] = j;
                    counts[j]--;
                    place++;
                    }
                }
            }

    }


    static int max(int[] A){
        int maxInt = A[0];
        for(int i=0; i<A.length; i++){
            if(maxInt<A[i]){
                maxInt = A[i];
            }
        }
        return maxInt;
    }
}
