package com.jidi.learn.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/1/3
 */
public class QuickSort {


    /**
     * 快排
     */
    void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int key = leftAndRightPointer(a, left, right);
        // 左侧右侧区间再分别进行排序
        quickSort(a, left, key - 1);
        quickSort(a, key + 1, right);
    }


    /**
     * 优化递归深度的快排
     */
    void quickSort2(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        // 直接插入排序
        if (right - left <= 10) {
            insertionSort(a);
        } else {
            int key = leftAndRightPointer(a, left, right);
            // 左侧右侧区间再分别进行排序
            quickSort(a, left, key - 1);
            quickSort(a, key + 1, right);
        }
    }


    /**
     * 直接插入排序
     */
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 默认第一个元素是排好序的，从第二个元素开始插入
        for (int i = 1; i < arr.length; i++) {
            // 待插入的元素值
            int current = arr[i];
            // 待插入的元素值从后面依次跟排好序的列表元素比较
            for (int j = i - 1; j >= 0; j--) {
                // 如果待插入元素值小于当前比较的排好序的元素的值，则交换元素，继续进行下一个位置元素的比较
                if (arr[j] > current) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }


    /**
     * 三数取中，获取中间值的位置
     */
    int getMidIndex(int[] a, int left, int right) {
        // 取得中间位置
        int mid = left + (left - right) / 2;

        if (a[left] < a[mid]) {
            if (a[mid] < a[right]) {
                return mid;
            } else {
                if (a[left] < a[right]) {
                    return right;
                } else {
                    return left;
                }
            }
        }
        // a[left] > a[mid]
        else {
            if (a[right] < a[mid]) {
                return mid;
            } else {
                if (a[right] < a[left]) {
                    return right;
                } else {
                    return left;
                }
            }
        }
    }


    /**
     * 元素交换
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * <pre>
     * 挖坑法：
     *      1，任意选择一个数作为基准值;
     *      2，将基准值与首位元素进行交换;
     *      3，基准值所在的位置成为原始坑 index；
     *      4，先遍历右边，如果元素大于基准值--右指针左移，如果元素小于基准值--将该元素填入坑中，该元素本来的位置成为新的坑；
     *      5，再遍历左边，如果元素小于基准值--左指针右移，如果元素大于基准值--将该元素填入坑中，该元素本来的位置成为新的坑；
     *      6，直到左右指针重合，这时将基准值放在重合位置(最后一个坑)，此时，基准值左边的元素都小于基准值，基准值右边的元素都大于基准值，这一轮交换宣告结束。
     */
    int pothole(int[] a, int left, int right) {
        // 三数取中
        int mid = getMidIndex(a, left, right);

        // 把基准值放到left位置
        swap(a, mid, left);

        // 获取基准值
        int pivot = a[left];

        // 初始化坑的位置，初始坑在基准值的位置
        int index = left;

        // 左游标永远小于右游标，是遍历元素并发生元素变动的前提
        while (left < right) {
            // 先遍历右边
            // 如果元素大于基准值--右游标左移
            while (left < right && a[right] >= pivot) {
                right--;
            }
            // 跳出了循环，说明此时右指针所在元素小于基准值，那么将该元素填入坑中，该元素本来的位置成为新的坑
            a[index] = a[right];
            index = right;

            // 再遍历左边
            // 如果元素小于基准值--左游标右移
            while (left < right && (a[left] <= pivot)) {
                left++;
            }
            // 跳出了循环，说明此时的左游标所在元素大于基准值，那么将该元素填入坑中，该元素本来的位置成为新的坑；
            a[index] = a[left];
            index = left;
        }
        // 跳出了大循环，说明此时此刻左右指针是重合的，这时将基准值放在重合位置(最后一个坑)，
        a[index] = pivot;
        //  返回此时基准值的下标
        return index;
    }


    /**
     * <pre>
     * 前后指针法
     *      1，任意选择一个数作为基准值；
     *      2，将基准值与首位元素进行交换；
     *      3、基准值所在的位置记作 index，基准值记作 pivot；
     *      4、初始化两个指针prev和cur，分别从left和left + 1开始遍历数组；
     *      5、在遍历过程中，cur指针向右移动，扫描数组元素。当a[cur]小于pivot时，将prev指针右移一位，并交换a[prev]和a[cur]的值。这样，较小的元素就会被移动到prev的位置，而prev之前的元素都小于基准元素。
     *      6、最后，将基准元素a[index]移动到合适的位置，即将其与a[prev]交换。此时，数组被分为两部分：左边的元素小于基准元素，右边的元素大于等于基准元素，这一轮交换宣告结束。
     */
    int frontAndRearPointer(int[] a, int left, int right) {
        // 三数取中
        int mid = getMidIndex(a, left, right);
        // 把基准值放到left位置
        swap(a, mid, left);

        // 基准值的位置
        int index = left;
        // 获取基准值
        int pivot = a[index];

        // 前后指针
        int prev = left;
        int cur = left + 1;

        // 后指针不能溢出
        while (cur <= right) {
            // 这里是逻辑与操作，只有第一个条件成立，第二个条件才会参与判断
            // 如果++prev后prev==cur,证明它们的位置是一样的，也就没有必要交换了
            // 只有等prev和cur错开才需要交换
            if (a[cur] < pivot && ++prev != cur) {
                // 交换位置
                swap(a, prev, cur);
            }
            // 后指针继续移动
            ++cur;
        }
        // 当跳出循环时，说明prev及之前的值都是小于基准值的数，则交换prev指向的值和基准值
        swap(a, prev, index);
        // 返回此时基准值的下标
        return prev;
    }


    /**
     * <pre>
     * 左右指针法：
     *      1，任意选择一个数作为基准值；
     *      2，将基准值与首位元素进行交换；
     *      3、基准值所在的位置记作 index，基准值记作 pivot；
     *      4、初始化两个指针left和right，分别从左边和右边开始遍历数组，一定是右指针开始遍历；
     *      5、右指针从右边开始向左移动，直到找到一个小于基准元素的元素；
     *      6、左指针从左边开始向右移动，直到找到一个大于基准元素的元素；
     *      7、如果左指针的位置小于右指针的位置，则交换左指针和右指针所指向的元素；
     *      8、左右指针不断的移动直到相遇，此时将基准元素与左指针所指向的元素进行交换，此时基准元素的位置已经确定。
     */
    int leftAndRightPointer(int[] a, int left, int right) {
        // 三数取中
        int mid = getMidIndex(a, left, right);
        // 把基准值放到left位置
        swap(a, mid, left);

        // 基准值的位置
        int index = left;
        // 获取基准值
        int pivot = a[index];

        while (left < right) {
            // 右指针从右边开始向左移动，直到找到一个小于基准元素的元素
            while (left < right && pivot <= a[right]) {
                right--;
            }
            // 跳出了上边while循环，说明此时的右指针所在元素小于基准值

            // 左指针从左边开始向右移动，直到找到一个大于基准元素的元素
            while (left < right && pivot >= a[left]) {
                left++;
            }
            //  跳出了上边while循环，说明此时的左指针所在元素大于基准值，

            //  交换左右指针所在位置的元素
            swap(a, left, right);
        }
        // 当跳出循环时，说明此时此刻左右指针是重合的
        swap(a, left, index);
        // 返回此时基准值的下标
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] ints = new int[]{2, 67, 4, 21, 45, 1, 4, 2, 6};
        quickSort.quickSort2(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

}
