package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO
        if(B.length == 0) return new ArrayList<>();
        if(B.length == 1) {
            List<Point> oneBuilding = new ArrayList<>();
            oneBuilding.add(new Point(B[0].l,B[0].h));
            oneBuilding.add(new Point(B[0].r,0));
            return oneBuilding;
        }


        List<Point> leftside = skyline(Arrays.copyOfRange(B,0,B.length/2));
        List<Point> rightSide = skyline(Arrays.copyOfRange(B,B.length/2,B.length));
        return merge(leftside,rightSide);
    }

    private static List<Point> merge(List<Point> a, List<Point> b){
        int aPos=0;
        int bPos=0;
        int aEndHeight=0;
        int bEndHeight=0;

        List<Point> merged = new ArrayList<>();
        while(aPos < a.size() || bPos < b.size()){
            if(bPos >= b.size()){   //Fill in the last on the 1st list
                merged.add(a.get(aPos));
                aPos++;
            }
            else if(aPos >= a.size()){
                merged.add(b.get(bPos)); //Fill in the last of the 2nd list
                bPos++;
            }
            else if(a.get(aPos).x < b.get(bPos).x){ //add the next a tower if it is next
                int height = (a.get(aPos).y > bEndHeight) ? a.get(aPos).y : bEndHeight; //at the height of taller: a's height or the last b tower
                merged.add(new Point(a.get(aPos).x,height));
                aEndHeight = a.get(aPos).y;
                aPos++;
            }
            else if(a.get(aPos).x>b.get(bPos).x){ //add the next b tower if it is next
                int height = (b.get(bPos).y > aEndHeight) ? b.get(bPos).y : aEndHeight; //at the height of the taller: b's height or the last a tower
                merged.add(new Point(b.get(bPos).x,height));
                bEndHeight = b.get(bPos).y;
                bPos++;
            }
            else {
                int height = (a.get(aPos).y > b.get(bPos).y) ? a.get(aPos).y : b.get(bPos).y; //if they are at the same point, add the taller tower and increment both
                merged.add(new Point(a.get(aPos).x,height));
                aEndHeight = a.get(aPos).y;
                bEndHeight = b.get(bPos).y;
                aPos++;
                bPos++;
            }
        }
        for(int i=0; i<merged.size();i++){
            int j= i+1;
            while(j<merged.size() && merged.get(j).y == merged.get(i).y){ //if 2 points in a row have the same height, delete the duplicate
                merged.remove(j);
            }
        }

        return merged;


    }

}
