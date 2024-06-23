package com.jidi.learn.leetcode.methodology.dynamicPlan;

/**
 * 63. 不同路径 II  https://leetcode.cn/problems/unique-paths-ii/description/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/6/23
 */
public class UniquePathsWithObstacles {


    /**
     * 动态规划
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        // (0,0)这个格子可能有障碍物
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;

        // 第一行只能往右走
        for (int i = 1; i < n; i++) {
            // 正好遇到障碍物或者前一个格子就已经不能通过
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        //  第一列只能往下走
        for (int i = 1; i < m; i++) {
            // 正好遇到障碍物或者前一个格子就已经不能通过
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 只有没有障碍阻挡才能继续前进
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
