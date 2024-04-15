package com.jidi.learn.leetcode.dataStructure.linkList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 相交链表 https://leetcode.cn/leetbook/read/linked-list/jjbj2/
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/9
 */
public class GetIntersectionNode {


    /**
     * 使用 set,
     * 先把第一个链表的节点全部存放到集合set中，
     * 然后遍历第二个链表的每一个节点，判断在集合set中是否存在，
     * 如果存在就直接返回这个存在的结点。
     * 如果遍历完了，在集合set中还没找到，说明他们没有相交
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (Objects.nonNull(headA)) {
            set.add(headA);
            headA = headA.next;
        }

        while (Objects.nonNull(headB)) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    /**
     * 先统计两个链表的长度，
     * 如果两个链表的长度不一样，就让链表长的先走，直到两个链表长度一样，
     * 这个时候两个链表再同时每次往后移一步，看节点是否一样，
     * 如果有相等的，说明这个相等的节点就是两链表的交点，
     * 否则如果走完了还没有找到相等的节点，说明他们没有交点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int aLength = length(headA);
        int bLength = length(headB);

        /**
         * 长的链表先移动，直到两个链表长度相等
         */
        while (aLength != bLength) {
            if (aLength > bLength) {
                headA = headA.next;
                aLength--;
            } else {
                headB = headB.next;
                bLength--;
            }
        }

        /**
         * 依次比较链表元素直到链表走到尽头
         */
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 统计链表长度
     */
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }


    /**
     * 双指针 走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        /**
         * 定义双指针
         */
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            // 如果指针a不为空，a就往后移一步。
            // 如果指针a为空，就让指针a指向headB
            a = a == null ? headB : a.next;
            // 指针b同上
            b = b == null ? headA : b.next;
        }
        // 要么是空，要么是两链表的交点
        return a;
    }
}
