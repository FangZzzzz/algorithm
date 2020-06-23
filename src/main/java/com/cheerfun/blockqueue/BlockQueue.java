package com.cheerfun.blockqueue;


import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  * @Description TODO
 *  * @Classname BlockQueue
 *  * @Author fangzhou
 *  * @Date 2020/6/22 4:28 下午
 *  * @Version V1.0
 *  
 */
public class BlockQueue<T> {

    ReentrantLock tLock = new ReentrantLock();
    Condition notFull = tLock.newCondition();
    Condition notEmpty = tLock.newCondition();

    private Deque<T> list;

    private int length = 0;
    private int size = 0;

    public BlockQueue(Deque<T> list, int length) {
        this.list = list;
        this.length = length;
    }

    public T pop() throws InterruptedException {
        tLock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T t = list.removeFirst();
            size--;
            notFull.signal();
            return t;
        } finally {
            tLock.unlock();
        }
    }

    public T offer(T t) throws InterruptedException {
        tLock.lock();
        try {
            while (size == length) {
                notFull.await();
            }
            list.addFirst(t);
            size++;
            notEmpty.signal();
            return t;
        } finally {
            tLock.unlock();
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

}
