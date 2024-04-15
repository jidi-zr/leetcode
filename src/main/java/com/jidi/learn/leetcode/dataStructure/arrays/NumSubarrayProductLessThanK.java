package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 713. 乘积小于 K 的子数组 https://leetcode.cn/problems/subarray-product-less-than-k/description/
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/29
 */
public class NumSubarrayProductLessThanK {

    /**
     * 滑动窗口
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        // 排除nums为空和k为1的情况比如 [1,1,1] k=1
        if (nums == null || length == 0 || k <= 1) {
            return result;
        }

        // 定义双指针
        int left = 0, right = 0;
        // 保存乘积
        int mul = 1;

        // 用右指针遍历整个数组，每次循环右指针右移一次
        while (right < length) {
            mul *= nums[right];

            // 当大于等于k，左指针右移并把之前左指针的数除掉
            while (mul >= k) {
                mul /= nums[left++];
            }
            // 每次右指针位移到一个新位置，应该加上x种数组组合：
            //  nums[right]
            //  nums[right-1], nums[right]
            //  nums[right-2], nums[right-1], nums[right]
            //  nums[left], ......, nums[right-2], nums[right-1], nums[right]
            // 共有 right - left + 1 种
            result += right - left + 1;

            // 右指针右移
            right++;
        }
        return result;
    }
}
