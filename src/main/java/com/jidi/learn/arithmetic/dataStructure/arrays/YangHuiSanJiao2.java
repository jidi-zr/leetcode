package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角 https://leetcode.cn/leetbook/read/array-and-string/ctyt1/
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/18
 */
public class YangHuiSanJiao2 {

    /**
     * 对第i+1行的计算仅用到了第i行的数据，因此可以使用滚动数组的思想优化空间复杂度
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = null;

        // 有多少层遍历多少次
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            // 每一层有i+1个数
            for (int j = 0; j <= i; j++) {
                // 是两边的数直接赋值1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 获取上一层集合两数之和
                    row.add(result.get(j - 1) + result.get(j));
                }
            }
            // 每遍历一层，就将本层的元素保存
            result = row;
        }
        return result;
    }


    /**
     * 倒推法
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        // 都初始化为1
        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }
        // 层数小于2，元素都是1
        if (rowIndex < 2) {
            return result;
        }

        // 外层循环控制计算的次数
        for (int i = 1; i < rowIndex; i++) {
            // 每行是从后向前计算，以免产生覆盖
            for (int j = i; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }
        return result;
    }


    /**
     * 倒推法优化
     */
    public static List<Integer> getRow3(int rowIndex) {
        int length = rowIndex + 1;
        Integer[] array = new Integer[length];

        // 有多少层遍历多少次
        for (int i = 0; i < length; i++) {
            // 每层从后向前挨个处理数据
            for (int j = i; j >= 0; j--) {
                // 两边直接为1
                if (j == 0 || j == i) {
                    array[j] = 1;
                }
                // 不是两边的数，值等于上一层的两数之和
                else {
                    array[j] = array[j - 1] + array[j];
                }
            }
        }
        return Arrays.asList(array);
    }


}
