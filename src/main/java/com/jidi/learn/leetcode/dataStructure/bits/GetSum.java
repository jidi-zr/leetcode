package com.jidi.learn.leetcode.dataStructure.bits;

/**
 * 371. 两整数之和 https://leetcode.cn/problems/sum-of-two-integers/description/
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 2
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 3
 * 输出：5
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/13
 */
public class GetSum {


    /**
     *  0 + 0 = 0，0 + 1 = 1，1 + 0 = 1，1 + 1 = 0（进位） 结果等价于异或^
     *  其中进位标识 carry 作用于下一位 next，相当于 next^carry ，
     *  只有 1 + 1 需要进位，通过 (a&b)<<1 先求出所有相加需要进位的 bit，再左移一位作用于下一位。
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new GetSum().getSum(3, 2));
    }
}
