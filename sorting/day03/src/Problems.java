import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO
        for(int i=0;i<A.length;i++){
            A[i] += 100;
        }
        RadixSort.radixSort(A,10); //since the function is static (it belongs to the class)
        for(int i=0;i<A.length;i++){
            A[i] -= 100;
        }
    }


    //Pasted Radix Sort

    private static int getNthDigit(int number, int base, int n) {
        return number / ((int) Math.pow(base, n)) % base;
    }


    /**
     * Use counting sort to sort the integer array according to a digit
     *
     * @param b The base used in radix sort
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByDigit(int[] A, int b, int n) {
        LinkedList<Integer>[] L = new LinkedList[b];
        for (int i = 0; i < b; i++)
            L[i] = new LinkedList<>();
        for (int i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            L[getNthDigit(i,b,n)].add(i);

        }
        int j = 0; // index in A to place numbers
        for (LinkedList<Integer> list : L) {
            // TODO: Put all numbers in the linked lists into A
            while(!list.isEmpty()){
                A[j] = list.remove();
                j++;
            }

        }
    }

    /**
     * Runtime: O(n*w) or O(n+b * log(b) K) TODO: Express your runtime in terms of n, b, and w
     *
     * n: length of array
     * w: word length of integers A in base b (equal to log base b of k (log_b k) )
     *
     * @param b The base to use for radix sort
     */
    static void radixSort(int[] A, int b) {
        // Calculate the upper-bound for numbers in A
        int k = A[0] + 1;
        for (int i = 1; i < A.length; i++)
            k = (A[i] + 1 > k) ? A[i] + 1 : k;
        int w = (int) Math.ceil(Math.log(k) / Math.log(b)); // w = log base b of k, word length of numbers
        // TODO: Perform radix sort
        for(int j=0; j<w; j++){
            countingSortByDigit(A,b,j);
        }

    }





    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // TODO

        LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();

        for (String i : A) {
            L[getNthCharacter(i,n)].add(i);
        }

        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            while(!list.isEmpty()){
                A[j] = list.remove();
                j++;
            }
        }
    }




    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for(int i=0; i<stringLength; i++){
            countingSortByCharacter(S,i); //Sort the array of strings by each character in the string
        }

    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }


}
