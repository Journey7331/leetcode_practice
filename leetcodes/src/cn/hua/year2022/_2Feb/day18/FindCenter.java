package cn.hua.year2022._2Feb.day18;

// 1791. 找出星型图的中心节点
// 简单题
public class FindCenter {

    public static void main(String[] args) {
        int[][] edges = {
//                {1, 2}, {2, 3}, {4, 2}
                {1, 2}, {5, 1}, {1, 3}, {1, 4}
        };
        System.out.println(findCenter(edges));
    }

    public static int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0]) return edges[0][0];
        if (edges[0][1] == edges[1][0]) return edges[0][1];
        return edges[1][1];
    }

}
