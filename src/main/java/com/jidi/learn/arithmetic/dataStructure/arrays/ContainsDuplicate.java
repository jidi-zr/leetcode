package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.Arrays;

/**
 * 存在重复值 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x248f5/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/29
 */
public class ContainsDuplicate {


    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 先排序
        Arrays.sort(nums);

        // 排序之后，比较相邻的元素
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
