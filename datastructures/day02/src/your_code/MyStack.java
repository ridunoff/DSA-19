package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> savedMaxElement;

    public MyStack() {
        ll = new LinkedList<>();
        savedMaxElement = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        ll.addFirst(e);
        if(savedMaxElement.isEmpty()){
            savedMaxElement.addFirst(e);
        }
        else if(savedMaxElement.get(0)<=e){
            savedMaxElement.addFirst(e);
        }
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        if(pop==savedMaxElement.get(0)) savedMaxElement.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {

        return savedMaxElement.get(0);
    }
}
