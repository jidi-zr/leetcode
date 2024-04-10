package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 两数之和 II - 输入有序数组 https://leetcode.cn/leetbook/read/array-and-string/cnkjg/
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/14
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{1, 1};

        // 定义双指针
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            // 相等直接返回
            if (numbers[left] + numbers[right] == target) {
                result[0] += left;
                result[1] += right;
            }
            // 小于target，左指针右移
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            // 大于target，右指针左移
            else {
                right--;
            }
        }
        return result;
    }
}
