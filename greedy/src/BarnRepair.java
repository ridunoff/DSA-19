import java.util.ArrayList;

import static java.util.Arrays.sort;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        // TODO
        sort(occupied);

        if(M==1){
            return occupied[occupied.length-1]-occupied[0]+1;
        }

        int[] barn = new int[occupied[occupied.length-1]+1];

        for(int i=0; i<occupied.length; i++) {
            barn[occupied[i]] = occupied[i];
        }

        ArrayList<Integer> printBarn = new ArrayList<Integer>();

        for(int i=0; i<barn.length; i++){
            printBarn.add(barn[i]);
        }
        System.out.println(printBarn.toString());
        System.out.println(M);


        for(int j=0; j<M;j++){ //Deletes the largest gap, M times
            int largestGap = 0;
            int gapSize = 0;
            int gapStart = 0;
            int largestGapStartIndex = 0;

        for(int i=0; i<barn.length; i++){
            if(barn[i]==0){
                gapStart = i;
                i++;
                gapSize = 1;
            }
            while(barn[i]==0){
                gapSize += 1;
                i++;
            }
            if(gapSize > largestGap){
                largestGap = gapSize;
                largestGapStartIndex = gapStart;

            }
        }


        int[] firstHalf = new int[largestGapStartIndex];
        System.arraycopy(barn,0,firstHalf,0, largestGapStartIndex);


        int[] secondHalf = new int[barn.length - largestGapStartIndex-largestGap];
        System.arraycopy(barn,largestGapStartIndex+largestGap,secondHalf,0, barn.length - largestGapStartIndex-largestGap);


        barn = new int[firstHalf.length+secondHalf.length];

        for(int i=0; i<firstHalf.length; i++){
            barn[i]=firstHalf[i];
        }

        for(int i=0; i<secondHalf.length; i++){
            barn[i+firstHalf.length]=secondHalf[i];
        }

        }


        return barn.length;
    }
}