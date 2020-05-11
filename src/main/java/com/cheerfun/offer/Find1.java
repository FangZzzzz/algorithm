package com.cheerfun.offer;

/**
 *  * @Description find1
 *  * @Classname Find1
 *  * @Author fangzhou
 *  * @Date 2020/4/27 3:22 下午
 *  * @Version V1.0
 *  
 */
public class Find1 {


    public static void main(String[] args) {
        int array[][] = new int[4][];
        array[0] = new int[]{1,2,8,9};
        array[1] = new int[]{2,4,9,12};
        array[2] = new int[]{4,7,10,13};
        array[3] = new int[]{6,9,11,15};
        System.out.println(find(7,array));
    }

    /**
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public static  boolean find(int target, int[][] array) {
        if (array == null || array[0] == null) {
            return false;
        }
        int i = array.length - 1, j = 0;
        while (i != -1 && j != array[i].length) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }

        }

        return false;
    }
}
