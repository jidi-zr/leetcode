package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 53. 最大子数组和  https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2025/3/9
 */
public class MaxSubArray {


    /**
     * 动态规划
     *
     * @param nums
     * @return: int
     * @author: jidi
     * @email: jidi_jidi@163.com
     * @date: 2025/3/9
     */
    public int maxSubArray(int[] nums) {
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
