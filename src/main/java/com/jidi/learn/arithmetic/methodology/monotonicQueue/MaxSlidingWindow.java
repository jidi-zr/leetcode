package com.jidi.learn.arithmetic.methodology.monotonicQueue;

import java.util.*;

/**
 * 239. 滑动窗口最大值  https://leetcode.cn/problems/sliding-window-maximum/description/
 * <p>
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值
 *
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * <p>
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/7
 */
public class MaxSlidingWindow {

    /**
     * 单调队列，解题思路查看：https://leetcode.cn/problems/sliding-window-maximum/solutions/1/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];

        // 初始化双端队列，存储元素的下标
        Deque<Integer> deque = new LinkedList<>();

        int i = 0;
        while (i < length) {
            // 1. 入
            // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
            // 直到队列为空或当前考察元素小于新的队尾元素
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            // 元素下标入队
            deque.addLast(i);

            // 2. 出
            // 当队首元素的下标小于滑动窗口左侧边界left时
            // 表示队首元素已经不在滑动窗口内，因此将其从队首移除
            if (deque.getFirst() < i - k + 1) {
                deque.removeFirst();
            }

            // 3、记录答案
            // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
            // 意味着窗口形成。此时队首元素就是该窗口内的最大值
            if (i + 1 >= k) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                result[i - k + 1] = nums[deque.getFirst()];
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(ints, 3)));
    }
}
