package com.jidi.learn.leetcode.methodology.window;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹
 * <p>
 * 示例 1：
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * <p>
 * 示例 2：
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 *
 * @author: jidi
 * @email: jidi_jidi@163.com
 * @date 2024/5/7
 */
public class Decrypt {


    /**
     * 模拟
     */
    public static int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];
        if (k == 0) {
            return result;
        }

        for (int i = 0; i < length; i++) {
            if (k > 0) {
                for (int j = i + 1; j < k + i + 1; j++) {
                    result[i] += code[j % length];
                }
            } else {
                for (int j = i + k; j < i; j++) {
                    result[i] += code[(j + length) % length];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(decrypt(new int[]{2, 4, 9, 3}, -2)).forEach(System.out::println);
    }
}
