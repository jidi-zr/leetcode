package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.Arrays;

/**
 * 移动0 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2ba4i/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class MoveZeroes {

    /**
     * 把非0的往前挪，挪完之后，后面的就都是0了，然后在用0覆盖后面的
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将不是0的元素挪到前面
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // 从index元素开始，都是0
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 使用双指针
     */
    public void moveZeroe2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 初始化快慢指针
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // 只要不是0，就交换两个位置的值
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow++] = temp;
            }
            fast++;
        }
    }


    public static int[] canSeePersonsCount(int[] heights) {
        if (heights == null || heights.length == 1) {
            return new int[]{0};
        }

        int[] result = new int[heights.length];
        result[result.length - 1] = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            int temp = 0;
            int j = i + 1;

            while (j < heights.length && heights[i] >= heights[j]) {
                temp++;
                j++;
            }
            result[i] = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9})));
    }

}
