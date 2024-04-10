package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 旋转图像  https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhhkv/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class RotatePic {

    /**
     * 1、先上下进行旋转；
     * 2、再沿着对角线进行旋转
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        // 上下旋转
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - 1 - i];
            matrix[length - 1 - i] = temp;
        }

        // 对角线旋转
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
