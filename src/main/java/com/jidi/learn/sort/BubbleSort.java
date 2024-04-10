package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/1
 */
public class BubbleSort {


    /**
     * 原生冒泡排序
     */
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 外层循环，数组长度为 n，循环次数为 n-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环，循环次数为 n-i-1，找到一个最大值放在，arr[n-1-1]的位置
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 比较相邻的两个值，把相对大的值放在数组下标大的地方
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }


    /**
     * 减少外层循环
     */
    public static int[] bubbleSortByReduceOuterLoop(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 是否发生过数据交换的标志
        boolean flag = true;

        // 外层循环，数组长度为 n，循环次数为 n-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 未发生过数据交换，直接退出循环
            if (flag == false) {
                break;
            }

            // 每次循环前默认不会发生数据交换
            flag = false;

            // 内层循环，循环次数为 n-i-1，找到一个最大值放在，arr[n-1-1]的位置
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 比较相邻的两个值，把相对大的值放在数组下标大的地方
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 发生数据交换，改变标志
                    flag = true;
                }
            }
        }
        return arr;
    }


    /**
     * 减少内层循环
     */
    public static int[] bubbleSortByReduceInnerLoop(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 上一次内层循环上界值，默认是最后一个
        int top = arr.length - 1;

        // 外层循环，数组长度为 n，循环次数为 n-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录上一次内层循环时最后一次交换的位置
            int last = 0;

            // 内层循环，循环次数为 n-i-1，找到一个最大值放在，arr[n-1-1]的位置
            for (int j = 0; j < top; j++) {
                // 比较相邻的两个值，把相对大的值放在数组下标大的地方
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    last = j;
                }
            }
            top = last;
        }
        return arr;
    }


    /**
     * 减少内外层循环
     */
    public static int[] bubbleSortByReduceOuterAndInnerLoop(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        // 是否发生过数据交换的标志
        boolean flag = true;

        // 内层循环上界
        int top = arr.length - 1;

        // 外层循环，数组长度为 n，循环次数为 n-1
        for (int i = 0; i < arr.length - 1; i++) {
            // 未发生过数据交换，直接退出循环
            if (flag == false) {
                break;
            }

            // 每次循环前默认不会发生数据交换
            flag = false;
            // 每次循环前重置内层循环上界
            int last = 0;

            // 内层循环，循环次数为 n-i-1，找到一个最大值放在，arr[n-1-1]的位置
            for (int j = 0; j < top; j++) {
                // 比较相邻的两个值，把相对大的值放在数组下标大的地方
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 发生数据交换，改变标志
                    flag = true;
                    // 记录内层循环上界
                    last = j;
                }
            }
            top = last;
        }
        return arr;
    }


    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int[] ints = bubbleSortByReduceOuterAndInnerLoop(new int[]{8, 7, 6, 1, 2, 3, 4, 5, 10, 11, 12});
        System.out.println(Arrays.toString(ints));
    }
}
