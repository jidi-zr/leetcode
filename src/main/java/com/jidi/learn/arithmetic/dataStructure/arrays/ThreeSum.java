package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 https://leetcode.cn/problems/3sum/
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * <p>
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/20
 */
public class ThreeSum {


    /**
     * 双指针
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int length = nums.length;

        // 直接排除不满足条件的
        if (nums == null || length < 3) {
            return result;
        }

        // 先排序
        Arrays.sort(nums);

        // 从头开始遍历到倒数第三个元素
        for (int i = 0; i < length - 2; i++) {
            // 从第二个元素开始判断，如果跟前面的元素值一样，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 优化1，如果前三个数相加都已经大于0了，后面的就不用再继续遍历了，直接退出循环
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            // 优化2，如果当前位置的数加上最后面两个位置的数之和已经小于0了，就直接跳过当前位置，从下一个位置开始寻找
            if (nums[i] + nums[length - 1] + nums[length - 2] < 0) {
                continue;
            }

            // 初始化双指针，左指针要从当前元素后面一个元素开始
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 三数之和大于0，右指针左移
                if (sum > 0) {
                    right--;
                }
                // 三数之和小于0，左指针右移
                else if (sum < 0) {
                    left++;
                }
                // 三数之和为0，添加到集合，并且左右指针继续移动
                else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 左指针继续向右移动
                    left++;
                    // 如果出现重复的值，跳过重复的值
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 右指针继续向左移动
                    right--;
                    // 如果出现重复的值，跳过重复的值
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
