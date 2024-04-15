package com.jidi.learn.leetcode.dataStructure.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 199. 二叉树的右视图  https://leetcode.cn/problems/binary-tree-right-side-view/description/
 * <p>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * 输入: []
 * 输出: []
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/4/8
 */
public class RightView {

    /**
     * 按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 从根节点开始访问，根节点深度是0
        dfs(root, result, 0);
        return result;
    }


    /**
     * 深度优先遍历
     *
     * @param node  节点
     * @param list
     * @param level 当前遍历深度
     */
    private void dfs(TreeNode node, List<Integer> list, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        // 右视图，所以每一层只有一个值，判断深度和list的size
        if (list.size() == level) {
            list.add(node.val);
        }
        // 先遍历右子树
        dfs(node.right, list, level + 1);
        // 后遍历左子树
        dfs(node.left, list, level + 1);
    }

}


/**
 * 定义树节点
 */
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
