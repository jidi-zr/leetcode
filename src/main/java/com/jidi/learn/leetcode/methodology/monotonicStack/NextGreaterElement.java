package com.jidi.learn.leetcode.methodology.monotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/6/23
 */
public class NextGreaterElement {



    /**
     * 单调栈 + map
     */
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        // 栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            // 如果当前元素大于栈顶元素，说明栈顶元素遇到了右边比它大的值。
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(stack.peek(), nums2[stack.pop()]);
            }
            // 把当前元素的下标入栈。
            stack.push(i);
        }


        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = map.getOrDefault(nums1[i], -1);
        }
        return answer;
    }

}
