package com.jidi.learn.leetcode.dataStructure.linkList;

/**
 * 设计链表  https://leetcode.cn/leetbook/read/linked-list/jy291/
 * 单链表
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/3/18
 */
public class MyLinkedList {
    /**
     * 链表长度
     */
    int size;

    /**
     * 头节点
     */
    Node head;


    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);
    }

    /**
     * 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node current = this.head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }


    /**
     * 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     */
    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    /**
     * 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
     */
    public void addAtTail(int val) {
        this.addAtIndex(this.size, val);
    }

    /**
     * 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
     * 如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
     * 如果 index 比长度更大，该节点将不会插入到链表中。
     */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        index = Math.max(0, index);
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node node = new Node(val);
        node.next = current.next;
        current.next = node;
        this.size++;
    }


    /**
     * 如果下标有效，则删除链表中下标为 index 的节点。
     */
    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0) {
            return;
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        this.size--;
    }


    /**
     * 自定义链表节点
     */
    class Node {
        // 当前节点值
        int val;
        // 下一个节点
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
