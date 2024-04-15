package com.jidi.learn.leetcode.dataStructure.linkList;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 203. 移除链表元素 https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/13
 */
public class RemoveElements {


    /**
     * 队列
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        Queue<ListNode> queue = new LinkedList<>();
        /**
         * 值不为val的节点入队
         */
        while (head != null) {
            if (head.val != val) {
                queue.offer(head);
            }
            head = head.next;
        }

        // 出队，第一个元素为新的头节点
        ListNode newHead = queue.poll();
        ListNode current = newHead;
        // 继续处理队列里面的元素
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
        }
        // 避免形成环
        if (Objects.nonNull(current)) {
            current.next = null;
        }
        return newHead;
    }


    /**
     * 递归
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


    /**
     * 虚拟头节点迭代
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode current = dummyHead;

        // 从虚拟头节点的下一个节点（原来的头节点）开始遍历
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummyHead.next;
    }

}
