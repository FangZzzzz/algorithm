package com.cheerfun.study.dp;

import java.util.Arrays;

/**
 *  * @Description TODO
 *  * @Classname knapsack
 *  * @Author fangzhou
 *  * @Date 2020/5/31 6:06 下午
 *  * @Version V1.0
 *  
 */
public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack._01knapsack_01(new int[]{1, 1, 1, 2, 3}, 9));
        System.out.println(knapsack._01knapsack_03(new int[]{1, 1, 1, 2, 3}, new int[]{3, 3, 3, 3, 3}, 9));

    }

    /**
     * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
     * 在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
     *
     * @param items
     * @param w
     * @return
     */
    public int _01knapsack_01(int[] items, int w) {
        if (items == null || items.length == 0 || w == 0) {
            return 0;
        }
        int n = items.length;
        int max = -1;
        boolean[][] status = new boolean[n][w + 1];
        // 第一个不拿
        status[0][0] = true;
        if (items[0] <= w) {
            status[0][items[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                status[i][j] = status[i - 1][j];
            }
            for (int j = 0; j <= w - items[i]; j++) {
                if (status[i - 1][j]) {
                    status[i][j + items[i]] = true;
                    max = Math.max(max, j + items[i]);
                }
            }
        }
        return max;
    }

    /**
     * 问题同上
     *
     * @param items
     * @param w
     * @return
     */
    public int _01knapsack_02(int[] items, int w) {
        if (items == null || items.length == 0 || w == 0) {
            return 0;
        }
        int n = items.length;
        int max = -1;
        boolean[] status = new boolean[w + 1];
        status[0] = true;
        if (w >= items[0]) {
            status[items[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {
                if (status[j] == true) {
                    status[j + items[i]] = true;
                    max = Math.max(max, j + items[i]);
                }
            }
        }
        return max;
    }

    /**
     * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品
     * 装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
     *
     * @param weights
     * @param values
     * @param w
     * @return
     */
    public int _01knapsack_03(int[] weights, int[] values, int w) {
        if (weights == null || values == null
                || weights.length == 0
                || weights.length != values.length
                || w == 0) {
            return 0;
        }
        int maxValue = -1;
        int n = weights.length;
        int[][] status = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(status[i], -1);
        }
        status[0][0] = 0;
        if (weights[0] <= w) {
            status[0][weights[0]] = values[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                status[i][j] = status[i - 1][j];
            }
            for (int j = 0; j <= w - weights[i]; j++) {
                if (status[i - 1][j] != -1) {
                    status[i][j + weights[i]] = status[i - 1][j] + values[i];
                    maxValue = Math.max(maxValue, status[i][j + weights[i]]);
                }
            }
        }
        return maxValue;
    }
}
