package com.jidi.learn.arithmetic.dataStructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 144. 二叉树的前序遍历
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/10
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }


    /**
     * 深度优先遍历
     */
    private void dfs(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        result.add(root.val);
        dfs(root.left, result);
        dfs(root.right, result);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
