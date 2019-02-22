import java.util.Arrays;

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {
        // TODO

        int[] range = {0,0};//new int[2];
        //int[] largestSubarrayRange;

        //oh shit, I did this one wrong too



        //Return the start and end integers of the largest array


        //Stack of the largestSubarray Stack

        //for each element that you add to the hashmap, check if the value of the top element is larger than the new value
        // if it is larger, add the new element to the stack

        //In the hashmap
        //Key: a tuple of the range
        //Value:  getTotal()

        for(int i=0; i<nums.length-1;i++){
            for (int j=i+1; j<nums.length;j++){
                if((j-i+1) % 2 == 0){
                    if(getTotal(nums,i,j)==(j-i)/2){
                        if(getTotal(nums,range[0], range[1])<(getTotal(nums,i,j))) {
                            range[0] = i;
                            range[1] = j;
                        }
                    }
                }

            }
        }

        return range;
        //if(getTotal(nums,range[0], range[1]))


        //int[] output = new int[nums.length];

        //Recursively find the longest subArray by checking one less on the left and the right

        //Base case: if the total is equal to the length/2 and the length is even
        // or if the length of the array is 1

//        if(nums.length <= 1) return null;
//        if(nums.length == 2 && getTotal(nums)!= 1) return null;
//        if(nums.length == 2 && getTotal(nums) == 1) return nums;

        //if(nums.length <= 3) return null;

//
//        if(getTotal(nums) == nums.length/2 && (nums.length % 2 == 0)){
//            return nums;
//        }
//
//        //Recursion:
//        //the sum and length of an array that is one less on the left side
//        // and the sum and length of one less on the right side
//
//        int[] copyTo = new int[nums.length-1];
//
//
//
//        System.arraycopy(nums,1, copyTo, 0, nums.length-1);
//        if(largestSubarray(copyTo)!=null){
//            return largestSubarray(copyTo);
//        };
//
//        System.arraycopy(nums,0, copyTo, 0, nums.length-2);
//        System.out.println(Arrays.toString(copyTo));
//        System.out.println(getTotal(copyTo));
//        largestSubarray(copyTo); //nums(0:nums.length-1));
//
//
//        return null;
        //return output;
    }


    // create a function that finds the totalSum of all of the elements in the array
    static int getTotal(int[] nums, int start, int end){
        int sum = 0;
        if(nums==null)return 0;
        for(int i=start; i<end; i++){
            sum+=nums[i];
        }
        return sum;
    }
}


