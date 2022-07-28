package cn.hua.year2022._7Jul.day24;

// 1184. 公交站间的距离
// 简单题
public class DistanceBetweenBusStops {

    // 模拟遍历
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int sumA = 0, sumB = 0;
        for (int i = start; i != destination; i = (i + 1) % n) {
            sumA += distance[i];
        }
        for (int i = start + n - 1; i % n != (destination + n - 1) % n; i--) {
            sumB += distance[i % n];
        }
        return Math.min(sumA, sumB);
    }

    // 单次正遍历
    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        int d1 = 0, d2 = 0;
        int l = Math.min(start,destination);
        int r = Math.max(start,destination);
        for(int i=0;i<distance.length;i++){
            if(i>=l && i<r){d1 += distance[i];}
            else{d2 += distance[i];}
        }
        return d1<d2?d1:d2;
    }

}
