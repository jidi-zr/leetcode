package com.jidi.learn.leetcode.methodology.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列  https://leetcode.cn/problems/permutation-in-string/description/
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/1
 */
public class CheckInclusion {

    /**
     * 滑动指针，当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 如果s2字符串长度小于s1字符串的长度，肯定不是
        if (n < m) {
            return false;
        }

        // 使用map保存需要的元素和窗口实际保存的元素
        Map<Character, Integer> need = new HashMap<>(s1.length() * 2);
        Map<Character, Integer> map = new HashMap<>(s2.length() * 2);

        // 初始化双指针
        int left = 0, right = 0;
        // 初始化有效数量
        int valid = 0;

        // 先将s1中每个字符出现的次数统计
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 外层循环，供右指针遍历
        while (right < n) {
            // 获取到当前右指针指向的元素
            char c = s2.charAt(right);
            // 如果当前元素是需要的元素
            if (need.containsKey(c)) {
                // 先更新当前窗口元素的统计数据
                map.put(c, map.getOrDefault(c, 0) + 1);
                // 如果当前元素在窗口出现的次数跟需要出现的次数一致，有效数量加1
                if (need.get(c).equals(map.get(c))) {
                    valid++;
                }
            }

            // 只有当前窗口大于s1字符串的长度，才存在有子串排列的可能
            while (right - left + 1 >= m) {
                // 如果有效数量等于需要元素的size
                if (valid == need.size()) {
                    return true;
                }
                // 获取要从窗口移除的元素
                char d = s2.charAt(left++);
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
        return false;
    }
}
