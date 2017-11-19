package com.test;

import java.util.Arrays;

/**
 * Created by yanfeng-mac on 2017/11/12.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++) {
            for(int j = i + 1;j < nums.length;j++) {
                if(nums[j] + nums[i] == target) {
                    int[] array = {i,j};
                    return array;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,2,4};
        System.out.println(Arrays.toString(solution.twoSum(array,6)));
    }
}
