package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 88. 合并两个有序数组  https://leetcode.cn/problems/merge-sorted-array/description/
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/23
 */
public class MergeTwoArrays {


    /**
     * 直接合并后排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 追加元素
        for (int i = m, j = 0; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        // 排序
        this.insertSort(nums1);
    }


    /**
     * 直接插入排序
     */
    private void insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // 默认第一个元素是有序的，从第二个元素开始插入
        for (int i = 1; i < nums.length; i++) {
            // 当前要插入的元素
            int current = nums[i];
            // 从已排序的列表最后一个元素（即当前待插入元素的前一个元素）开始进行比较，直到找到一个比当前元素要小的元素
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > current) {
                    this.swap(nums, j + 1, j);
                }
            }
        }
    }


    /**
     * 交换元素
     */
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
