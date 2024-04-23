package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.Arrays;

/**
 * 977. 有序数组的平方  https://leetcode.cn/problems/squares-of-a-sorted-array/
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/23
 */
public class SortedSquares {


    /**
     * 直接计算并排序
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] result = new int[nums.length];

        // 计算并插入平方和
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        // 排序
        this.selectSort(result);
        return result;
    }


    /**
     * 简单选择排序
     */
    private void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // n个元素要比较n-1次
        for (int i = 0; i < nums.length; i++) {
            // 默认每次比较的时候当前元素就是最小的
            int minIndex = i;
            // 前面的元素已经排好序，还需要同后面的元素进行比较
            for (int j = i + 1; j < nums.length; j++) {
                // 只要找到更小的元素，就更新最小元素索引
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 每一个元素同后面的所有元素比较完之后需要根据情况交换
            if (minIndex != i) {
                this.swap(nums, i, minIndex);
            }
        }
    }


    /**
     * 交换元素
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }


    /**
     * 双指针
     */
    public static int[] sortedSquares2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] result = new int[nums.length];

        // 双指针
        int left = 0, right = nums.length - 1;
        // 从最后一个位置开始赋值
        int index = nums.length - 1;
        while (left <= right) {
            // 由于原来数组是排好序的，位于两端的元素的谁绝对值大，就先计算
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }


    public static void main(String[] args) {
        Arrays.stream(sortedSquares2(new int[]{-4, -1, 0, 3, 10})).forEach(System.out::println);
    }
}

