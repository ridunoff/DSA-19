import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        int counter = k;
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> l = new LinkedList<>();

        for(int i=0;i<A.length;i++){
            while(!(stack.isEmpty()) && stack.peek()>A[i]&&counter>0){
                stack.pop();
                counter--;
            }
            if (stack.size() < A.length - k){
                stack.push(A[i]);
            }
        }

        Stack<Integer> back = new Stack<Integer>();

        for (int i = 0; i < A.length-k; i++){
            back.push(stack.pop());
        }

        for (int i = 0; i < A.length-k; i++) {
            l.add(back.pop());
        }
        return l;
    }

    public static boolean isPalindrome(Node n) {
        List<Integer> reversedList = new LinkedList<Integer>();
        int count = 0;
        Node slow = n;
        Node fast = n;

        if(n == null) return true;

        while( fast !=null && fast.next!=null){ //Find the middle node
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        Node current = slow.next;
        Node prev = slow;

        Node next;

        while (current != null) {
            next = current.next; //Save the next position
            current.next = prev; // Reverse current node's pointer

            // Move pointers one position ahead.
            prev = current;
            current = next;
        }
        Node backwords = prev;

        for(int i=0; i<count;i++){
            if(n.val!=backwords.val){
                return false;
            }
            n = n.next;
            backwords = backwords.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        char[] finalString = new char[s.length()];
        int count = 0;
        Character operator;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {

            }
            else if (chars[i] == ')') {
                operator = stack.pop();
                finalString[count]=operator;
                finalString[count+1] = ' ';
                count+=2;

            }
            else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '/' || chars[i] == '*') {
                stack.push(chars[i]);
            } else {
                finalString[count] = chars[i];
                finalString[count+1] = ' ';
                count+=2;
            }
            i++;
        }
        s = new String(finalString);
        s = s.substring(0,count-1);

        return s;
    }


}
