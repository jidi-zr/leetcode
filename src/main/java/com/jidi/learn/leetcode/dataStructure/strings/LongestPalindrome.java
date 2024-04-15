package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 最长回文子串 https://leetcode.cn/leetbook/read/array-and-string/conm7/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/2
 */
public class LongestPalindrome {

    /**
     * 暴力破解法
     */
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        String result = "";
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                if (isPalindromic(temp) && temp.length() > max) {
                    result = temp;
                    max = Math.max(max, result.length());
                }
            }
        }

        return result;
    }


    /**
     * 判断是否是回文字符串
     */
    public static boolean isPalindromic(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 中心扩散法
     */
    String longestPalindrome2(String s) {
        // 边界条件判断
        if (s.length() < 2) {
            return s;
        }
        // start表示最长回文串开始的位置，
        // maxLen表示最长回文串的长度
        int start = 0, maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            // 如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
            if (length - i <= maxLen / 2) {
                break;
            }
            int left = i, right = i;
            while (right < length - 1 && s.charAt(right + 1) == s.charAt(right)) {
                // 过滤掉重复的
                ++right;
            }
            // 下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            // 然后往两边判断，找出回文子串的长度
            while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            // 保留最长的
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        // 截取回文子串
        return s.substring(start, start + maxLen);
    }


}
