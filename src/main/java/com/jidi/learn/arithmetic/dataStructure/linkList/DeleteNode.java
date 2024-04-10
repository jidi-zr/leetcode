package com.jidi.learn.arithmetic.dataStructure.linkList;

/**
 * 删除链表中的节点 https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnarn7/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/31
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}