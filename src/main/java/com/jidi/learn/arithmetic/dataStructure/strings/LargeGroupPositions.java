package com.jidi.learn.arithmetic.dataStructure.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. 较大分组的位置  https://leetcode.cn/problems/positions-of-large-groups/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/13
 */
public class LargeGroupPositions {

    /**
     * 双指针
     */
    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int len = s.length();
        int basicLen = 3;
        if (s == null || len < basicLen) {
            return result;
        }

        /**
         * 定义双指针
         */
        int left = 0, right = 1;
        while (right < len) {
            // 右指针不断移动直到元素不相等
            while (right < len && s.charAt(left) == s.charAt(right)) {
                right++;
            }
            // 满足较大分组进行记录
            if (right - left >= basicLen) {
                // 此处右指针的值需要减一才是正确的位置
                result.add(Arrays.asList(left, right - 1));
            }
            // 继续比较下一个
            left = right++;
        }
        return result;
    }

    public static void main(String[] args) {
        largeGroupPositions("abcdddeeeeaabbbcd").forEach(it -> {
            System.out.println();
            it.forEach(System.out::print);
        });
    }
}
