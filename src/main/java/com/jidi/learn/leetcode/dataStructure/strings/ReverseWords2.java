package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 反转字符串中的单词 III    https://leetcode.cn/leetbook/read/array-and-string/c8su7/
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * 输入： s = "Mr Ding"
 * 输出："rM gniD"
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/18
 */
public class ReverseWords2 {

    /**
     * 快慢指针
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        // 初始化快慢指针
        int slow = 0, fast = 0;
        String result = "";

        // 快指针不能越界
        while (fast < s.length()) {
            if (s.charAt(fast++) == ' ') {
                // 截取反转单词
                result += reverseString(s, slow, fast);
                // 慢指针向前移动
                slow = fast;
            }
        }

        // 走到这里，还需要判断fast是不是等于slow，如果不等于，还需要处理最后一个单词
        if (slow != fast) {
            result += " ";
            result += reverseString(s, slow, fast);
        }
        return result.trim();
    }


    /**
     * 反转单词
     */
    private static String reverseString(String s, int slow, int fast) {
        // 截取单词
        String temp = s.substring(slow, fast);
        String result = "";
        // 反转单词
        for (int i = temp.length() - 1; i >= 0; i--) {
            result += temp.charAt(i);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

}
