package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 寻找旋转排序数组中的最小值 https://leetcode.cn/leetbook/read/array-and-string/c3ki5/
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
 * <p>
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/18
 */
public class FindMin {

    /**
     * 使用二分查找，有序数组经过旋转后一定会有一个转折点
     */
    public int findMin(int[] nums) {
        int length = nums.length;

        // 如果数组只有一个元素，直接返回该元素，它就是最小值
        if (length == 1) {
            return nums[0];
        }

        // 如果数组没有旋转，直接返回第一个元素，它就是最小值
        if (nums[0] < nums[length - 1]) {
            return nums[0];
        }

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }



}
