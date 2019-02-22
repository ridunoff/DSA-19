import java.util.HashMap;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {

        HashMap<Integer, Integer> sets = new HashMap<>();
        int distance;
        int total=0;
        int n;
        for(int i=0; i<points.length;i++){ //Makes each element the middle point
            for(int j=0;j<points.length;j++) {

                if (i != j) { //Don't find the distance from itself

                    distance = getSquaredDistance(points[i], points[j]); //Finds the distance between 2 points

                    if (sets.get(distance) == null) { //Adds the distance to the hashmap
                        sets.put(distance, 1);
                    } else {
                        sets.put(distance, sets.get(distance) + 1); //If that distance is in the hashmap, increment the value by 1.
                    }
                }
            }

            for(HashMap.Entry<Integer,Integer> entry : sets.entrySet()){
                n = entry.getValue();
                total += n * (n-1);
            }

            sets.clear();
        }
        return total;
    }


    public static int getSquaredDistance(int[] a,int[] b){
        return (int)(Math.pow((b[1] - a[1]),2) + Math.pow((b[0] - a[0]),2)); //Calculates distance
    }
}

