package com.jidi.learn.leetcode.methodology.window;

/**
 * 75. 颜色分类  https://leetcode.cn/problems/sort-colors/description/
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/6
 */
public class SortColors {


    /**
     * 三指针
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int left = 0, right = nums.length - 1, current = 0;
        while (current <= right) {
            // 为0交换，left跟current都要左移
            if (nums[current] == 0) {
                this.swap(nums, left++, current++);
            }
            // 为2交换，只移动right，因为current执行交换后的值可能为0，还需要继续判断
            else if (nums[current] == 2) {
                this.swap(nums, right--, current);
            }
            // 为1，不交换，移动current
            else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
