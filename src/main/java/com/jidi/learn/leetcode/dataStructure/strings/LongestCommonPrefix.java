package com.jidi.learn.leetcode.dataStructure.strings;

import java.util.Arrays;

/**
 * 最长公共前缀 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnmav1/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class LongestCommonPrefix {

    /**
     * 先取第一个字符串当做他们的公共前缀
     * 然后找出他和第2个字符串的公共前缀，然后再用这个找出的公共前缀分别和第3个，第4个……判断
     */
    public String longestCommonPrefix(String[] strs) {
        String result = "";

        if (strs == null || strs.length == 0) {
            return result;
        }

        // 默认第一个是公共子串
        result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 跟每个字符串进行比较，每比较一次，如果没有找到公共子串，丢弃最后一个字符，再进行比较
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }


    /**
     * 先排序，然后只需要比较第一个和最后一个的公共子串即可
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 排序
        Arrays.sort(strs);

        // 排序后的第一个元素
        String first = strs[0];
        //排序后的最后一个元素
        String last = strs[strs.length - 1];

        int i;
        int minLength = Math.min(first.length(), last.length());
        for (i = 0; i < minLength; i++) {
            // 依次比较，直到不等为止
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
        }

        return first.substring(0, i);
    }


}
