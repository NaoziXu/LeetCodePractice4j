package org.huoran.lcp4j;

/**
 * Created by Naozi on 2017/6/26.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class No283_MoveZeroes {

    /**
     * TLE: bubble sort
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if(nums != null && nums.length > 1){
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length; j++){
                    if(nums[i] == 0 && nums[j] != 0){
                        int k = nums[i];
                        nums[i] = nums[j];
                        nums[j] = k;
                    }
                }
            }
        }
    }

    /**
     * (>.<)
     * @param nums
     */
    public static void moveZerosFaster(int[] nums){
        if(nums != null && nums.length > 1){
            int index = 0;
            for(int num : nums){
                if(num != 0){
                    nums[index] = num;
                    index ++;
                }
            }
            while(index < nums.length){
                nums[index] = 0;
                index++;
            }
        }
    }


    public static void main(String[] args){
        int nums[] = new int[]{0,1,0,4,5};
        moveZerosFaster(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }
    }
}
