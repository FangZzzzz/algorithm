package com.cheerfun.study.dp;

/**
 *  * @Description TODO
 *  * @Classname lwst
 *  * @Author fangzhou
 *  * @Date 2020/6/2 8:46 下午
 *  * @Version V1.0
 *  
 */
public class Lwst {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = 6;
    private int m = 6;
    private int minDist = Integer.MAX_VALUE; // 存储结果

    public static void main(String[] args) {
        Lwst lwst = new Lwst();
        lwst.lwstBT(0,0,0);
        System.out.println(lwst.minDist);
    }

    // 调用方式 lwstBT(0, 0, 0);
    void lwstBT(int i, int j, int edist) {
        if (i == n || j == m) {
            if (i < n) edist += (n - i);
            if (j < m) edist += (m - j);
            if (edist < minDist) minDist = edist;
            return;
        }
        if (a[i] == b[j]) { // 两个字符匹配
            lwstBT(i + 1, j + 1, edist);
        } else { // 两个字符不匹配
            lwstBT(i + 1, j, edist + 1); // 删除a[i]或者b[j]前添加一个字符
            lwstBT(i, j + 1, edist + 1); // 删除b[j]或者a[i]前添加一个字符
            lwstBT(i + 1, j + 1, edist + 1); // 将a[i]和b[j]替换为相同字符
        }
    }
}
