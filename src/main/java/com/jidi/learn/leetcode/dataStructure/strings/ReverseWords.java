package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 翻转字符串里的单词 https://leetcode.cn/leetbook/read/array-and-string/crmp5/
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/3
 */
public class ReverseWords {


    /**
     * 转换为数组，然后逆序拼接
     */
    public static String reverseWords(String s) {
        String result = "";

        String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!"".equals(split[i])) {
                result += split[i] + " ";
            }
        }

        return result.trim();
    }


    /**
     * 使用双指针，两个指针从右边开始移动，找到一个完整的字符就添加，直到越界
     */
    public static String reverseWords2(String s) {
        // 删除首尾空格
        s = s.trim();

        // 定义双指针
        int right = s.length() - 1;
        int left = right;

        StringBuilder res = new StringBuilder();
        // 边界条件就是左指针不能小于0
        while (left >= 0) {
            // 不停搜索单词
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // 添加单词
            res.append(s.substring(left + 1, right + 1) + " ");

            // 不停搜索空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            // 移动右指针，开始下一个单词的寻找
            right = left;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords2("a good   example"));
    }
}
