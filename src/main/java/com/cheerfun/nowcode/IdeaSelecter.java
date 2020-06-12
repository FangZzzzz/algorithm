package com.cheerfun.nowcode;

/**
 *  * @Description TODO
 *  * @Classname IdeaSelecter
 *  * @Author fangzhou
 *  * @Date 2020/6/10 3:22 下午
 *  * @Version V1.0
 *  
 */

import java.util.*;

/**
 * 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。
 * 现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。
 * 对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，
 * 还相同的情况下选择最早想出的，没有 PM会在同一时刻提出两个 idea。
 * <p>
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,
 * 然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。
 * 直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，
 * 那么他们会依次进行查看idea的操作。
 * <p>
 * 求每个idea实现的时间。
 */
public class IdeaSelecter {

    private static Scanner sc = new Scanner(System.in);

    private static IdeaTask[] initIdeaTask(int P) {
        IdeaTask[] ideaTasks = new IdeaTask[P];
        for (int i = 0; i < P; i++) {
            ideaTasks[i] = new IdeaTask();
            int pmId = sc.nextInt();
            ideaTasks[i].pmId = pmId;
            ideaTasks[i].createTime = sc.nextInt();
            ideaTasks[i].priorityLevel = sc.nextInt();
            ideaTasks[i].needTime = sc.nextInt();
        }
        return ideaTasks;
    }

    private static Map<Integer, Pm> initPm(int N, IdeaTask[] ideaTasks) {
        Map<Integer, Pm> pmMap = new HashMap<>();
        // 他妈的pmId乱给的
        for (IdeaTask ideaTask : ideaTasks) {
            if (pmMap.containsKey(ideaTask.pmId)) {
                pmMap.get(ideaTask.pmId).createTimeHeap.offer(ideaTask);
            } else {
                Pm pm = new Pm();
                pm.createTimeHeap.offer(ideaTask);
                pmMap.put(ideaTask.pmId, pm);
            }
        }
        return pmMap;
    }

    private static IdeaTask selectTask(Map<Integer, Pm> pmMap, int startTime) {
        PriorityQueue<IdeaTask> ideaTasksPQ = new PriorityQueue<>(new Comparator<IdeaTask>() {
            @Override
            public int compare(IdeaTask o1, IdeaTask o2) {
                // 如果开始了，或者两个都没开始，无所谓了
                if (o1.createTime == o2.createTime || o1.createTime <= startTime && o2.createTime <= startTime) {
                    if (o1.needTime != o2.needTime) {
                        return o1.needTime - o2.needTime;
                    }
                    return o1.pmId - o2.pmId;
                }
                // 两个开始时间不相等且都没开始，找个开始时间少的
                if (o1.createTime > startTime && o2.createTime > startTime) {
                    return o1.createTime - o2.createTime;
                }
                // 找个开始了的
                if (o1.createTime <= startTime) {
                    return 1;
                }
                if (o2.createTime <= startTime) {
                    return -1;
                }
                // 都一样，随便了
                return 0;
            }
        });
        for (Pm pm : pmMap.values()) {
            IdeaTask ideaTask = pm.selectIdeaTask(startTime);
            if (ideaTask != null) {
                ideaTasksPQ.offer(ideaTask);
            }
        }
        IdeaTask task = null;
        if (!ideaTasksPQ.isEmpty()) {
            task = ideaTasksPQ.poll();
        }
        while (!ideaTasksPQ.isEmpty()) {
            IdeaTask ideaTask = ideaTasksPQ.poll();
            pmMap.get(ideaTask.pmId).createTimeHeap.offer(ideaTask);
        }
        return task;
    }

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        IdeaTask[] ideaTasks = initIdeaTask(P);
        Map<Integer, Pm> pmMap = initPm(N, ideaTasks);
        PriorityQueue<Programmer> programmerPQ = new PriorityQueue<>(Comparator.comparingInt(x -> x.nextWorkTime));
        for (int i = 0; i < M; i++) {
            programmerPQ.offer(new Programmer());
        }
        for (int i = 0; i < P; i++) {
            Programmer programmer = programmerPQ.poll();
            IdeaTask ideaTask = selectTask(pmMap, programmer.nextWorkTime);
            programmer.nextWorkTime = Math.max(ideaTask.createTime, programmer.nextWorkTime) + ideaTask.needTime;
            ideaTask.endTime = programmer.nextWorkTime;
            programmerPQ.offer(programmer);
        }
        for (IdeaTask ideaTask : ideaTasks) {
            System.out.println(ideaTask.endTime);
        }
    }
}

class IdeaTask {
    int pmId;
    int createTime;
    int priorityLevel;
    int needTime;
    int endTime;
}

class Pm {
    PriorityQueue<IdeaTask> createTimeHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x.createTime));

    public IdeaTask selectIdeaTask(int startTime) {
        PriorityQueue<IdeaTask> pmHeap = new PriorityQueue<>((o1, o2) -> {
            // 产品优先级最高的
            if (o1.priorityLevel != o2.priorityLevel) {
                return o1.priorityLevel - o2.priorityLevel;
            }
            // 需要时间最小的
            if (o1.needTime != o2.needTime) {
                return o1.needTime - o2.needTime;
            }
            // 创建时间最小的
            return o1.createTime - o2.createTime;
        });
        while (!createTimeHeap.isEmpty() && createTimeHeap.peek().createTime <= startTime) {
            pmHeap.offer(createTimeHeap.poll());
        }
        IdeaTask task = pmHeap.isEmpty() ? createTimeHeap.poll() : pmHeap.poll();
        while (!pmHeap.isEmpty()) {
            createTimeHeap.offer(pmHeap.poll());
        }
        return task;
    }
}

class Programmer {
    int nextWorkTime = 0;
}