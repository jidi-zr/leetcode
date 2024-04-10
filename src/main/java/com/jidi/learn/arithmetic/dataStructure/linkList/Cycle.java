package com.jidi.learn.arithmetic.dataStructure.linkList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 https://leetcode.cn/leetbook/read/linked-list/jbex5/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class Cycle {

    /**
     * 使用快慢指针，只要有环一定会相遇，类比时钟的秒针跟分针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
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
                return true;
            }
        }
        return false;
    }


    /**
     * 使用集合存放，只要有重复元素，一定有环
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            // 如果重复出现说明有环
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
