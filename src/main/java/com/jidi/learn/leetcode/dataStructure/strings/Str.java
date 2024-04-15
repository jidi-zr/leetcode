package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 实现 strStr() https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnr003/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class Str {
    public static int strStr(String haystack, String needle) {
        // 肯定不包含子字符串
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int len = needle.length();
        // 不断截取子字符串
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }





    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }
}
