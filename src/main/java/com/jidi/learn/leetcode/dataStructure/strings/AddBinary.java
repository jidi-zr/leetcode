package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 67. 二进制求和  https://leetcode.cn/problems/add-binary/description/
 * <p>
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * <p>
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class AddBinary {


    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int capacity = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int v1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = capacity + v1 + v2;
            capacity = sum / 2;
            sum = sum % 2;
            result.append(sum);
        }
        if (capacity > 0) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
