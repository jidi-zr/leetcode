package com.jidi.learn.leetcode.methodology.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度  https://leetcode.cn/problems/daily-temperatures/description/
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/6/23
 */
public class DailyTemperatures {


    /**
     * 硬计算
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i] && answer[i] == 0) {
                    answer[i] = j - i;
                }
            }
        }
        return answer;
    }


    /**
     * 求下一个更大的元素，最常用的思路就是使用单调栈
     * 遍历数组中的所有元素：
     * 1，如果当前元素比栈顶元素小，就把当前元素压栈。
     * 2，如果当前元素比栈顶元素大，说明栈顶元素遇到了右边第一个比它大的值，栈顶元素出栈，计算他俩之间的距离。如果当前元素比新的栈顶元素还大，就继续出栈……
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        // 栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 如果当前元素大于栈顶元素，说明栈顶元素遇到了右边比它大的值。
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                answer[stack.peek()] = i - stack.pop();
            }
            // 把当前元素的下标入栈。
            stack.push(i);
        }
        return answer;
    }
}
