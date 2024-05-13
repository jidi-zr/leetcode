package com.jidi.learn.leetcode.methodology.recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合  https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class LetterCombinations {

    String[] letters = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();

    StringBuilder stringBuilder = new StringBuilder();


    /**
     * 回溯
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        // 迭代处理
        this.backTracking(digits, 0);
        return res;
    }


    private void backTracking(String digits, int level) {
        // 层数与字符长度一致，添加到结果集
        if (level == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }

        // 获取当前数字代表的字符串
        String letter = letters[digits.charAt(level) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            stringBuilder.append(letter.charAt(i));
            // 递归调用
            this.backTracking(digits, level + 1);
            // 去除最后一位，继续比较
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }


    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23").stream().forEach(System.out::println);
    }

}
