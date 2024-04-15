package com.jidi.learn.leetcode.dataStructure.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词  https://leetcode.cn/problems/valid-anagram/description/
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/1
 */
public class IsAnagram {


    /**
     * 使用hash
     */
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        // 使用map保存需要的元素和窗口实际保存的元素
        Map<Character, Integer> need = new HashMap<>(s.length() * 2);

        for (Character c : s.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            if (!need.containsKey(c)) {
                return false;
            }
            need.put(c, need.get(c) - 1);
            if (need.get(c) < 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 对字符串 s和 t 分别排序，看排序后的字符串是否相等
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


}
