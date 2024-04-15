package com.jidi.learn.leetcode.dataStructure.linkList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 234. 回文链表 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnv1oc/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class Palindrome {


    /**
     * 将值复制到数组中后用双指针法
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        // 将链表的值复制到数组中
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        // 使用双指针判断是否回文
        int left = 0, right = values.size() - 1;
        while (left < right) {
            if (!values.get(left++).equals(values.get(right--))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 使用栈
     */
    public boolean isPalindrome1(ListNode head) {
        Stack<Integer> stack = new Stack();

        // 入栈
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // 节点出栈挨个与原链表进行比较
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
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
        ListNode current = head;
        while (current != null) {
            // 先暂存下一个节点
            ListNode next = current.next;
            // 头插法
            current.next = prev;
            prev = current;
            // 继续处理下一个节点
            current = next;
        }
        return prev;
    }
}
