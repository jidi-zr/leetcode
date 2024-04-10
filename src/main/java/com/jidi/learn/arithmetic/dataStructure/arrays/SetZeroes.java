package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 零矩阵 https://leetcode.cn/leetbook/read/array-and-string/ciekh/
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 输入：
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 * 输出：
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class SetZeroes {

    /**
     * 暴力求解 找到为零的地方记录下来 然后遍历所在行和列，都设置为0
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        // 记录行跟列是否为0
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        // 先找到为0的元素的横坐标跟纵坐标
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // 再遍历，将对应坐标上的值归0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (column[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
