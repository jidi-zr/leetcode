package com.jidi.learn.leetcode.methodology.window;

/**
 * 1208. 尽可能使字符串相等 https://leetcode.cn/problems/get-equal-substrings-within-budget/description/
 * <p>
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * <p>
 * 示例 2：
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * <p>
 * 示例 3：
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/8
 */
public class EqualSubstring {

    /**
     * 滑动窗口
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();

        // 初始化窗口相关数据
        int left = 0, right = 0;
        int sum = 0;
        int max = 0;
        while (right < length) {
            // 计算相同位置差值，需要考虑为负数的情况
            int i = Math.abs(s.charAt(right) - t.charAt(right));
            sum += i;

            // 不满足条件，缩小窗口
            while (sum > maxCost) {
                int j = Math.abs(s.charAt(left) - t.charAt(left));
                sum -= j;
                left++;
            }
            // 每次走到这里，都要重新计算
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "acde", 0));
    }
}
