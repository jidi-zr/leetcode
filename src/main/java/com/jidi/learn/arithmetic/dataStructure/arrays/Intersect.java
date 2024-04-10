package com.jidi.learn.arithmetic.dataStructure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 两个数组的交集 https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2y0c2/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/29
 */
public class Intersect {

    /**
     * 先对两个数组进行排序，然后使用两个指针，分别指向两个数组开始的位置。
     * 如果两个指针指向的值相同，说明这个值是他们的交集，就把这个值加入到集合list中，然后两个指针在分别往后移一步。
     * 如果两个指针指向的值不同，那么指向的值相对小的往后移一步，相对大的先不动，然后再比较
     * 一直重复上面的操作，直到其中一个指针不能再移动为止，最后再把集合list转化为数组即可
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // 双指针
        int left = 0;
        int right = 0;

        List<Integer> list = new ArrayList<>();
        while (left < nums1.length && right < nums2.length) {
            // 如果两个值相等添加到集合，两个指针继续往后移动
            // 如果值不相等，值小指针的往后移动
            if (nums1[left] == nums2[right]) {
                list.add(nums1[left]);
                left++;
                right++;
            } else if (nums1[left] < nums2[right]) {
                left++;
            } else {
                right++;
            }
        }

        //把list转化为数组
        int index = 0;
        int[] result = new int[list.size()];
        for (int temp : list) {
            result[index++] = temp;
        }
        return result;
    }


    /**
     * 使用map来解决，具体操作如下
     * 遍历nums1中的所有元素，把它存放到map中，其中key就是nums1中的元素，value就是这个元素在数组nums1中出现的次数。
     * 遍历nums2中的所有元素，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后对应的value要减1。
     */
    public int[] intersec2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 先把数组nums1的所有元素都存放到map中，其中key是数组中的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        // 然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        // 把list转化为数组
        int index = 0;
        int[] result = new int[list.size()];
        for (int temp : list) {
            result[index++] = temp;
        }
        return result;

    }
}
