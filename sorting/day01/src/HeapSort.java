public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        int idx;                        //the value of the larger child
        if(leftChild(i)<size) {
            idx = leftChild(i);
            if (rightChild(i) < size) {
                if (heap[rightChild(i)] > heap[idx]) {
                    idx = rightChild(i);
                }
            }
            if (heap[i] < heap[idx]) { //Swap if the parent is smaller than the larger child
                swap(i, idx);
                sink(idx); //Keep sinking if the new parent is still smaller
            }
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            // TODO
            sink(i);
        }
    }

    /**
     * Best-case runtime: O(nlgn)
     * Worst-case runtime: O(nlgn)
     * Average-case runtime: O(nlgn)
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
            // TODO
            swap(i,0);
            size--;
            sink(0);
        }
        return heap;
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
