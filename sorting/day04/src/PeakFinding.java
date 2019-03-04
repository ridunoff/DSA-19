import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        // TODO
        int mid = nums.length/2;
        int peak = 0;

        int direction = peakOneD(mid,nums);

        if(direction == 0) {
            return mid;
        }
        else if(direction == -1 ){ //check the array from 0 to mid
            int newNumsLength = 0;
            if(nums.length%2==0) newNumsLength = nums.length/2;
            else newNumsLength = nums.length/2-1;
            int[] numsCopy = new int[newNumsLength];
            System.arraycopy(nums, 0,numsCopy,0,mid);
            findOneDPeak(numsCopy);
        }
        else if(direction==1){
            if(nums.length == 2){
                if(nums[0]<nums[1]) {
                    System.out.println("hi");
                    return 1;
                }
            }
            int newNumsLength = 0;
            if(nums.length%2==0) newNumsLength = nums.length/2-1;
            else newNumsLength = nums.length/2;
            int[] numsCopy = new int[newNumsLength];
            System.arraycopy(nums, mid+1,numsCopy,0,nums.length-mid-1);
            return mid + 1 +  findOneDPeak(numsCopy);
        }
        System.out.println("peak"+peak);
        return peak;

    }

    public static int[] arraySum(int[] a, int[] b){
        int[] out = new int[a.length];

        for(int i=0; i<a.length; i++){
            out[i] = a[i]+b[i];
        }
        return out;
    }

    public static int[] findTwoDPeak(int[][] nums) {
        // TODO


        int midX = nums[0].length/2; //middle x column index
        int midY = nums.length/2;    //middle y row index


        int highestX = maxXIndex(midY,0,nums[0].length, nums); //The max X index in the row at midY
        int highestY = maxYIndex(midX,0,nums.length,nums);     //The max Y index in column at midX


        int horizontalPeak = peakX(midX,highestY,nums); //check if the middle column max is also peak horizontally
        int verticalPeak = peakY(highestX,midY,nums);   //check if the middle row max is also a peak vertically


        //If the width of the array is 2, check if the bottom right corner is a peak
        if(nums[0].length == 2){
            int xMax = nums.length-1;
            int yMax = nums[0].length-1;
            if(nums[xMax][yMax] > nums [xMax][yMax-1] && nums[xMax][yMax] > nums[xMax-1][yMax])
                return new int[]{xMax,yMax-1};
        }


        //if the horizontal max is a peak, check if it is also a vertical peak
        if(horizontalPeak == 0) {
            if(peakY(midX,highestY,nums) == 0){
                return new int[]{highestY, midX};
            }

        }


        //if the vertical max is a peak, check if it is also a horizontal peak
        if(verticalPeak == 0) {
            if(peakX(highestX,midY,nums) == 0){
                return new int[]{midY,highestX};
            }
        }


        //If the y dimension is larger than the x dimension, cut the y direction in half
        if(nums.length>=nums[0].length){

            //If it is 2 wide, check if the top left corner is a peak
            if(nums[0].length == 2){
                if(nums[0][0] > nums [0][1] && nums[0][0] > nums[1][0])
                    return new int[]{0,0};
            }

            //If the peak is going to be above the horizontal max, cut the array to just the numbers above that row
            if(verticalPeak == -1  && nums.length > 2){
                int newNumsHeight;
                //Adjust the new height for even and odd numbers
                if(nums.length%2==0) newNumsHeight = nums.length/2-1;
                else newNumsHeight = nums.length/2;
                //Create a new array
                int[][] newNumsArray = new int[newNumsHeight][nums[0].length];
                //Copy the old elements in to the new array
                for(int i=0;i<newNumsHeight;i++){
                    System.arraycopy(nums[i], 0,newNumsArray[i],0,nums[0].length);
                }

                return findTwoDPeak(newNumsArray);
            }

            //If the peak is going to be below the horizontal max, cut the array to just the numbers below that row
            if(verticalPeak == 1 || verticalPeak == 0){
                int newNumsHeight;
                if(nums.length%2==0) newNumsHeight = nums.length/2;
                else newNumsHeight = nums.length/2+1;
                int[][] newNumsArray = new int[newNumsHeight][nums[0].length];
                int index = 0;

                //Adjust for the different lengths of the new array depending on if it was even or odd
                if(nums.length%2==0){
                    for(int i=newNumsHeight;i<nums.length;i++){
                        System.arraycopy(nums[i], 0,newNumsArray[index],0,nums[0].length);
                        index++;
                    }
                    return arraySum(new int[]{0,newNumsHeight},findTwoDPeak(newNumsArray));
                }
                else{
                    for(int i=newNumsHeight-1;i<nums.length;i++){
                        System.arraycopy(nums[i], 0,newNumsArray[index],0,nums[0].length);
                        index++;
                    }
                    return arraySum(new int[]{0,newNumsHeight},findTwoDPeak(newNumsArray));
                }
            }
        }

        //If the x dimension is larger than the y dimension, cut the x direction in half
        else{

            //If the height of the array is 2, return the bottom right corner if it is a peak
            if(nums.length == 2){
                if(nums[1][1] > nums [0][1] && nums[1][1] > nums[1][0])
                    return new int[]{1,1};
            }

            //If the peak is to the left, cut the array to just the numbers to the left of the column
            if(horizontalPeak == -1 && nums[0].length > 2){
                int newNumsWidth;
                if(nums[0].length%2==0) newNumsWidth = nums[0].length/2-1;
                else newNumsWidth = nums[0].length/2;
                int[][] newNumsArray = new int[nums.length][newNumsWidth];

                for(int i=0;i<nums.length;i++){
                    System.arraycopy(nums[i], 0,newNumsArray[i],0,newNumsWidth);
                }

                return findTwoDPeak(newNumsArray);
            }

            //If the peak is to the right, cut the array to just the numbers to the right of the column
            if(horizontalPeak == 1 || horizontalPeak==0){
                int newNumsWidth;
                if(nums[0].length%2==0) newNumsWidth = nums[0].length/2-1;
                else newNumsWidth = nums[0].length/2;
                int[][] newNumsArray = new int[nums.length][newNumsWidth];

                for(int i=0;i<nums.length;i++){
                    System.arraycopy(nums[i], newNumsWidth+1,newNumsArray[i],0,newNumsWidth);
                }

                return arraySum(new int[]{newNumsWidth+1,0},findTwoDPeak(newNumsArray));
            }
        }

        return null;
    }

}
