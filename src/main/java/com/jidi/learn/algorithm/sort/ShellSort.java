package com.jidi.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/7
 */
public class ShellSort {

    public void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int len = arr.length;
        // 区间依次递减
        for (int step = len / 2; step > 0; step /= 2) {
            // 使用插入排序，直接插入排序可以看成是希尔排序step=1的特殊场景
            // 每一组从第二个元素开始，默认每组的第一个元素是排好序的
            for (int i = step; i < len; i++) {
                // 待插入的元素
                int current = arr[i];
                // 从每个分组已排序的列表最后一个元素（即分组后当前待插入元素的前一个元素）开始进行比较
                for (int j = i - step; j >= 0; j -= step) {
                    // 如果待插入的元素值小于已排序列表当前比较的元素，交换两者位置，然后继续跟每一组已排序的列表中下一个元素比较
                    if (arr[j] > current) {
                        swap(arr, j + step, j);
                    }
                }
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
        ShellSort insertSort = new ShellSort();
        insertSort.shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
