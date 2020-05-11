package com.cheerfun.offer;

import java.util.ArrayList;

/**
 *  * @Description TODO
 *  * @Classname PrintMatrix
 *  * @Author fangzhou
 *  * @Date 2020/5/1 3:40 下午
 *  * @Version V1.0
 *  
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);

        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            if(left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
