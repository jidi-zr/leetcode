package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 搜索插入位置 https://leetcode.cn/leetbook/read/array-and-string/cxqdh/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class SearchInsert {

    /**
     * 逐个进行比较查找
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 要插入的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 值相等，找到索引直接返回
            if (nums[i] == target) {
                return i;
            }
            // 位置右移
            else if (nums[i] < target) {
                index++;
            }
        }
        return index;
    }


    /**
     * 二分法查找
     */
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // 找到直接返回
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // 没找到，返回插入位置
        return low;
    }
}
