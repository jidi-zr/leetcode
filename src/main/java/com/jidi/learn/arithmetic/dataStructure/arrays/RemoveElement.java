package com.jidi.learn.arithmetic.dataStructure.arrays;

/**
 * 移除元素 https://leetcode.cn/leetbook/read/array-and-string/cwuyj/
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,3,0,4]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/14
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        // 快慢指针
        int slow = 0;
        int fast = 0;

        // 快指针不能越界
        while (fast < nums.length) {
            // 当快指针元素值不等于val时，将该元素放到慢指针所在位置，慢指针向右移动
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            // 快指针继续移动
            fast++;
        }
        return slow;
    }
}
