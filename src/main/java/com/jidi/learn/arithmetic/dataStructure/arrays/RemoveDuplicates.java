package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.Objects;

/**
 * 删除排序数组中的重复项 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2gy9m/
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/27
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            // 如果右指针指向的值等于左指针指向的值，左指针不动
            // 如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }


    public int removeDuplicates2(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            // 如果右指针指向的值等于左指针指向的值，左指针不动
            // 如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针
            if (nums[left] != nums[right]) {
                // 优化，对于没有一个重复元素的数组，不需要每次都复制
                if (right - left > 1) {
                    nums[left + 1] = nums[right];
                }
                left++;
            }
            right++;
        }
        return left + 1;
    }

}
