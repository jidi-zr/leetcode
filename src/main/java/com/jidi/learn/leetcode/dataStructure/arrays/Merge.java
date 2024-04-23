package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间 https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        // 对二维数组按照第一列升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 存放合并后的区间
        List<int[]> list = new ArrayList<>();
        // 临时存放合并区间，默认为第一组二维数组的值
        int[] merge = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // 如果第一个数组的右端点大于等于下一个数组的左端点，做说明两个数组有所交集
            if (merge[1] >= intervals[i][0]) {
                // 取最大的值作为新的右端点的值
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
