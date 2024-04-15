package com.jidi.learn.leetcode.dataStructure.linkList;

/**
 * 328. 奇偶链表  https://leetcode.cn/problems/odd-even-linked-list/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/14
 */
public class OddEvenList {


    /**
     * 奇偶指针
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 暂存奇数元素链表头
        ListNode evenHead = head.next;
        // 用两个指针指分别向奇数号和偶数号元素
        ListNode odd = head, even = evenHead;

        while (even != null && even.next != null) {
            // 偶指针指向元素的下一个元素为奇指针指向的元素
            odd.next = even.next;
            // 偶指针移动
            odd = odd.next;
            // 奇指针指向的元素的下一个元素是偶指针指向的元素
            even.next = odd.next;
            // 奇指针移动
            even = even.next;
        }
        // 奇数元素链表拼到偶数元素链表后面
        odd.next = evenHead;
        return head;
    }
}
