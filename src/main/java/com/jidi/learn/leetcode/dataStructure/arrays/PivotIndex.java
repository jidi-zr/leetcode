package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 寻找数组的中心索引 https://leetcode.cn/leetbook/read/array-and-string/yf47s/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class PivotIndex {

    /**
     * 暴力解决法，直接从第一位开始，依次计算两边的值之和，直到找到相等的
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int leftCount = 0;
        int rightCount = 0;
        while (left < nums.length) {
            // 计算左侧的值
            for (int i = 0; i < left; i++) {
                leftCount += nums[i];
            }
            // 计算右侧的值
            for (int i = left + 1; i < nums.length; i++) {
                rightCount += nums[i];
            }
            if (leftCount == rightCount) {
                return left;
            }
            leftCount = 0;
            rightCount = 0;
            left++;
        }
        return -1;
    }


    /**
     * 先得到总和，然后不断从左开始遍历计算累加和，直到找到中心索引所在元素
     */
    public static int pivotIndex2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // 计算总和
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        // 从左开始计算得到的累加和
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果除开自己外的所有左边元素累加和为总和的一半
            if (2 * leftSum == sum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


}
