package cn.hua.year2022._4Apr.day1;

import java.util.*;

// 802. 找到最终的安全状态
// 中等题
// 【拓扑排序】【图】
public class EventualSafeNodes {
    /*
     * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
     * 返回一个由图中所有 安全节点 组成的数组作为答案。答案数组中的元素应当按 升序 排列。
     *
     * 对于那些反向图中「入度」为 0 的点集 x，
     * 其实就是原图中「出度」为 0 的节点，它们「出度」为 0，
     * 根本没指向任何节点，必然无法进入环，是安全的；
     *
     * 同时由它们在反向图中指向的节点（在原图中「只指向」它们的节点），必然也是无法进入环的，
     * 对应到反向图中，就是那些减去 x 对应的入度之后，入度为 0 的节点。
     *
     * 因此整个过程就是将图进行反向，再跑一遍拓扑排序，
     * 如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0，
     * 其是安全的，其余节点则是在环内非安全节点。
     */
    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        System.out.println(eventualSafeNodes(graph));
    }

    /**
     * * Queue.offer(E e)
     * 该方法是add()方法的优化版
     * 先 add(e)，然后返回一个是否超过容量值的 boolean 结果
     * 超过则插入失败
     * <p>
     * * HashMap.computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction)
     * 该方法对 hashMap 中指定 key 的值进行重新计算，
     * 如果不存在这个 key，则添加到 hashMap 中。
     * 如果 key 对应的 value 不存在，则使用获取 remappingFunction 重新计算后的值，并保存为该 key 的 value
     * 如果 key 对应的 value 存在，则返回该 value，且不会更新使用 remappingFunction 的值
     */

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        // 原图中点的入度及入边集
        Map<Integer, List<Integer>> inMap = new HashMap<>();
        // 原图中点的出度数
        Map<Integer, Integer> outCountMap = new HashMap<>();
        // 原图中出度为零的点，即结尾节点
        // 反向图中入度为零的点，即拓扑起始点，一定是安全节点
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] arr = graph[i];
            if (arr == null || arr.length == 0) {
                queue.offer(i);
            } else {
                // 把该点加入 指向点的入边集
                // 该点的出边个数自增
                for (int v : arr) {
                    outCountMap.put(i, outCountMap.getOrDefault(i, 0) + 1);
                    List<Integer> list = inMap.computeIfAbsent(v, t -> new ArrayList<>());
                    list.add(i);
                }
            }
        }

        while (!queue.isEmpty()) {
            // queue 中的点一定为安全节点，直接弹出
            int val = queue.poll();
            ans.add(val);

            List<Integer> list = inMap.get(val);
            if (list == null) continue;
            for (int a : list) {
                Integer c = outCountMap.get(a);

                // 指向安全节点的 节点 如果只有一个出度，那该点也是安全节点
                if (--c == 0) queue.offer(a);
                outCountMap.put(a, c);
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
