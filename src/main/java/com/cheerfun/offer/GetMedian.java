package com.cheerfun.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  * @Description TODO
 *  * @Classname GetMedian
 *  * @Author fangzhou
 *  * @Date 2020/5/7 9:19 下午
 *  * @Version V1.0
 *  
 */
public class GetMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);


    public static void main(String[] args) {
        GetMedian getMedian = new GetMedian();
        getMedian.Insert(5);
        getMedian.GetMedian();
    }

    public void Insert(Integer num) {
        if (minHeap.size() == 0 || num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        if (minHeap.size() - 1 > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - 1 > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        double result;
        if (minHeap.size() > maxHeap.size()) {
            result = minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            result = maxHeap.peek();
        } else {
            result = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return result;
    }

}
