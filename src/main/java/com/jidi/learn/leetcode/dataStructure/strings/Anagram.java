package com.jidi.learn.leetcode.dataStructure.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn96us/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class Anagram {

    /**
     * 使用hash存储每个字符出现的次数，然后进行判断
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 存放统计结果
        HashMap<Character, Integer> sMap = new HashMap<>(s.length() * 2);
        HashMap<Character, Integer> tMap = new HashMap<>(t.length() * 2);

        // 分别统计每个字符串各个字符出现的次数
        for (int i = 0; i < sChars.length; i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        }
        for (int i = 0; i < tChars.length; i++) {
            tMap.put(tChars[i], tMap.getOrDefault(tChars[i], 0) + 1);
        }

        // 遍历map，判断字符出现次数是否一样
        for (Map.Entry<Character, Integer> temp : sMap.entrySet()) {
            // 如果该字符出现的次数为null，肯定不是字母字母异位词
            if (tMap.get(temp.getKey()) == null) {
                return false;
            }
            // 如果该字符出现的次数不一致，肯定不是字母字母异位词
            if (tMap.get(temp.getKey()) != null && tMap.get(temp.getKey()).intValue() != temp.getValue()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 是上面方法的优化，上面方案使用了两个hash，总共遍历了3次
     * 可以只用一个hash，遍历两次即可实现
     */
    public boolean isAnagram2(String s, String t) {
        // 长度不一致，肯定不是字母字母异位词
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 存放统计结果
        HashMap<Character, Integer> map = new HashMap<>(s.length() * 2);

        // 遍历第一个字符串，统计每个字符出现的次数
        for (int i = 0; i < sChars.length; i++) {
            map.put(sChars[i], map.getOrDefault(sChars[i], 0) + 1);
        }

        // 遍历第二个字符串，判断是否有字符的次数是否不为0
        for (int i = 0; i < tChars.length; i++) {
            // 次数减一
            map.put(tChars[i], map.getOrDefault(tChars[i], 0) - 1);
            // 如果出现次数小于0，肯定不是字母字母异位词
            if (map.get(tChars[i]) < 0) {
                return false;
            }
        }
        return true;
    }
}
