package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 最大连续1的个数 https://leetcode.cn/leetbook/read/array-and-string/cd71t/
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/15
 */
public class FindMaxConsecutiveOnes {

    /**
     * 快慢指针
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 定义快慢指针
        int slow = 0;
        int fast = 0;

        // 快指针不能越界
        while (fast < nums.length) {
            // 如果快指针的值是1，继续移动快指针
            if (nums[fast] == 1) {
                fast++;
            }
            // 如果快指针的值不是1，移动快指针，并且移动慢指针（slow=fast）
            else {
                result = Math.max(result, fast - slow);
                slow = ++fast;
            }
        }
        // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
        result = Math.max(result, fast - slow);
        return result;
    }


    /**
     * 快慢指针优化版本
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int slow = 0;
        int fast = 0;
        int maxSize = 0;

        while (fast < nums.length) {
            // 当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
            if (nums[fast++] == 0) {
                // 当窗口中存在 0 时，计算连续序列长度，左指针指向右指针。
                maxSize = Math.max(maxSize, fast - slow - 1);
                slow = fast;
            }
        }
        // 因为最后一次连续序列在循环中无法比较，所以在循环外进行比较
        return Math.max(maxSize, fast - slow);
    }


    /**
     * 贪心算法
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {
            // 等于1就追加
            if (nums[i] == 1) {
                temp++;
            }
            // 不等于1置为0，重新开始计数
            else {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
