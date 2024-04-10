package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 快速插入排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/7
 */
public class InsertSort {

    /**
     * 快速插入排序
     */
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 第一个元素默认是有序的，从第二个元素开始遍历
        for (int i = 1; i < arr.length; i++) {
            // 待插入的元素
            int current = arr[i];
            // 从已排序的列表最后一个元素（即当前待插入元素的前一个元素）开始进行比较
            for (int j = i - 1; j >= 0; j--) {
                // 如果待插入的元素值小于已排序列表当前比较的元素，交换两者位置，然后继续跟已排序的列表中下一个元素比较
                if (arr[j] > current) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }


    /**
     * 交换元素
     */
    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] ints = {8, 7, 6, 1, 2, 3, 4, 5, 10, 11, 12};
        InsertSort insertSort = new InsertSort();
        insertSort.insertionSort(ints);
        System.out.println(Arrays.toString(ints));
    }

}
