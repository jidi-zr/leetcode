package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 字符串转换整数 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnoilh/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class Atoi {

    public static int myAtoi(String s) {
        // 移除最前面的空格
        String s1 = s.trim();

        // 为空
        if (s1.length() == 0) {
            return 0;
        }

        // 记录正负
        int flag = 1;
        String s2 = s1;
        // 如果负数，移除负数符号
        if (s1.charAt(0) == '-') {
            flag = -1;
            s2 = s1.replaceFirst("-", "");
        }
        // 如果正数，移除正数符号
        if (s1.charAt(0) == '+') {
            s2 = s1.replaceFirst("\\+", "");
        }

        long res = 0;
        for (int i = 0; i < s2.length(); i++) {
            // 如果不是数字，直接退出
            if (!Character.isDigit(s2.charAt(i))) {
                break;
            }

            // char类型的转换为数字需要 - '0'
            res = res * 10 + s2.charAt(i) - '0';

            // 越界处理
            if (res > Integer.MAX_VALUE) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        res *= flag;
        return (int) res;
    }


}
