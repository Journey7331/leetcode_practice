package cn.hua;

import java.util.ArrayList;
import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        ArrayList<People> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            list.add(new People(i, sc.nextInt()));
        }
        for (People people : list) {
            people.rank = sc.nextInt();
        }

        list.sort((o1, o2) -> {
            if (o1.rank != o2.rank) {
                return o2.rank - o1.rank;
            } else if (o1.score == o2.score) {
                return o1.id - o2.id;
            }
            return o2.score-o1.score;
        });

        System.out.println(list);
    }


    static class People{
        int id;
        int score;
        int rank;

        public People(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return "People{" +
                    "id=" + id +
                    ", score=" + score +
                    ", rank=" + rank +
                    '}';
        }
    }

}
