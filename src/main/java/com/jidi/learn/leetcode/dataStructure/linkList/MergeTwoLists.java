package com.jidi.learn.leetcode.dataStructure.linkList;

/**
 * 21. 合并两个有序链表  https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class MergeTwoLists {

    /**
     * 链表是升序的，只需要遍历每个链表的头，比较一下哪个小就把哪个链表的头拿出来放到新的链表中，
     * 一直这样循环，直到有一个链表为空，然后再把另一个不为空的链表挂到新的链表中
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 新链表头结点
        ListNode newHead = new ListNode(0);
        // 当前节点指向新链表头节点
        ListNode current = newHead;
        while (list1 != null && list2 != null) {
            // 从头节点开始比较，谁小就放到新链表
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // 移动到下一个节点
            current = current.next;
        }

        // 处理剩余的节点
        current.next = list1 == null ? list2 : list1;
        return newHead.next;
    }


    /**
     * 递归
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 谁小头节点就是谁，然后继续比较下一个节点和另一个链表的头节点
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }

        list2.next = mergeTwoLists2(list2.next, list1);
        return list2;
    }
}
