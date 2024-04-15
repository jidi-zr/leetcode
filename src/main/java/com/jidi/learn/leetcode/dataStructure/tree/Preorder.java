package com.jidi.learn.leetcode.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 589. N 叉树的前序遍历  https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/10
 */
public class Preorder {

    /**
     * 递归
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }


    /**
     * 深度优先的前序遍历
     */
    private void dfs(Node root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            dfs(node, result);
        }
    }


    /**
     * 定义Node
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
