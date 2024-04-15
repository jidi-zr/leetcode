package com.jidi.learn.leetcode.design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射 https://leetcode.cn/problems/design-hashmap/description/?envType=daily-question&envId=2024-04-15
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/15
 */
public class MyHashMap {

    private static final int CAPACITY = 779;

    private static final int NOT_FOUND = -1;


    /**
     * 链表数组
     */
    private LinkedList<Element>[] data;

    public MyHashMap() {
        data = new LinkedList[CAPACITY];
        // 初始化数组每个元素
        for (int i = 0; i < CAPACITY; i++) {
            data[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        int hash = key % CAPACITY;
        Iterator<Element> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (element.getKey() == key) {
                element.setValue(value);
                return;
            }
        }
        data[hash].offerLast(new Element(key, value));
    }

    public int get(int key) {
        int hash = key % CAPACITY;
        Iterator<Element> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (element.getKey() == key) {
                return element.getValue();
            }
        }
        return NOT_FOUND;
    }

    public void remove(int key) {
        int hash = key % CAPACITY;
        Iterator<Element> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            if (element.getKey() == key) {
                data[hash].remove(element);
                return;
            }
        }
    }


    /**
     * k,v键值对对象
     */
    private class Element {
        private int key;
        private int value;

        public Element(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
