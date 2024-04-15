package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 旋转数组 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2skh7/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/27
 */
public class RotateArray {

    // 使用一个临时数组，先把原数组的值存放到一个临时数组中，
    // 然后再把临时数组的值重新赋给原数组，
    // 重新赋值的时候要保证每个元素都要往后移k位，
    // 如果超过数组的长度就从头开始，所以这里可以使用(i + k) % length来计算重新赋值的元素下标
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1 || k == 0) {
            return;
        }

        // 把原数组值放到一个临时数组中，
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        // 把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
    }
}
