package com.jidi.learn.arithmetic.methodology.window;

/**
 * 1004. 最大连续1的个数 III  https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * <p>
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/1
 */
public class LongestOnes {

    /**
     * 滑动窗口
     * <p>
     * 把「最多可以把 K 个 0 变成 1，求仅包含 1 的最长子数组的长度」转换为 「找出一个最长的子数组，该子数组内最多允许有 K 个 0 」。
     */
    public int longestOnes(int[] nums, int k) {
        int result = 0;
        int length = nums.length;
        if (nums == null || length == 0) {
            return result;
        }

        // 初始化双指针
        int left = 0, right = 0;
        // 保存当前区间0的个数
        int zeros = 0;

        // 右指针遍历到数组尾
        while (right < length) {
            // 如果右指针所在元素为0，zeros加1
            if (nums[right] == 0) {
                zeros++;
            }
            // 如果滑动窗口内的元素0的个数大于k，则要移动左指针，直到元素0的个数小于等于K
            while (zeros > k) {
                // 如果左指针指向元素是0，zeros减1
                if (nums[left] == 0) {
                    zeros--;
                }
                // 继续移动左指针
                left++;
            }
            // while 循环结束时，找到了满足条件的子数组，需要重新计算子数组长度
            result = Math.max(result, right - left + 1);

            // 右指针不断移动
            right++;
        }
        return result;
    }
}
