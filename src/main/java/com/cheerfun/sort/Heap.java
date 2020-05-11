package com.cheerfun.sort;

/**
 *  * @Description TODO
 *  * @Classname Heap
 *  * @Author fangzhou
 *  * @Date 2020/5/7 9:43 下午
 *  * @Version V1.0
 *  
 */
public class Heap {
    private int[] data;
    private int size;
    private int length;

    public Heap(int length) {
        this.data = new int[length];
        this.size = 0;
        this.length = length;
    }

    public Heap(int[] data, int length) {
        this.data = data;
        this.size = data.length;
        this.length = length;
        for (int i = size - 1; i >= 0; i--) {
            shiftUp(i);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[]{3, 2, 1, 5, 7, 9, 5, 3}, 10);
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
    }


    public void insert(int num) {
        if (size >= length) {
            throw new NullPointerException();
        }
        data[size] = num;
        shiftUp(size);
        size++;
    }

    public int remove() {
        if (size <= 0) {
            throw new NullPointerException();
        }
        int result = data[0];
        swap(0, size - 1);
        size--;
        shiftDown(0);
        return result;
    }

    private void shiftUp(int i) {
        while ((i - 1) / 2 >= 0 && data[i] > data[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void shiftDown(int i) {
        // 代表有孩子
        while (i * 2 + 1 <= size - 1) {
            int temp = i * 2 + 1;
            if (temp + 1 <= size - 1 && data[temp] < data[temp + 1]) {
                temp++;
            }
            if(data[i] < data[temp]) {
                swap(i, temp);
            }
            i = temp;
        }
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
