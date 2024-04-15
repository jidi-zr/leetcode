package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 数独  https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2f9gg/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int length = board.length;

        // 二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        // 表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int[][] line = new int[length][length];
        int[][] column = new int[length][length];
        int[][] cell = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 如果还没有填数字，直接跳过
                if (board[i][j] == '.') {
                    continue;
                }
                // num是当前格子的数字
                int num = board[i][j] - '0' - 1;

                // k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;

                // 如果当前数字对应的行和列以及单元格，只要一个有数字，说明冲突了，直接返回false。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0) {
                    return false;
                }
                // 表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }

}
