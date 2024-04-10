package com.jidi.learn.arithmetic.dataStructure.linkList;

import java.util.Stack;

/**
 * 回文链表 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnv1oc/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class Palindrome {

    /**
     * 使用栈
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();

        ListNode temp = head;
        // 把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // 出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            // 移动到下一个节点
            head = head.next;
        }
        return true;
    }


    /**
     * 使用快慢指针
     */
    public boolean isPalindrom2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        /**
         * 类别两个人跑步，跑得快的速度是跑的慢的两倍，
         * 跑的快的到达终点，跑得慢的还在中间位置
         */
        while (fast != null || fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 快指针不为null，链表长度为奇数
        if (fast != null) {
            slow = slow.next;
        }

        // 反转后半部分链表
        slow = reverse(slow);

        // 重新指向头节点
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            // 移动到下一个节点
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * 头插法，实现反转链表
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 先暂存下一个节点
            ListNode next = head.next;

            // 头插法
            head.next = prev;
            prev = head;

            // 继续处理下一个节点
            head = next;
        }
        return prev;
    }
}
