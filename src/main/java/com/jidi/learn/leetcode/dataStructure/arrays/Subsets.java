package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集  https://leetcode.cn/problems/subsets/description/
 * 给你一个整数数组 nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2025/3/9
 */
public class Subsets {

    /**
     * 迭代法，解题思路参考：https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        // 加入空数组
        result.add(Collections.emptyList());
        for (Integer num : nums) {
            int size = result.size();
            // 遍历已添加的子集元素，将当前遍历的元素添加到子集中
            for (int i = 0; i < size; i++) {
                List<Integer> tempList = new ArrayList<>(result.get(i));
                tempList.add(num);
                result.add(tempList);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        System.out.println(result);
    }
}
