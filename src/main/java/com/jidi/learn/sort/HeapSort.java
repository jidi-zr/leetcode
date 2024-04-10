package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/8
 */
public class HeapSort {



    /**
     * 堆排序
     */
    public void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int len = arr.length;
        // 初始化大根堆
        buildMaxHeap(arr, len);

        // 从数组尾开始进行循环，每次找到待排序序列的最大值
        for (int i = len - 1; i > 0; i--) {
            // 交换堆顶和最后一个元素，即每次将剩余元素中的最大者放到最后面
            swap(arr, 0, i);
            // 重新调整堆顶节点成为大顶堆
            heapify(arr, 0, --len);
        }
    }


    /**
     * 构建大根堆
     */
    private void buildMaxHeap(int[] arr, int len) {
        // 非叶节点最大序号值为len/2
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }


    /**
     * 堆化
     */
    private void heapify(int[] arr, int parent, int len) {
        // 计算父节点的两个子节点
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        // max为父节点和子节点最大值的下标，默认父节点是最大值
        int max = parent;

        // 如果是叶节点就不用进行调整
        if (parent <= len / 2) {
            // 比较左右子节点和父节点的大小
            if (left < len && arr[left] > arr[max]) {
                max = left;
            }
            if (right < len && arr[right] > arr[max]) {
                max = right;
            }

            // 如果当前的最大值不是当前父节点，需要进行元素交换，
            if (max != parent) {
                swap(arr, parent, max);
                // 交换之后的子节点作为父节点时不一定是大根堆，需要重新建堆
                heapify(arr, max, len);
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
        int[] ints = new int[]{8, 7, 6, 1, 2, 3, 4, 5, 10, 11, 12};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }

}
