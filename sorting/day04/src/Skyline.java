import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO
        //if(B.length <= 1) return B;
        //output.add(new Point(B[i+1].l, B[i+1].h));
        Building[] b = new Building[B.length/2];
        Building[] a = new Building[B.length - (B.length/2)];

        int aInd = 0;
        int bInd = 0;

        for(int i=0;i<B.length; i++){
            if(i%2==0)a[aInd++] = B[i];
            else b[bInd++] = B[i];
        }

        return merge(a,b);
    }


    //I never get the points for the end of the building, just the start


    public static List<Point> merge(Building[] A, Building[] B){

        // for the current tower
        // if the left corner position is lower than the leftmost of the next tower, add the point
        // if the right corner height is taller than the next tower, add the point
        // and increment the tower by one

        // now check the same but with the other set of towers
        // if the left corner height is greater than the other tower, add the point
        // if the right corner height is greater than the other tower height, add the point
        // increment the tower by one
        
        // if the left corner position is less than the next corner, add the position
        // if the right corner is lower than the left most corner of the other tower



        //For each point, check if there is a corner there from A or B
        //then check if there is a taller building occupying that space



        //Building[] output = new Building[A.length+B.length];

        //if(A.length==0)return B;
        //if(B.length==0)return A;

        List<Point> output = new ArrayList<Point>();

        int indA = 0;
        int indB = 0;


        while(indA<A.length && indB<B.length){ //While there are buildings in both arrays

            //if A overlaps with B, add the taller building
            if (A[indA].r > B[indB].l && A[indA].r < B[indB].r) {
                if (A[indA].h > B[indB].h) {
                    output.add(new Point(A[indA].l, A[indA].h));
                    indA++;
                } else {
                    output.add(new Point(B[indB].l, B[indB].h));
                    indB++;
                }
            }
            //if B overlaps with A, add the taller building
            else if (B[indB].r > A[indA].l && B[indB].r < A[indA].r) {
                if (A[indA].h > B[indB].h) {
                    output.add(new Point(A[indA].l, A[indA].h));
                    indA++;
                } else {
                    output.add(new Point(B[indB].l, B[indB].h));
                    indB++;
                }
            }
            //if A doesn't overlap with B, check the next tower in A
            else if(A[indA].r<=B[indB].l){
                indA++;
            }
            //if B doesn't overlap with A, check the next tower in B
            else if(B[indB].r<=A[indA].l){
                indB++;
            }

        }
        while(indA<A.length){ //add the final tower in a if it is there
            output.add(new Point(A[indA].l, A[indA].h));
            indA++;
        }

        while(indB<B.length){ //add the final tower to b is it is there
            output.add(new Point(B[indB].l, B[indB].h));
            indB++;
        }

        return output;
    }
}
