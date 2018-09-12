package io.varaga.algorithms.bit;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // edge cases nums is null, length == 0 etc.,
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int currDup = -1;
        int replaceIndex = 0;
        int index = 0;
        //check if there are duplicate elements
        while(index < nums.length) {
            if(currDup != nums[index]) {
                currDup = nums[index];
                nums[replaceIndex] = currDup;
                replaceIndex++;
            } // end of if
            index++;
        } //end of while
        return replaceIndex;
    }//end of removeDuplicates

    public static void main(String ...args) {
    	new RemoveDuplicates().removeDuplicates(new int[0]);
    }
}

