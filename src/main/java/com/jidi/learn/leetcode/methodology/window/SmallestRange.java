package com.cowinhealth.publichealth;

import java.util.*;

/**
 * 632. 最小区间 https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/description/
 * <p>
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * <p>
 * 示例 1：
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * <p>
 * 示例 2：
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/2/19
 */
public class SmallestRange {


    /**
     * 贪心算法+最小堆 参照视频：https://www.bilibili.com/video/BV1Qa4y1E7t3/?spm_id_from=333.337.search-card.all.click&vd_source=4dbb7ff502680cfc0e4c5b41de580a9e
     * 转换为找一个区间，囊括所有区间中的一个元素，并且该区间内元素的最大值跟最小值的差值要是最小的
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // 初始化区间为[0,0x7fffffff]
        int left = 0;
        int right = Integer.MAX_VALUE;
        int range = right - left;

        // 记录当前区间元素最大值
        int max = Integer.MIN_VALUE;
        // 区间个数
        int sections = nums.size();
        // 记录每个区间指针位置
        int[] points = new int[sections];

        // 定义优先级队列，保存区间下标，当前区间指针所指向的元素的值最小的区间优先级最高
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(points[index])));
        // 初始化优先级队列，将所有的区间根据每个区间默认指针指向的元素值大小从小到大进行排序
        for (int i = 0; i < sections; i++) {
            queue.offer(i);
            // 初始化为所有区间第一个元素中最大的值
            max = Math.max(max, nums.get(i).get(0));
        }

        // 不停的移动当前所有区间中区间指针所指向最小元素的区间的指针，直到有一个区间指针越界
        while (true) {
            // 取出当前保存最小元素的区间下标
            int minIndex = queue.poll();
            // 当前区间范围
            int currentRange = max - nums.get(minIndex).get(points[minIndex]);

            // 当前的区间范围更小，更新区间统计信息
            if (currentRange < range) {
                range = currentRange;
                left = nums.get(minIndex).get(points[minIndex]);
                right = max;
            }

            // 当前区间指针继续向后移动
            points[minIndex]++;
            // 当前区间已经到头了，直接退出
            if (points[minIndex] == nums.get(minIndex).size()) {
                break;
            }

            // 当前区间指针移动之后继续添加到优先级队列
            queue.offer(minIndex);
            // max 始终是各个区间指针所指向的最大元素值
            max = Math.max(max, nums.get(minIndex).get(points[minIndex]));
        }
        int[] result = new int[2];
        result[0] = right;
        result[1] = left;
        return result;
    }



    /**
     * 滑动窗口方案辅助类
     */
    class Pair {
        /**
         * 当前元素值
         */
        int num;

        /**
         * 当前元素所属区间下标
         */
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }

    }


    /**
     * 滑动窗口
     * 1、将所有元素都使用一个list存放
     * 2、在list中找到一个包含k个元素的区间
     */
    public int[] smallestRange2(List<List<Integer>> nums) {
        int[] result = new int[2];
        List<Pair> pairs = new ArrayList<>();
        // 记录滑动窗口中元素出现的次数
        Map<Integer, Integer> map = new HashMap<>(nums.size() * 2);

        // 初始化，将所有元素全都放到list中
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                pairs.add(new Pair(num, i));
            }
        }
        // 排序
        Collections.sort(pairs, Comparator.comparingInt(pair -> pair.num));

        // 初始化双指针
        int left = 0, right = 0;
        // 初始化区间范围
        int range = Integer.MAX_VALUE;
        // 初始化区间有效记录数
        int valid = 0;

        while (right < pairs.size()) {
            // 得到当前元素
            Pair pair = pairs.get(right);
            // 如果当前元素所在区间下标不在map中，初始化当前区间所含元素数为0，并且区间有效记录数+1
            if (!map.containsKey(pair.index)) {
                valid++;
                map.put(pair.index, 0);
            }
            map.put(pair.index, map.get(pair.index) + 1);

            // 当有效的区间记录数等于区间数，才能移动左指针缩小窗口
            while (valid == nums.size() && left <= right) {
                // 出现更小的区间，更新区间统计信息
                if (range > pairs.get(right).num - pairs.get(left).num) {
                    range = pairs.get(right).num - pairs.get(left).num;
                    result[0] = pairs.get(left).num;
                    result[1] = pairs.get(right).num;
                }

                // 移除左指针执行的元素，更新统计信息
                map.put(pairs.get(left).index, map.get(pairs.get(left).index) - 1);
                // 如果当前左指针指向的区间元素数为0，区间有效记录数-1并且从map中移除记录
                if (map.get(pairs.get(left).index) == 0) {
                    valid--;
                    map.remove(pairs.get(left).index);
                }
                left++;
            }
            right++;
        }
        return result;
    }

}
