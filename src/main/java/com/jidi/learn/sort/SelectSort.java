package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/7
 */
public class SelectSort {

    /**
     * 原生简单选择排序
     */
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // n个数总共要比较n-1轮
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录每次比较过程中最小值的下标，默认当前元素就是最小的
            int minIndex = i;

            // 默认前i个元素是有序的，需要继续比较后面的元素
            for (int j = i + 1; j < arr.length; j++) {
                // 如果发现了更小的元素
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 经过比较后，如果最小的元素不是当前元素，则交换位置
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }


    /**
     * 优化后的简单选择排序
     */
    public void selectionSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
            // 记录每次比较过程中最小值的下标，默认最左边就是最小的
            int min = left;
            // 记录每次比较过程中最大值的下标，默认最右边就是最大的
            int max = right;

            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }
            // 将最小值交换到 left 的位置
            if (min != left) {
                swap(arr, left, min);
            }

            // 如果最大值为left索引处，由于left索引处数据与min索引处数据交换了，此时要取min处索引的值
            if (max == left) {
                max = min;
            }

            // 将最大值交换到 right 的位置
            if (max != right) {
                swap(arr, right, max);
            }
        }
    }


    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] ints = {8, 7, 6, 1, 2, 3, 4, 5, 10, 11, 12};
        SelectSort selectSort = new SelectSort();
        selectSort.selectionSort2(ints);
        System.out.println(Arrays.toString(ints));
    }
}
