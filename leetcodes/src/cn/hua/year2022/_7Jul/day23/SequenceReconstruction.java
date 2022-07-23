package cn.hua.year2022._7Jul.day23;


import java.util.*;

// 剑指 Offer II 115. 重建序列
// 中等题
public class SequenceReconstruction {

    // 检查 nums 是否是唯一的最短 超序列
    // 官方 AC代码
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        // 节点的入度、
        int[] indegrees = new int[n + 1];
        // 用 sequences 构建的拓扑图
        // 每个节点指向的节点都会被放在同一个 Set 中
        Set<Integer>[] graph = new Set[n + 1];
        // 初始化图结构
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                // 图中插入 prev -> next 一条边
                if (graph[prev].add(next)) {
                    // next 节点的入度加一
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            // 入度为零的节点压入队列
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 如果每一轮拓扑选点可以选到两个点，那拓扑序列不唯一
            // 那么 nums 不是唯一最短的超序列
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
}

