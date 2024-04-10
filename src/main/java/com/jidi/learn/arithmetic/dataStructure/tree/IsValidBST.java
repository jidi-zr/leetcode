package com.jidi.learn.arithmetic.dataStructure.tree;

import java.util.Objects;

/**
 * 98. 验证二叉搜索树
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/10
 */
public class IsValidBST {


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }


    /**
     * 递归
     */
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (Objects.nonNull(min) && min.val >= root.val) {
            return false;
        }
        if (Objects.nonNull(max) && max.val <= root.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
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
