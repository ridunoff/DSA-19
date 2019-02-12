package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node newNode = new Node(c); //Create a new list node with the chicken to be added
        if(size == 0) {
            head = newNode; //If the list is empty, add just the new chicken
            tail = newNode;
        }
        else {
        newNode.prev = tail;

        tail.next = newNode;
        tail = newNode;

        }

        size++; //Add one to the total size
    }

    public void addFirst(Chicken c) {
        Node newNode = new Node(c);
        if(size == 0) {
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;

    }

    public Chicken get(int index) {
        if(size == 0) return null;
        if(index == 0) return head.val;
        Node temp = head.next;
        int i = 1;
        while(temp.next!=null && index>=i){
            if(i==index){
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        return null;
    }

    public Chicken remove(int index) {
        if(size == 0) return null;
        if(index == 0 && size == 1) {
            size--;
            return head.val;
        }
        Node temp = head.next;
        Node saveThis = null;
        size--;
        int i = 1;
        while(temp.next!=null && i<=index){
            if(i==index) {
                saveThis = temp.prev;
                saveThis.next = temp.next;
                Node andThis = temp.next;
                andThis.prev = saveThis;
                return temp.val;
            }
            temp = temp.next;
            i++;
        }
        if(temp.next == null && i == index){
            temp.prev = tail;
            return temp.val;
        }
        return null;
    }

    public Chicken removeFirst() {
        if(size==0)return null;
        if(size==1){
            size--;
            return head.val;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.val;
    }

    public Chicken removeLast() {
        if(size==0)return null;
        if(size==1){
            size--;
            return head.val;
        }
        Node temp = tail;
        tail = tail.prev;
        size--;
        return temp.val;
    }
}