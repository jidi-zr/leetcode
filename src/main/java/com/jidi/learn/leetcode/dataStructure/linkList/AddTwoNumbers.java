package com.jidi.learn.leetcode.dataStructure.linkList;

/**
 * 2. 两数相加  https://leetcode.cn/problems/add-two-numbers/description/
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/8
 */
public class AddTwoNumbers {

    /**
     * 模拟，由于链表长度最大可以为100，此方法不能通过校验
     */
    @Deprecated
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int sum = sum(l1, 0) + sum(l2, 0);
        ListNode head = new ListNode(0);
        if (sum == 0) {
            return head;
        }
        ListNode current = head;
        // 不断获得尾部的元素
        while (sum > 0) {
            // 尾插法
            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = newNode;
            sum /= 10;
        }
        return head.next;
    }


    /**
     * 递归计算链表节点数之和
     */
    private static int sum(ListNode listNode, int time) {
        if (listNode == null) {
            return 0;
        }
        return listNode.val * (int) Math.pow(10, time) + sum(listNode.next, ++time);
    }


    
    /**
     * 迭代模拟
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 尾插法，需要一个指针指向头节点，头节点的下一个节点就是真正的头节点
        ListNode head = new ListNode(0);
        ListNode current = head;
        // 保存需要进位的值
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 为 null，使用 0 填充
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            // 得到两个链表节点的和
            int sum = v1 + v2 + carry;
            // 得到要进位的值
            carry = sum / 10;
            // 得到新链表节点要保存的值
            sum = sum % 10;

            // 尾插法插入链表节点
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = newNode;

            // 移动链表指针，直到为null，因为两个链表长度不一样，肯定有一个会先遍历完
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 还要进位1
        if (carry == 1) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }


}
