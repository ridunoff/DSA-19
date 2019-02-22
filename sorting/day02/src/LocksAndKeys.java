import java.lang.reflect.Array;
import java.util.concurrent.ThreadLocalRandom;

public class LocksAndKeys {

    private static void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }



    public static void quickSort(char[] lock, char[] key, int lo, int hi) {
        if (lo < hi) {
            int p = partition(lock, lo, lo, hi);
            int p2 = partition(key,p,lo,hi);
            //partition(key,p,lo,hi);
            //partition(lock,p2,lo,hi);
            quickSort(lock,key,lo,p-1);
            quickSort(lock,key,p+1,hi);

            quickSort(lock,key,lo,p2-1);
            quickSort(lock,key,p2+1,hi);
        }
    }

    public static int partition(char[] array, int pivot, int lo, int hi) {
        int rightMark = hi;

        while(pivot!=rightMark){
            while (array[pivot] <= array[rightMark] && pivot!=rightMark) { //if the element is smaller than the pivot, ignore it
                rightMark--;
            }
            if (rightMark!=pivot) {
                swap(array,rightMark, pivot+1);
                swap(array,pivot+1, pivot);
                pivot++;
            }
        }
        return pivot;

    }

    static char[][] locksAndKeys(char[] locks, char[] keys) {
        // TODO: Return a 2d char array, where result[0] is the sorted locks, and result[1] is the sorted keys
        char[][] result = new char[2][];
        System.out.println(java.util.Arrays.toString(locks));
        System.out.println(java.util.Arrays.toString(keys));
        quickSort(locks, keys,0,locks.length-1);
        System.out.println(java.util.Arrays.toString(locks));
        System.out.println(java.util.Arrays.toString(keys));
        result[0] = locks;
        result[1] = keys;
         return result;
    }
}




