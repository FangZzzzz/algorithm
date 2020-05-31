package com.cheerfun.study.dp;

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
        System.out.println(new Knapsack()._01knapsack_01(new int[]{1, 1, 1, 2, 3}, 9));
    }

    public int _01knapsack_01(int[] items, int w) {
        if (items == null || items.length == 0 || w == 0) {
            return 0;
        }
        int n = items.length;
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
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (status[j][i]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int _01knapsack_02(int[] items, int w) {
        if (items == null || items.length == 0 || w == 0) {
            return 0;
        }
        int n = items.length;
        boolean[] status = new boolean[w + 1];
        status[0] = true;
        if (w >= items[0]) {
            status[items[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {
                if (status[j] == true) {
                    status[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (status[i]) {
                return i;
            }
        }
        return 0;
    }
}
