package com.jidi.learn.leetcode.methodology.window;

/**
 * 1052. 爱生气的书店老板  https://leetcode.cn/problems/grumpy-bookstore-owner/description/
 * <p>
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * 示例 2：
 * 输入：customers = [1], grumpy = [0], minutes = 1
 * 输出：1
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/4
 */
public class MaxSatisfied {


    /**
     * 先将所有老板不生气的时刻，所对应的顾客数量统计出来，然后，再使用滑动窗口计算生气的时间段内顾客的数量，将两者相加，就是最后的答案
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int length = customers.length;

        // 先统计不生气的时刻，顾客的数量
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }

        // 初始化双指针
        int left = 0, right = 0;

        // 记录窗口中生气时刻的顾客数量
        int count = 0;
        int maxCount = 0;

        // 统计生气时，最大的顾客数量
        while (right < length) {
            if (grumpy[right] == 1) {
                count += customers[right];
            }
            while (right - left + 1 >= minutes) {
                maxCount = Math.max(maxCount, count);
                if (grumpy[left] == 1) {
                    count -= customers[left];
                }
                left++;
            }
            right++;
        }
        return sum + maxCount;
    }


    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
