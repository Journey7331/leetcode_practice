package cn.hua.year2022._5May.day15;

//  812. 最大三角形面积
// 简单题
public class largestTriangleArea {

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {0, 1},
                {1, 0},
                {0, 2},
                {2, 0},
        };
        System.out.println(largestTriangleArea(points));
    }


    public static double largestTriangleArea(int[][] points) {
        double max = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int x3 = points[k][0], y3 = points[k][1];
                    double area = calcArea(x1, y1, x2, y2, x3, y3);
                    max = Math.max(max, Math.abs(area));
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("k = " + k);
                    System.out.println("area = " + area);
                    System.out.println();
                }
            }
        }

        return max;
    }


    // S=(1/2)*(x1y2+x2y3+x3y1-x1y3-x2y1-x3y2)
    private static double calcArea(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3) {
        return (1.0 / 2) * (x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }

}
