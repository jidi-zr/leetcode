package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.HashMap;

/**
 * 两数之和 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2jrse/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class TwoSum {


    /**
     * 暴力双循环破解
     */
    public int[] twoSum(int[] nums, int target) {
        int[] resutl = new int[2];

        Label:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 如果两个位置值相加等于target，跳出循环
                // 需要做i*j次加法运算
                if (nums[i] + nums[j] == target) {
                    resutl[0] = i;
                    resutl[1] = j;
                    break Label;
                }
            }
        }
        return resutl;
    }


    /**
     * 双循环暴力破解优化
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] resutl = new int[2];

        Label:
        for (int i = 0; i < nums.length; i++) {
            // 只用做i次减法计算
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                // 如果两个位置值相加等于target，跳出循环
                if (nums[j] == temp) {
                    resutl[0] = i;
                    resutl[1] = j;
                    break Label;
                }
            }
        }
        return resutl;
    }


    /**
     * 使用hash
     */
    public int[] twoSum3(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);

        for (int i = 0; i < nums.length; i++) {
            // 如果存在对应的key
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
