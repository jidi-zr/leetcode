package com.jidi.learn.arithmetic.methodology.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串 https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/
 * <p>
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * <p>
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * <p>
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/8
 */
public class FindSubstring {

    /**
     * 哈希表+滑动窗口
     * 通过维护一个滑动窗口，滑动窗口的大小为所有单词的总长度，我们每次向后移动一格，判断窗口中的所有单词是否和words全部匹配。
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        // 单词个数
        int num = words.length;
        // 单词长度
        int wordLength = words[0].length();
        // 窗口大小
        int windowLength = num * wordLength;

        // 存放所有单词
        Map<String, Integer> wordsMap = new HashMap<>((int) (num / 0.75) + 1);
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        // 只需要遍历到字符长度不满足窗口大小为止
        while (i <= s.length() - windowLength) {
            HashMap<String, Integer> curMap = new HashMap<>((int) (num / 0.75) + 1);
            // 是否存在异常情况
            boolean errorFlag = false;

            // 每次移动一个单词
            for (int j = 0; j < num; j++) {
                // 第j个单词
                String curWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                // 出现不存在单词，直接退出循环
                if (!wordsMap.containsKey(curWord)) {
                    errorFlag = true;
                    break;
                }
                curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
                // 出现超数量单词，直接退出循环
                if (curMap.get(curWord) > wordsMap.get(curWord)) {
                    errorFlag = true;
                    break;
                }
            }
            // 没有异常情况 记录答案
            if (!errorFlag) {
                result.add(i);
            }
            i++;
        }
        return result;
    }



    /**
     * 滑动窗口经典方法 
     */
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        // 单词个数
        int num = words.length;
        // 单词长度
        int wordLength = words[0].length();
        // 窗口大小
        int windowLength = num * wordLength;

        // 存放所有单词以及应该出现的次数
        Map<String, Integer> wordsMap = new HashMap<>((int) (num / 0.75) + 1);
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int i = 0;
        // 只需要遍历到字符长度不满足窗口大小为止
        while (i <= s.length() - windowLength) {
            HashMap<String, Integer> curMap = new HashMap<>((int) (num / 0.75) + 1);

            // 每次移动一个单词
            for (int j = 0; j < num; j++) {
                // 第j个单词
                String curWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                // 出现不存在单词，直接退出循环
                if (!wordsMap.containsKey(curWord)) {
                    break;
                }
                curMap.put(curWord, curMap.getOrDefault(curWord, 0) + 1);
                // 出现超数量单词，直接退出循环
                if (curMap.get(curWord) > wordsMap.get(curWord)) {
                    break;
                }
            }

            // 如果两个map相等
            if(curMap.equals(wordsMap)){
                result.add(i);
            }
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        findSubstring2("barfoothefoobarman", new String[]{"foo", "bar"}).forEach(System.out::println);
    }
}
