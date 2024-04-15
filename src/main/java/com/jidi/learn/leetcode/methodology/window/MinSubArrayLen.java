package com.jidi.learn.leetcode.methodology.window;

/**
 * 长度最小的子数组 https://leetcode.cn/leetbook/read/array-and-string/c0w4r/
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/16
 */
public class MinSubArrayLen {


    /**
     * 暴力法
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }

        // 默认为MAX_VALUE
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            // 如果自己本身就大于等于目标值，自己就是最小的子数组
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            // 从当前元素后面的元素开始计算累加和
            for (int j = i + 1; j < length; j++) {
                // 累加和
                sum += nums[j];
                // 如果累加和大于等于目标值
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    /**
     * 滑动窗口
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // 定义双指针
        int start = 0, end = 0;
        int sum = 0;
        while (end < length) {
            sum += nums[end];
            // 窗口大了
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                // 缩小窗口
                sum -= nums[start];
                start++;
            }
            // 不断的扩展窗口
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{3, 1, 2, 4, 3}));
    }
}
