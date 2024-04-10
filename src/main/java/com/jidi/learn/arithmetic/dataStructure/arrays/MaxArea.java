package com.jidi.learn.arithmetic.dataStructure.arrays;



/**
 * 最多水的容器 https://leetcode.cn/problems/container-with-most-water/description/
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/21
 */
public class MaxArea {


    /**
     * 双指针
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        // 初始化双指针
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 计算容器容量
            int maxArea = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(maxArea, max);
            // 木桶容量取决于最短的那块木板，哪块木板小就去掉哪块
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


}
