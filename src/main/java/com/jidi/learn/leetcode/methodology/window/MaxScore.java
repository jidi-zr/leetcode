package com.jidi.learn.leetcode.methodology.window;

/**
 * 1423. 可获得的最大点数  https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/description/
 * <p>
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * <p>
 * 示例 1：
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * <p>
 * 示例 2：
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * <p>
 * 示例 3：
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * <p>
 * 示例 4：
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * <p>
 * 示例 5：
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/2
 */
public class MaxScore {


    /**
     * 滑动窗口，逆向法
     * <p>
     * 拿走 k 张，剩下 n−k 张，由于拿走的点数和 + 剩下的点数和 = 所有点数和 = 常数，所以为了最大化拿走的点数和，应当最小化剩下的点数和。
     * 由于只能从开头或末尾拿牌，所以最后剩下的牌必然是连续的。
     * 问题变成：计算长为 n−k 的连续子数组和的最小值。
     */
    public static int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;

        // 计算总和
        int total = 0;
        for (int i : cardPoints) {
            total += i;
        }
        // 如果拿走全部元素，则最大化的点数和就是总和
        if (length == k) {
            return total;
        }

        // 初始化窗口
        int left = 0, right = 0;
        // 滑动窗口累加和
        int sum = 0;
        // 滑动窗口最小的累加和
        int min = Integer.MAX_VALUE;

        while (right < length) {
            sum += cardPoints[right];
            // 窗口元素个数大于等于length-k，需要移动左指针，收缩窗口，同时更新窗口统计信息
            if (right - left + 1 >= length - k) {
                min = Math.min(min, sum);
                sum -= cardPoints[left++];
            }
            // 不断的右移右指针，扩大窗口
            right++;
        }
        return total - min;
    }


    /**
     * 正向法，
     * 答案等于如下结果的最大值：
     * 前 kkk 个数的和。
     * 前 k−1 个数以及后 1 个数的和。
     * 前 k−2 个数以及后 2 个数的和。
     * ……
     * 前 2 个数以及后 k−2 个数的和。
     * 前 1 个数以及后 k−1 个数的和。
     * 后 k 个数的和。
     */
    public static int maxScore2(int[] cardPoints, int k) {
        int length = cardPoints.length;
        int sum = 0;
        // 计算前k个元素的和
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int result = sum;
        // 要取出全部元素
        if (length == k) {
            return result;
        }

        // 依次使用k-i位置的元素替换length-i位置的元素
        // 因为只能从两边取元素，所以要从里往外替换元素
        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[length - i] - cardPoints[k - i];
            result = Math.max(result, sum);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(maxScore2(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }
}
