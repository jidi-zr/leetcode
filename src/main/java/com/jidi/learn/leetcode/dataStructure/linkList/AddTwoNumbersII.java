package com.jidi.learn.leetcode.dataStructure.linkList;

/**
 * 445. 两数相加 II  https://leetcode.cn/problems/add-two-numbers-ii/description/
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class AddTwoNumbersII {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1 和 l2 反转后，就变成： 2. 两数相加  https://leetcode.cn/problems/add-two-numbers/description/
        l1 = this.reverseList(l1);
        l2 = this.reverseList(l2);

        // 计算和
        ListNode l3 = this.addTwo(l1, l2);

        // 结果还需要反转
        return this.reverseList(l3);
    }


    /**
     * 双链表（头插法）
     * 把原链表的节点一个个摘掉，每次摘掉的链表都让他成为新的链表的头节点，然后更新新链表
     */
    private ListNode reverseList(ListNode head) {
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


    /**
     * 迭代模拟
     */
    private ListNode addTwo(ListNode l1, ListNode l2) {
        // 尾插法，需要一个指针指向头节点，头节点的下一个节点就是真正的头节点
        ListNode head = new ListNode(0);
        ListNode current = head;
        // 保存需要进位的值
        int capacity = 0;
        while (l1 != null || l2 != null) {
            /**
             * 计算和
             */
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + capacity;

            // 得到要进位的值
            capacity = sum / 10;
            // 得到要保存的值
            sum = sum % 10;

            // 尾插法插入链表节点
            ListNode newNode = new ListNode(sum);
            current.next = newNode;
            current = newNode;

            // 不断移动链表指针，直到为null
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后还需要判断是否需要进位
        if (capacity > 0) {
            current.next = new ListNode(capacity);
        }
        return head.next;
    }


}
