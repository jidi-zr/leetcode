package com.jidi.learn.leetcode.methodology.dynamicPlan;

/**
 * 62. 不同路径  https://leetcode.cn/problems/unique-paths/description/
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/6/23
 */
public class UniquePaths {


    /**
     * 动态规划
     * 机器人只能向下和向右移动，不能往其他方向移动，用dp[i][j]表示到坐标(i，j)这个格内有多少条不同的路径，所以最终的答案就是求dp[m-1][n-1]。
     * 因为只能从上面或左边走过来，所以递推公式是：dp[i][j] = dp[i-1][j] + dp[i][j-1]。
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 第一行只能往右走
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 第一列只能往下走
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
