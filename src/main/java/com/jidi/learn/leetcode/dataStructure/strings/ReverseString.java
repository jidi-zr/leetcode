package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 反转字符串  https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhbqj/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null || s.length == 1) {
            return;
        }

        // 双指针
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // 只有当值不相等的时候才交换
            if (s[left] != s[right]) {
                swap(s, left, right);
            }
            // 每一次比较之后，移动指针
            left++;
            right--;
        }
    }

    /**
     * 交换数组元素
     */
    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
