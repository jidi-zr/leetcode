package com.jidi.learn.leetcode.dataStructure.arrays;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/7
 */
public class Average {

    public double average(int[] salary) {
        double result = 0d;
        if (salary == null || salary.length < 1) {
            return result;
        }
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double sum = 0;

        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            max = Double.max(max, salary[i]);
            min = Double.min(min, salary[i]);
        }
        result = (sum - min - max) / (salary.length - 2);
        return result;
    }
}
