package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/12
 */
public class RadixSort {


    /**
     * 基数排序
     */
    private static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 获取最大值的位数
        int maxDigit = getMaxDigit(arr);

        // 申请所需要的内存空间
        int[][] bucket = new int[10][arr.length - 1];
        int[] elementCount = new int[10];

        // 除数
        int dev = 1;

        // 循环最大值位数次
        for (int i = 0; i < maxDigit; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 每次循环得到指定位数上的值
                int element = arr[j] / dev % 10;
                bucket[element][elementCount[element]] = arr[j];
                elementCount[element]++;
            }
            //  依次把数据从bucket里面拿出来，然后依次填回arr数组里面里面。elementCount置零
            int index = 0;
            for (int j = 0; j < elementCount.length; j++) {
                if (elementCount[j] != 0) {
                    for (int k = 0; k < elementCount[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                elementCount[j] = 0;
            }
            dev *= 10;
        }
    }


    /**
     * 获取数组最大元素的位数
     */
    private static int getMaxDigit(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return getLength(max);
    }


    /**
     * 获取一个整数的位数
     */
    private static int getLength(long num) {
        int count = 1;
        if (Math.abs(num) < 10) {
            return count;
        }
        while (num / 10 != 0) {
            count++;
            num /= 10;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] ints = {389, 12, 3, 36, 66, 89, 13, 30};
        radixSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
