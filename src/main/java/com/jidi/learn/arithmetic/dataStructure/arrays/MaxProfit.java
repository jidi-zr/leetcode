package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 买卖股票的最佳时机 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/27
 */
public class MaxProfit {

    // 求上升区间的高度和
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int total = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            int num = prices[i + 1] - prices[i];
            if (num > 0) {
                total += num;
            }
        }
        return total;
    }
}
