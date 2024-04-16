package com.jidi.learn.leetcode.design;

/**
 * 707. 设计链表 https://leetcode.cn/leetbook/read/linked-list/fabl3/
 * 双向链表
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/16
 */
public class MyDoublyLinkedList {

    /**
     * 双链表节点
     */
    class Node {
        /**
         * 当前节点值
         */
        int val;

        /**
         * 前一个节点
         */
        Node prev;

        /**
         * 后一个节点
         */
        Node next;

        Node() {

        }

        Node(int val) {
            this(val, null, null);
        }

        Node(int val, Node prev) {
            this(val, prev, null);
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }


    /**
     * 链表元素数量
     */
    private int size;

    /**
     * 链表头尾节点
     */
    private Node head, tail;

    public MyDoublyLinkedList() {
        this.size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }


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

    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        this.addAtIndex(this.size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        index = Math.max(0, index);
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node node = new Node(val, current, current.next);
        current.next = node;
        current.next.prev = node;
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0) {
            return;
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        current.next.prev = current;
        this.size--;
    }

}
