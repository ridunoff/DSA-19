
public class InsertionSort extends SortAlgorithm {
    /**
     * Use the insertion sort algorithm to sort the array
     *
     * TODO
     * Best-case runtime: O(N)
     * Worst-case runtime: O(N^2)
     * Average-case runtime: O(
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        int place = 0;
        if(array.length <= 1) return array;

        for(int i=1;i<array.length;i++){
            place = i;
            while(place>0 && array[place-1]>array[place]){
                swap(array, place-1,place);
                place--;
            }
        }
        return array;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
