package com.jidi.learn.leetcode.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和  https://leetcode.cn/problems/4sum/
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/20
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        // 直接排除不满足条件的
        if (nums == null || length < 4) {
            return result;
        }

        // 排序
        Arrays.sort(nums);

        // 从头开始遍历直到倒数第四个元素，倒数的三个元素需要保留用来求和
        for (int i = 0; i < length - 3; i++) {
            // 从第二个数开始，重复数值直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果当前位置加上紧跟着的的三个数都要大于target，直接退出，因为后面的结果肯定只会更大
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //  如果当前位置加上最大的三个数都要小于于target，直接跳过当前元素，因为后面的元素还存在等于target的可能
            if ((long)nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }

            // 从当前元素的后面一个元素开始遍历直到倒数第三个元素，倒数的二个元素需要保留用来求和
            for (int j = i + 1; j < length - 2; j++) {
                // 从第二个数开始，重复数值直接跳过
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 如果当前位置加上紧跟着的的三个数都要大于target，直接退出，因为后面的结果肯定只会更大
                if((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 如果当前位置加上最大的三个数都要小于于target，直接跳过当前元素，因为后面的元素还存在等于target的可能
                if ((long)nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }

                // 初始化左右指针
                int left = j + 1;
                int right = length - 1;

                while (left < right) {
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    // 和大于target，右指针左移
                    if (sum > target) {
                        right--;
                    }
                    // 和小于target，左指针右移
                    else if (sum < target) {
                        left++;
                    }
                    // 和等于target，添加到集合，并且左右指针继续移动，寻找下一组值
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 左指针继续右移
                        left++;
                        // 去除重复元素
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        // 右指针继续左移
                        right--;
                        // 去除重复元素
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
