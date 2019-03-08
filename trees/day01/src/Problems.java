import static java.util.Arrays.sort;

public class Problems {

    public static int leastSum(int[] A) {
        //TODO
        sort(A);

        int a = 0;
        int b = 0;
        int place = 1;
        if(A.length == 0) return 0;
        if(A.length == 1) return A[0];

        for(int i=A.length-1; i>0; i-=2){
            a += place * A[i];
            b += place * A[i-1];
            place  = place * 10;
        }

        if(A.length % 2 == 1) a += place * A[0];

        return a+b;
    }
}
