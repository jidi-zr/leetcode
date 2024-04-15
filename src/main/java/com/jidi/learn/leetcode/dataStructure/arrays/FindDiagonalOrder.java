package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 对角线遍历 https://leetcode.cn/leetbook/read/array-and-string/cuxq3/
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]] ， mat = [[1,2],[3,4]]
 * 输出：[1,2,4,7,5,3,6,8,9]， [1,2,3,4]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class FindDiagonalOrder {

    /**
     * 把下标和相同的放到同一个链表（对角线上的元素的坐标和一致），然后反转和为偶数的链表。
     * 参考 https://leetcode.cn/problems/diagonal-traverse/solutions/1774730/by-inix-omrp/
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        // 计算列跟行
        int rows = mat.length;
        int cols = mat[0].length;

        // 存放结果
        int[] result = new int[rows * cols];

        // 存放和
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(2 * (rows + cols));

        // 对于每个坐标和，添加对应元素到链表
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 存储下标和
                int sum = i + j;
                // 如果map中不存在，先初始化
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }

                // 将当前的元素添加到集合中
                map.get(sum).add(mat[i][j]);
            }
        }

        int index = 0;
        // 依次取出保存的链表，如果坐标和是偶鼠，需要先反转元素
        for (int i = 0; i <= rows + cols - 2; i++) {
            ArrayList<Integer> arrayList = map.get(i);
            // 偶数，需要反转
            if (i % 2 == 0) {
                Collections.reverse(arrayList);
            }
            for (int j = 0; j < arrayList.size(); j++) {
                result[index++] = arrayList.get(j);
            }
        }
        return result;
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 排序
        Arrays.sort(strs);

        // 依次进行比较，如果不是数组元素前缀，字符串移除最后一个字符后再进行比较
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 不是公共前缀
            while (strs[i].indexOf(s) != 0) {
                // 去掉最后面的字符
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
