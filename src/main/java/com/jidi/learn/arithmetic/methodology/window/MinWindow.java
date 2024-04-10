package com.jidi.learn.arithmetic.methodology.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 76，最小覆盖子串  https://leetcode.cn/problems/minimum-window-substring/description/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/4
 */
public class MinWindow {


    /**
     * 滑动窗口
     */
    public static String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        // 如果s长度小于t长度，肯定不会有最小覆盖子串
        if (sLength < tLength) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>(tLength * 2);
        Map<Character, Integer> map = new HashMap<>(sLength * 2);

        // 初始统计t字符出现个数
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 初始化双指针
        int left = 0, right = 0;
        // 初始化有效数量
        int valid = 0;
        // 保存最小覆盖子串长度
        int min = Integer.MAX_VALUE;
        String result = "";

        while (right < sLength) {
            char c = s.charAt(right);
            // 是要出现的字符
            if (need.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                // 如果需要出现的字符次数与当前窗口统计的次数一致，有效数量加1
                if (need.get(c).equals(map.get(c))) {
                    valid++;
                }
            }

            // 当前窗口有效字符数量大于等于需要出现字符数量
            while (valid >= need.size()) {
                int temp = right - left + 1;
                // 如果当前窗口出现了更小的覆盖子串，更新覆盖子串
                if (min > temp) {
                    min = temp;
                    result = s.substring(left, right + 1);
                }

                char d = s.charAt(left++);
                // 要从窗口移除的字符就是需要的字符
                if (need.containsKey(d)) {
                    // 如果窗口统计数据跟需要的字符一致，有效数量减1
                    if (need.get(d).equals(map.get(d))) {
                        valid--;
                    }
                    map.put(d, map.get(d) - 1);
                }
            }
            // 不断扩大窗口
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
