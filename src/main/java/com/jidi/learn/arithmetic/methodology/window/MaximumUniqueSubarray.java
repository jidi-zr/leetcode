package com.jidi.learn.arithmetic.methodology.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1695. 删除子数组的最大得分 https://leetcode.cn/problems/maximum-erasure-value/description/
 * <p>
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/7
 */
public class MaximumUniqueSubarray {


    /**
     * 实际上就是求没有重复元素的最大连续子串
     */
    public static int maximumUniqueSubarray(int[] nums) {
        int length = nums.length;
        // 初始化窗口
        int left = 0, right = 0;

        // 统计窗口中各个元素出现的次数
        Map<Integer, Integer> window = new HashMap<>(2 * length);
        int sum = 0;
        int max = 0;
        while (right < length) {
            // 计算当前窗口元素累加和跟统计元素出现的次数
            int num = nums[right];
            window.put(num, window.getOrDefault(num, 0) + 1);
            sum += num;

            // 当前窗口没有重复元素
            if (window.size() == right - left + 1) {
                max = Math.max(max, sum);
            }

            // 存在重复元素，移除左指针指向的元素
            while (left < right && window.size() < right - left + 1) {
                int d = nums[left];
                sum -= d;
                window.put(d, window.get(d) - 1);
                // 如果当前元素出现次数为0，直接移除
                if (window.get(d).equals(0)) {
                    window.remove(d);
                }
                left++;
            }
            right++;
        }
        return max;
    }


    /**
     * 实际上就是求没有重复元素的最大连续子串
     */
    public static int maximumUniqueSubarray2(int[] nums) {
        int length = nums.length;
        // 初始化窗口
        int left = 0, right = 0;

        // 存放窗口中不重复的元素
        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int max = 0;
        while (right < length) {
            // 计算当前窗口元素累加和
            int num = nums[right];
            sum += num;
            // 如果当前元素在窗口中已经出现过，不断缩小窗口大小，直到当前元素在窗口中是唯一的
            while (set.contains(num)) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(num);
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray2(new int[]{4, 2, 4, 5, 6}));
    }
}
