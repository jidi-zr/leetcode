package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 https://leetcode.cn/leetbook/read/array-and-string/cuj3m/
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/17
 */
public class YangHuiSanJiao1 {

    /**
     * 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // 有多少层就遍历多少次
        for (int i = 0; i < numRows; i++) {
            // 存储每一层的数据
            List<Integer> row = new ArrayList<>();

            // 每一层有i+1个数
            for (int j = 0; j <= i; j++) {
                // 如果位于两边直接为1
                if (j == 0 || j == i) {
                    row.add(1);
                }
                // 不是两边的数，值等于上一层的两数之和
                else {
                    // 获取上一层数
                    List<Integer> top = result.get(i - 1);
                    // 获取上一层相同位置之前的数
                    Integer front = top.get(j - 1);
                    // 获取上一层相同位置的数
                    Integer same = top.get(j);
                    row.add(front + same);
                }
            }
            // 每一层处理完之后添加到结果集中
            result.add(row);
        }
        return result;
    }


    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // 有多少层就遍历多少次
        for (int i = 0; i < numRows; i++) {
            // 存储每一层的数据
            List<Integer> row = new ArrayList<>();

            // 每一层有i+1个数
            for (int j = i; j >= 0; j--) {
                // 如果位于两边直接为1
                if (j == 0 || j == i) {
                    row.add(1);
                }
                // 不是两边的数，值等于上一层的两数之和
                else {
                    // 获取上一层数
                    List<Integer> top = result.get(i - 1);
                    // 获取上一层相同位置之前的数
                    Integer front = top.get(j - 1);
                    // 获取上一层相同位置的数
                    Integer same = top.get(j);
                    row.add(front + same);
                }
            }
            // 每一层处理完之后添加到结果集中
            result.add(row);
        }
        return result;
    }


}
