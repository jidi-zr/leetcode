package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.Arrays;

/**
 * 只出现一次的数字 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x21ib6/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/29
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        // 先排序
        Arrays.sort(nums);

        for (int i = 1; i < length - 1; i++) {
            // 如果排完序后第一个元素跟第二个元素不等，直接返回第一个元素
            if (nums[i - 1] != nums[i] && i == 1) {
                return nums[i - 1];
            }
            // 如果排完序后最后一个元素跟倒数第二个元素不等，直接返回最后一个元素
            if (nums[i + 1] != nums[i] && i == length - 2) {
                return nums[i + 1];
            }
            // 如果唯一元素不在两端，直接跟前后元素进行比较
            if (nums[i - 1] != nums[i] && nums[i + 1] != nums[i]) {
                return nums[i];
            }
        }
        return nums[0];
    }


    /**
     * 最优雅的解法，异或
     * 使用异或运算，将所有值进行异或
     * 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
     * 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
     */
    public int singleNumber1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int reuslt = 0;
        for (int i = 0; i < length; i++) {
            reuslt = reuslt ^ nums[i];
        }
        return reuslt;
    }


    /**
     * 先排序，然后左右两个元素两两进行比较，如果相等，则跳到下一组，如果不相等，则当前位置元素就是不重复的
     */
    public int singleNumber3(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int i = 0;
        while (i < length - 1) {
            // 排好序后，只需要跟边上的元素进行比较
            if (nums[i] != nums[i + 1]) {
                break;
            }
            // 一次跳过比较的一组，即2个元素
            i += 2;
        }
        return nums[i];
    }


}
