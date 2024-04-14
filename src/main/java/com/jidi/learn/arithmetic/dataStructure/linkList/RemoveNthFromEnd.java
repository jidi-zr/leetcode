package com.jidi.learn.arithmetic.dataStructure.linkList;

/**
 * 删除链表的倒数第N个节点 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class RemoveNthFromEnd {

    /**
     * 先遍历链表，得到链表长度，
     * 然后计算要删除的节点位置，
     * 找到要删除节点的前驱节点，完成删除
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;

        // 待删除节点位置
        int index = length(head) - n;

        // 如果index等于0表示删除的是头结点
        if (index == 0) {
            return head.next;
        }

        // 首先找到要删除链表的前一个结点
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }

        // 让前一个结点的next指向要删除节点的next
        pre.next = pre.next.next;
        return head;
    }


    /**
     *  求链表的长度
     */
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }


    /**
     * 方式二，使用双指针
     * 一个指针fast先走n步，然后另一个指针slow从头结点开始，找到要删除结点的前一个结点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 要移除的是头节点
        if (fast == null) {
            return head.next;
        }

        // 遍历，直到快指针结束
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 最终slow是倒数第n+1个节点，
        // 下一个结点是倒数第n个节点，所以删除的是他的下一个结点
        slow.next = slow.next.next;
        return head;
    }


}

