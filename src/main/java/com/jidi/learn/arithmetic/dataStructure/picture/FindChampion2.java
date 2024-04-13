package com.jidi.learn.arithmetic.dataStructure.picture;

/**
 * 2924. 找到冠军 II  https://leetcode.cn/problems/find-champion-ii/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/13
 */
public class FindChampion2 {


    /**
     * 冠军队伍的特点是没有其他队伍击败它，即其入度为 0。因此，我们可以通过统计每个队伍的入度来找到可能的冠军队伍。
     */
    public int findChampion(int n, int[][] edges) {
        // 初始所有队伍入度都是0
        int[] statistics = new int[n];
        for (int[] edge : edges) {
            // 统计每个队伍的入度：将被击败的队伍的入度加一
            statistics[edge[1]]++;
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            // 可能是冠军
            if (statistics[i] == 0) {
                // 如果之前已经找到过一个可能的冠军，则返回 -1（因为存在多个可能的冠军）
                if (champion != -1) {
                    return -1;
                }
                // 更新可能的冠军队伍编号
                champion = i;
            }
        }
        return champion;
    }
}
