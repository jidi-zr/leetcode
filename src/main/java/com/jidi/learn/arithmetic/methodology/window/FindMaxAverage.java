package com.jidi.learn.arithmetic.methodology.window;

/**
 * 643. 子数组最大平均数 I  https://leetcode.cn/problems/maximum-average-subarray-i/description/
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * 示例 2：
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/2
 */
public class FindMaxAverage {


    /**
     * 滑动窗口
     */
    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0.0d;
        }

        // 初始化左右指针
        int left = 0;
        int right = 0;
        // 先将最大值定义成一个负无穷，处理窗口之和是负数的情况
        double max = Integer.MIN_VALUE;
        // k个数之和
        double sum = 0d;
        // 平均值
        double avg = 0d;

        while (right < nums.length) {
            // 累加和
            sum += nums[right];
            // 保证窗口的长度是k
            if (right - left + 1 >= k) {
                avg = sum / k;
                max = Math.max(max, avg);
                // sum用完之后将首个元素删去，同时将左指针右移（滑动窗口）
                sum -= nums[left++];
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] s = new int[]{-6662, 5432, -8558, -8935, 8731, -3083, 4115, 9931, -4006, -3284, -3024, 1714, -2825, -2374, -2750, -959, 6516, 9356, 8040, -2169, -9490, -3068, 6299, 7823, -9767, 5751, -7897, 6680, -1293, -3486, -6785, 6337, -9158, -4183, 6240, -2846, -2588, -5458, -9576, -1501, -908, -5477, 7596, -8863, -4088, 7922, 8231, -4928, 7636, -3994, -243, -1327, 8425, -3468, -4218, -364, 4257, 5690, 1035, 6217, 8880, 4127, -6299, -1831, 2854, -4498, -6983, -677, 2216, -1938, 3348, 4099, 3591, 9076, 942, 4571, -4200, 7271, -6920, -1886, 662, 7844, 3658, -6562, -2106, -296, -3280, 8909, -8352, -9413, 3513, 1352, -8825};


        System.out.println(findMaxAverage(s, 90));
    }
}
