package com.jidi.learn.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/10
 */
public class MergeSort {


    /**
     * 原生归并排序
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 归并排序
        // sort(arr, 0, arr.length - 1);
        sort3(arr, 0, arr.length - 1);
    }


    /**
     * 递归排序
     *
     * @param arr   待排序数组
     * @param left  数组左下标
     * @param right 数组右下标
     */
    public static void sort(int[] arr, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }

        // 获取中间元素
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        // 合并数组元素
        merge(arr, left, mid, right);
    }


    /**
     * 使用插入排序优化递归深度的归并排序
     *
     * @param arr   待排序的数组
     * @param left  待排序数组左下标
     * @param right 待排序数组右下标
     */
    public static void sort2(int[] arr, int left, int right) {
        // 当拆分到数组长度小于10的时候直接使用插入排序
        if (right - left < 10) {
            insertSort(arr, left, right);
            return;
        }

        // 获取中间元素
        int mid = left + ((right - left) >> 1);
        sort2(arr, left, mid);
        sort2(arr, mid + 1, right);

        // 合并数组元素
        merge(arr, left, mid, right);
    }


    /**
     * 直接插入排序
     *
     * @param arr   待排序的数组
     * @param left  待排序数组左下标
     * @param right 待排序数组右下标
     */
    public static void insertSort(int[] arr, int left, int right) {
        // 第一个数默认是有序的，从第二个数开始插入
        for (int i = left + 1; i <= right; i++) {
            int current = arr[i];
            // 从已排序的列表最后一个元素（即当前待插入元素的前一个元素）开始进行比较
            for (int j = i - 1; j >= left; j--) {
                if (arr[j] > current) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    // 交换元素
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }




    /**
     * 减少合并次数的归并排序
     *
     * @param arr   待排序的数组
     * @param left  待排序数组左下标
     * @param right 待排序数组右下标
     */
    public static void sort3(int[] arr, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }

        // 获取中间元素
        int mid = left + ((right - left) >> 1);
        sort(arr, left, mid);
        sort(arr, mid + 1, right);

        // 如果分完组后，左边的最大值小于右边的最小值可以直接退出
        if(arr[mid] <= arr[mid+1]){
            return;
        }

        // 合并数组元素
        merge(arr, left, mid, right);
    }



    /**
     * 合并数组元素（基于临时数组实现）
     *
     * @param arr   待排序数组
     * @param left  数组左下标
     * @param mid   数组中间元素下标
     * @param right 数组右下标
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // 生成一个临时数组
        int[] temp = new int[right - left + 1];

        // 临时数组元素下标
        int index = 0;
        // 左指针
        int i = left;
        // 右指针
        int j = mid + 1;

        // 左右指针不越界是循环条件
        while (i <= mid && j <= right) {
            // 谁小谁先放进临时数组
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        // 此时两个数组有一个已经遍历完毕，直接把剩下的元素全部放入临时数组
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }

        // 将临时数组中的元素复制到原数组对应位置
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }


    public static void main(String[] args) {
        int[] ints = new int[]{8, 7, 6, 1, 2, 3, 4, 5, 10, 11, 12};
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
