package com.jidi.learn.leetcode.design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合  https://leetcode.cn/problems/design-hashset/description/?envType=daily-question&envId=2024-04-14
 * <p>
 * 基于链地址法实现简单的哈希集合
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/15
 */
public class MyHashSet {

    private static final int CAPACITY = 1000000;

    // 链表数组
    private LinkedList[] data;


    public MyHashSet() {
        data = new LinkedList[CAPACITY];
        // 初始化数组每个元素
        for (int i = 0; i < CAPACITY; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash =  key % CAPACITY;
        Iterator<Integer> iterator = data[hash].iterator();
        // 集合元素不能重复
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash =  key % CAPACITY;
        Iterator<Integer> iterator = data[hash].iterator();
        // 遍历删除元素
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash =  key % CAPACITY;
        Iterator<Integer> iterator = data[hash].iterator();
        // 遍历删除元素
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

}
