package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 加一 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2cv1c/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/29
 */
public class PlusOne {


    /**
     * 直接相加
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果不等于9，直接添加
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            // 等于9，变为0，进一位（在上面的判断条件实现进一位）
            else {
                digits[i] = 0;
            }
        }
        // 走到这里，之前的数组元素都是9，需要进一位
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


    /**
     * 取余法
     */
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            // 如果加一之后取余不为0，不用进位，直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 走到这里，之前的数组元素都是9，需要进一位
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


}
