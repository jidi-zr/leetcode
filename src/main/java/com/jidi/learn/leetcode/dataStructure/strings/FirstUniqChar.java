package com.jidi.learn.leetcode.dataStructure.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn5z8r/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class FirstUniqChar {


    /**
     * 第一遍先统计每个字符出现的次数，第二遍再次从前往后遍历字符串s中的每个字符，如果某个字符出现一次直接返回
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();

        // 先统计每个字符的数量
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 然后在遍历字符串s中的字符，如果出现次数是1就直接返回
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 分别从两端向中间遍历，如果下标相等，则说明只出现了一次
     */
    public int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
