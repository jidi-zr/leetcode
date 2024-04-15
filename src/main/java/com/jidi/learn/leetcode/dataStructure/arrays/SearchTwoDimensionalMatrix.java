package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 240. 搜索二维矩阵 II  https://leetcode.cn/problems/search-a-2d-matrix-ii/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/9
 */
public class SearchTwoDimensionalMatrix {


    /**
     * 嵌套for循环，暴力破解
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int i : row) {
                if (target == i) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Z 字形查找  https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2361487/240-sou-suo-er-wei-ju-zhen-iitan-xin-qin-7mtf/
     * 从左下角开始查找，如果查找的值小于target，下一步就往右边找，如果查找的值大于target，下一步就往上边找。
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // 从矩阵左下角开始搜索
        // 行
        int row = matrix.length - 1;
        // 列
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            // 找到就直接返回
            if (matrix[row][col] == target) {
                return true;
            }
            // 如果查找的值小了，下一步往上找
            else if (target < matrix[row][col]) {
                row--;
            }
            // 如果查找的值大了，下一步往右找
            else if (target > matrix[row][col]) {
                col++;
            }
        }
        return false;
    }
}
