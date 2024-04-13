package com.jidi.learn.arithmetic.dataStructure.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2810. 故障键盘  https://leetcode.cn/problems/faulty-keyboard/description/?envType=daily-question&envId=2024-04-13
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/13
 */
public class FinalString {


    /**
     * 使用一个双端队列和一个布尔变量 flag 来维护答案：
     * 当遇到非 “i” 的字符时，如果 flag 为真，就在队列的开头添加字符，否则在队列的末尾添加字符；
     * 当遇到 “i” 时，将 flag 取反。
     */
    public static String finalString(String s) {
        if (s == null || s == "") {
            return "";
        }
        Deque<Character> deque = new ArrayDeque<>();
        boolean flag = true;
        for (Character c : s.toCharArray()) {
            if (c.equals('i')) {
                flag = !flag;
            } else {
                if (flag) {
                    deque.addFirst(c);
                } else {
                    deque.addLast(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (flag) {
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollLast());
            }
        } else {
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollFirst());
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(finalString("string"));
    }
}
