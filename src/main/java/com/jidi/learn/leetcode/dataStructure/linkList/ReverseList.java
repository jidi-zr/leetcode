package com.jidi.learn.leetcode.dataStructure.linkList;

import java.util.Stack;

/**
 * 反转链表 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnhm6/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class ReverseList {


    /**
     * 使用栈
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        // 节点入栈
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        // 新的头节点
        ListNode newHead = stack.pop();
        // 当前指针指向新的头节点
        ListNode current = newHead;
        while (!stack.isEmpty()) {
            // 新节点出栈
            ListNode tempNode = stack.pop();
            // 当前指针指向的节点的下一个节点就是刚出栈的新节点
            current.next = tempNode;
            // 当前指针继续移动
            current = tempNode;
        }
        // 最后一个节点就是反转前的头节点，一定要让他的next等于null，否则会构成环
        current.next = null;
        return newHead;
    }


    /**
     * 双链表（头插法）
     * 把原链表的节点一个个摘掉，每次摘掉的链表都让他成为新的链表的头节点，然后更新新链表
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 新的链表
        ListNode newHead = null;
        while (head != null) {
            // 暂存要访问的下一个节点
            ListNode next = head.next;
            // 头插法
            head.next = newHead;
            // 更新新链表头节点
            newHead = head;
            // 继续处理下一个节点
            head = next;
        }
        return newHead;
    }
}
