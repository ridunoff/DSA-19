
public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(nlgn)
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(nlgn)
     *
     * Space-complexity: O(N^2)
     */
    @Override
    public int[] sort(int[] array) {
        // TODO

        if(array.length <= 1) return array;

        int len = array.length;

        int[] left = new int[len - (len/2)];
        int[] right = new int[len/2];

        for(int i=0;i<array.length/2;i++){
            left[i] = array[i];
            right[i] = array[len-i-1];
        }
        if(len%2==1) left[array.length/2] = array[array.length/2];

        int[] sortedLeft = sort(left);
        int[] sortRight = sort(right);

        int[] a = merge(sortedLeft, sortRight);

        return a;
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] arrRight, int[] arrLeft) {
        // TODO

        if(arrRight==null)return arrLeft; //null pointer left
        if(arrLeft==null)return arrRight; //null pointer right

        int arLength = arrRight.length; //length of the right array
        int alLength = arrLeft.length;  //length of the left array

        int[] totalArray = new int[arLength+alLength]; //a new array the length of both arrays added together

        int indLeft = 0;
        int indRight = 0;
        int indMerged = 0;

        while(indRight<arLength&& indLeft < alLength){
            if(arrRight[indRight]>arrLeft[indLeft]) { //The larger number gets added to the totalArray
                totalArray[indMerged++] = arrLeft[indLeft++];
            }
            else{
                totalArray[indMerged++] = arrRight[indRight++];
            }

        }

        while(indLeft < alLength){ //Adds in the rest of the left array
            totalArray[indMerged++]=arrLeft[indLeft++];
        }
        while(indRight < arLength){ //adds in the rest of the right array
            totalArray[indMerged++]=arrRight[indRight++];
        }

        return totalArray;
    }

}
