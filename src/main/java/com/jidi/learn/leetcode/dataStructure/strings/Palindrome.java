package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 验证回文串 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xne8id/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        // [^A-Za-z0-9] 表示匹配除了字母数字之外的字符
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        for (int i = 0; i < s1.length() / 2; i++) {
            if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


}
