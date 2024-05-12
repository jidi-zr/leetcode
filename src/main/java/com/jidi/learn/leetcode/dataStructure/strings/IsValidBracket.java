package com.jidi.learn.leetcode.dataStructure.strings;

import java.util.Stack;

/**
 * 20. 有效的括号  https://leetcode.cn/problems/valid-parentheses/description/
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class IsValidBracket {


    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 如果是左括号，将对应的右括号入栈
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            }
            // 是右括号，从栈顶取出元素进行比较
            else {
                // 栈为空，左右括号数量不一样，返回false
                // 从栈顶取出元素跟当前元素不一样，返回false
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }
        // 栈为空，左右括号数量匹配，否则数量不匹配
        return stack.isEmpty();
    }
}
