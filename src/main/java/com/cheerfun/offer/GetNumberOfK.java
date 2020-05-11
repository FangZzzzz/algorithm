package com.cheerfun.offer;

/**
 *  * @Description TODO
 *  * @Classname GetNumberOfK
 *  * @Author fangzhou
 *  * @Date 2020/5/4 12:31 下午
 *  * @Version V1.0
 *  
 */
public class GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        int first = getFirst(array, k);
        int end = getEnd(array, k);
        return end - first + 1;
    }


    public int getFirst(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }

    public int getEnd(int[] array, int k) {
        int start = 0, end = array.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (array[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return end;
    }
}
