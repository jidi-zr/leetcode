package com.jidi.learn.leetcode.dataStructure.strings;

/**
 * 整数反转  https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnx13t/
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2023/12/30
 */
public class Reverse {

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            // 取得最后一位的数字
            int last = x % 10;

            // 每循环一次，在原来的值的基础上*10
            result = result * 10 + last;
            if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE) {
                return 0;
            }
            // 控制循环次数
            x = x / 10;
        }
        return (int) result;
    }


}
