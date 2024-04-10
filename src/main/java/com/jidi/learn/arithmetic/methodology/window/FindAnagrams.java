package com.jidi.learn.arithmetic.methodology.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词  https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/1
 */
public class FindAnagrams {

    /**
     * 滑动窗口
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length();
        int n = p.length();

        // 肯定不存在异位词
        if (m < n) {
            return result;
        }

        // 使用map保存需要的元素和窗口实际保存的元素
        Map<Character, Integer> need = new HashMap<>(s.length() * 2);
        Map<Character, Integer> map = new HashMap<>(p.length() * 2);

        // 先将p中每个字符出现的次数统计
        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 初始化双指针
        int left = 0, right = 0;
        // 初始化有效数量
        int valid = 0;

        // 外层循环，供右指针遍历
        while (right < m) {
            // 获取到当前右指针指向的元素
            char c = s.charAt(right);
            // 如果当前元素是需要的元素
            if (need.containsKey(c)) {
                // 先更新当前窗口元素的统计数据
                map.put(c, map.getOrDefault(c, 0) + 1);
                // 如果当前元素在窗口出现的次数跟需要出现的次数一致，有效数量加1
                if (need.get(c).equals(map.get(c))) {
                    valid++;
                }
            }

            // 只有当前窗口大于p字符串的长度，才存在有异位词的可能
            while (right - left + 1 >= n) {
                // 如果有效数量等于需要元素的size
                if (valid == need.size()) {
                    result.add(left);
                }
                // 获取要从窗口移除的元素
                char d = s.charAt(left++);
                // 如果要从从窗口移除的元素就是需要出现的元素，需要更新当前窗口的统计数据
                if (need.containsKey(d)) {
                    // 如果当前元素在窗口出现的次数跟需要出现的次数一致，移除后有效数量减1
                    if (need.get(d).equals(map.get(d))) {
                        valid--;
                    }
                    // 更新当前窗口元素统计数据
                    map.put(d, map.get(d) - 1);
                }
            }
            // 右指针不断移动
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc").forEach(System.out::println);
    }
}
