package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 66. 加一  https://leetcode.cn/problems/plus-one/description/
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class PlusOne2 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 加一之后取余
            digits[i] = (digits[i] + 1) % 10;
            // 余数为0.需要进位1，否则直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }
}
