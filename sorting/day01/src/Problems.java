import java.util.*;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length]; //saves the median of th array
        List<Integer> seen = new ArrayList<>(); //saves the list of the elements, sorted?
        for (int i = 0; i < A.length; i++) { //for each element in the array
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i]) //moves to the next element if it is greater than the prior seen numbers
                j++;
            seen.add(j, A[i]); //add the new number ot the seen list in the place of the prior if it is less or the next spot it if it more
            out[i] = getMedian(seen);
        }
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runningMedian = new double[inputStream.length];
        // TODO

        if(inputStream.length == 0) return runningMedian;

        PriorityQueue<Integer> minPQ = minPQ();
        PriorityQueue<Integer> maxPQ = maxPQ();


        for(int i=0; i<inputStream.length; i++){

            if(i==0) {
                minPQ.offer(inputStream[i]); //adds the new element to the min queue
                runningMedian[i] = minPQ.peek();
                continue;
            }

            if(inputStream[i]<runningMedian[i-1]){
                maxPQ.offer(inputStream[i]);
            }
            else{
                minPQ.offer(inputStream[i]);
            }

            if(minPQ.size()>maxPQ.size()+1){
                maxPQ.offer(minPQ.poll());
            }
            else if(maxPQ.size()>minPQ.size()){
                minPQ.offer(maxPQ.poll());
            }

            if(minPQ.size()==maxPQ.size()){
                //even is (median + (median + 1)) / 2
                runningMedian[i] = (double) (minPQ.peek()+maxPQ.peek())/2; // finds the number in between the highest of the min queue and the smallest of the max queue
            }
            else{
                //odd length/2
                runningMedian[i] = minPQ.peek(); //pulls the top value from the min column
            }
        }
        return runningMedian;
    }

}
