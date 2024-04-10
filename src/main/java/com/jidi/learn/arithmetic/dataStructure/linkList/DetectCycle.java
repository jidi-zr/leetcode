package com.jidi.learn.arithmetic.dataStructure.linkList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II https://leetcode.cn/leetbook/read/linked-list/jjhf6/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/8
 */
public class DetectCycle {


    /**
     * 快慢指针
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        /**
         * 定义快慢指针
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 快指针每次走两步
            fast = fast.next.next;
            // 慢指针每次走一步
            slow = slow.next;
            // 能相遇肯定有环
            if (slow == fast) {
                /**
                 * 两相遇指针，一个从头结点开始，一个从相遇点开始每次走一步，直到再次相遇为止
                 */
                while (head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }


    
    /**
     * 集合，第一个重复的元素就是入环的第一个节点
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            // 如果重复出现说明有环
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
