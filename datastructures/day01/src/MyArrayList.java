public class MyArrayList {
    private Cow[] elems;                    //A list of cows present
    private int size;                       //Number of cows

    // TODO: Runtime: O(1)
    public MyArrayList() {
        this.elems = new Cow[10];           //Creates a cow array of length 10
        this.size = 0;                      //There are no cows to start in the array
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        this.elems = new Cow[capacity];     //Creates a cow array of the capacity length
        this.size = 0;                      //There are no cows to start in the array
    }

    // TODO: Runtime: O(1)
    public void add(Cow c) {
        if(size >= elems.length) {
            Cow[] temp = new Cow[size*2];  // Makes a larger array
            System.arraycopy(elems, 0, temp,0,size);
            temp[size] = c;                 //A new cow is added to the first open spot of the array
            elems = temp;                   //Re-assign elems to the longer temp array
        }
        else{
            elems[size] = c;                //A new cow is added to the first open spot of the array
        }
        size++;                             //Number of cows in increased by 1
    }

    // TODO: Runtime: O(1)
    public int size() {
        return size;                        //Number of cows present
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        if(elems[index]==null){
            throw new IndexOutOfBoundsException(); //Throws exception if there is not a cow at that index
        }
        return elems[index];                //Returns cow at index
    }

    // TODO: Runtime: O(n)
    public Cow remove(int index) {
        if(elems[index]==null||size==0){
            throw new IndexOutOfBoundsException(); //Throws exception if there is not a cow at that index
        }

        Cow runnawayCow = elems[index];     //Saves the cow that wandered off

        if(size==1){
            elems = new Cow[10];
            return runnawayCow;             //Creates a new empty array of length 10 if there are no cows
        }


        for(int i=index;i<size-1;i++){
            elems[i] = elems[i+1];          //Scooch the cows over one to the left
        }
        elems[size-1] = null;               //clear the final cow from the array

        if(elems.length/4>=size){           //Resizes array if it is less than 25% full
            Cow[] temp = new Cow[elems.length/2]; // Makes a shorter array
            System.arraycopy(elems,0,temp,0,size);
            elems = temp;
        }

        size--;
        return runnawayCow;
    }

    // TODO: Runtime: O(n)
    public void add(int index, Cow c) {
        Cow[] temp = new Cow[size*2];      // Makes a larger array
        System.arraycopy(elems, 0, temp,0,size);
        if(index >= size+1){
            throw new IndexOutOfBoundsException(); //Throws an error if the index is not in the array or at the end
        }
        else {
            for(int i=0; i<index;i++){
                temp[i]= elems[i];
            }
            temp[index] = c;                //Inserts the new cow
            for(int j=index+1; j<=elems.length-1;j++){
                temp[j]= elems[j-1];        //Scooches the rest of the cows over
            }

        }
        elems = temp;
        size++;
    }
}