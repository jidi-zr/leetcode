package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. 区间列表的交集  https://leetcode.cn/problems/interval-list-intersections/description/
 * 示例 1：
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * <p>
 * 示例 2：
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/23
 */
public class IntervalIntersection {


    /**
     * 双指针
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        // 双指针
        int p1 = 0, p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            int[] arr1 = firstList[p1];
            int[] arr2 = secondList[p2];

            // 交集，左端点为最大的
            int left = Math.max(arr1[0], arr2[0]);
            // 交集，右端点为最小的
            int right = Math.min(arr1[1], arr2[1]);

            // 左端点小于等于右端点，属于一个合法的闭区间
            if (left <= right) {
                ans.add(new int[]{left, right});
            }

            // 两个区间右端点谁小，移动小区间的指针
            if (arr1[1] < arr2[1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
