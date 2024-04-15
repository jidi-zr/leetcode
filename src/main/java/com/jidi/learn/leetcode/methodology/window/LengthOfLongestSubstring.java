package com.jidi.learn.leetcode.methodology.window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 3. 无重复字符的最长子串 https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/30
 */
public class LengthOfLongestSubstring {


    /**
     * 滑动窗口 https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/1054787/zen-yao-yong-hua-dong-chuang-kou-wei-he-35418/
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if ("".equals(s) || Objects.isNull(s)) {
            return result;
        }
        int length = s.length();
        // 用来保存字符元素
        Map<Character, Integer> mp = new HashMap<>(length);
        // 初始化双指针
        int left = 0, right = 0;

        while (right < length) {
            // 如果存在重复的元素，移除掉重复元素直到不再重复
            while (left < right && mp.containsKey(s.charAt(right))) {
                mp.remove(s.charAt(left));
                left++;
            }
            // 当不会造成重复时将右指针所指向元素添加到map
            mp.put(s.charAt(right), 0);
            // 每次调整完左指针后都重新计算
            result = Math.max(result, right - left + 1);
            // 右指针不断右移
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
