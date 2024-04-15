package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.Arrays;

/**
 * 数组拆分 https://leetcode.cn/leetbook/read/array-and-string/c24he/
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/14
 */
public class ArrayPairSum {

    /**
     * 假设排完序的结果为 a1<=b1<=a2<=b2<=...<=an<=bn
     * 那么a1应该跟谁一组呢？
     *
     * a1作为全局最小值，无论跟谁一组a1都会被累加进答案，相反，a1的搭档会被永久排除。
     * 既然如此，莫不如排除一个较小的数，即给a1找一个“最小的搭档”b1。
     *
     * 当a1、b1被处理之后，a2同理分析。
     * 所以，最终选择a1,a2,...,an会得到最好的结果。
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
