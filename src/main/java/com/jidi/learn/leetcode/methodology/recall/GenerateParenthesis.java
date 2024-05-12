package com.jidi.learn.leetcode.methodology.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成 https://leetcode.cn/problems/generate-parentheses/description/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/12
 */
public class GenerateParenthesis {

    /**
     * 回溯算法（深度优先遍历）
     * 题解：https://leetcode.cn/problems/generate-parentheses/solutions/35947/hui-su-suan-fa-by-liweiwei1419/
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        // 执行深度优先遍历，搜索可能的结果
        this.dfs("", n, n, result);
        return result;
    }


    /**
     * 深度优先遍历
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param result 结果集
     */
    private void dfs(String curStr, int left, int right, List<String> result) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            result.add(curStr);
            return;
        }
        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝）
        if (left > right) {
            return;
        }
        if (left > 0) {
            this.dfs(curStr + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, result);
        }
    }

}
