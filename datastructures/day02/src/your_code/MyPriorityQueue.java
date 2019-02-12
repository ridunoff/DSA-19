package your_code;

import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {

    private LinkedList<Integer> ll;

    public MyPriorityQueue() {
        ll = new LinkedList<Integer>();
    }

    public void enqueue(int item) { //O(1)
        ll.addFirst(item);
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() { //O(N^2) If I used an array, it would be O(N)
        int max = 0; //Stores the value of the max element
        int maxIndex = 0; //Stores the index of the max element

        if(ll.isEmpty()) return -1; //If the list is empty, return -1

        max = ll.get(0); //Save the max value as the first element

        if(ll.size() == 1)return ll.remove(0); //If the length of the queue is 1, remove and return the only element
        else{
            for(int i = 1; i<=ll.size()-1;i++){ //Cycle though all of the elements to find the max element to remove
                if(max <= ll.get(i)){
                    max = ll.get(i);
                    maxIndex = i;
                }
            }
            return ll.remove(maxIndex); //Remove and return the largest element
        }
    }

}