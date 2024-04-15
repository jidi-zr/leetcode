package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间 https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        // 先进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 存放合并后的区间
        List<int[]> list = new ArrayList<>();

        // 临时存放合并区间
        int[] merge = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 如果右端点大于等于后面元素左端点，合并区间
            if (merge[1] >= intervals[i][0]) {
                // 取最大的作为新的右端点的值
                merge[1] = Math.max(merge[1], intervals[i][1]);
            }
            // 无需合并区间
            else {
                list.add(merge);
                // 不断移动要比较的区间
                merge = intervals[i];
            }
        }
        // 处理最后一个区间
        list.add(merge);
        return list.toArray(new int[list.size()][2]);
    }

}
