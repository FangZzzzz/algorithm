package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname VerifySquenceOfBST
 *  * @Author fangzhou
 *  * @Date 2020/5/2 2:24 下午
 *  * @Version V1.0
 *  
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        new VerifySquenceOfBST().VerifySquenceOfBST(new int[]{1, 4, 3, 5});
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        // 找到左右子树的分界点
        int i = l;
        while (i < r && sequence[i] < sequence[r]) {
            i++;
        }
        // 判断右子树是否全部大于根
        for (int j = i; j < r - 1; j++) {
            if (sequence[j] < sequence[r]) {
                return false;
            }
        }
        return judge(sequence, l, i-1) && judge(sequence, i , r - 1);
    }

}
