package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 42. 接雨水  https://leetcode.cn/problems/trapping-rain-water/description
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/29
 */
public class Trap {


    /**
     * 动态规划，
     * 从左往右遍历数组，记录每一个位置左边的最大值，然后再从右往左遍历数组，记录每一个位置右边的最大值
     * 两次遍历完之后就知道每一个位置左边和右边的最大值了，
     * 左右两边的最大值围成的区域可以看作是一个桶，桶的高度取决于这两个值的最小值，
     */
    public int trap(int[] height) {
        int length = height.length;
        int result = 0;

        if (height == null || length == 0) {
            return result;
        }

        // 前缀最大值
        int[] preMax = new int[length];
        preMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }

        // 后缀最大值
        int[] sufMax = new int[length];
        sufMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }

        // 每一个桶能放的水取决于桶两边的高度跟桶自身的高度
        for (int i = 0; i < length; i++) {
            result += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return result;
    }


    /**
     * 基于双指针实现
     */
    public int trap2(int[] height) {
        int length = height.length;
        int result = 0;
        if (height == null || length == 0) {
            return result;
        }

        // 初始化左右指针
        int left = 0;
        int right = length - 1;
        // 初始化桶两边高度
        int preMax = 0;
        int sufMax = 0;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);

            // 哪边木板高度小，接的水就以小的木板为准
            if (preMax < sufMax) {
                result += preMax - height[left++];
            } else {
                result += sufMax - height[right--];
            }
        }
        return result;
    }


}
