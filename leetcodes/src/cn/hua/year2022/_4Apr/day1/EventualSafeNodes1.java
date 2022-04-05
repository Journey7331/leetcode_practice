package cn.hua.year2022._4Apr.day1;

import java.util.*;

// 802. 找到最终的安全状态
// 中等题
// 【拓扑排序】【图】
// 存图方式：邻接表（链式前向星存图）
public class EventualSafeNodes1 {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        System.out.println(eventualSafeNodes(graph));
    }

    /**
     * * Deque
     * * public interface Deque<E> extends Queue<E>
     * 线性集合，支持【两端】的元素插入和移除。
     * Deque是double ended queue的简称，习惯上称之为双端队列。
     */

    static int N = (int) 1e4 + 10, M = 4 * N;
    static int idx;    // 对边进行编号
    static int[] he = new int[N];  // 节点对应边的集合（数组链表）的头节点
    static int[] ne = new int[M];  // 以链表的形式存边，该数组用于找到下一条边
    static int[] e = new int[M];   // 访问某一条边指向的节点
    static int[] cnts = new int[N];//

//    // 访问所有由 a 点发出的边
//    for (int i = he[a]; i != -1; i = ne[i]) {
//        int b = e[i], c = w[i]; // 存在由 a 指向 b 的边，权重为 c
//    }

    // 加入边 a->b
    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int a : graph[i]) {
                add(a, i);
                cnts[i]++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(cnts[i] == 0) deque.addLast(i);
        }
        while (!deque.isEmpty()) {
            int poll = deque.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if(--cnts[j] == 0) deque.addLast(j);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(cnts[i] == 0) ans.add(i);
        }
        return ans;

    }

}