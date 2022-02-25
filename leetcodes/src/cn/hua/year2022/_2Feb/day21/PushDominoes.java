package cn.hua.year2022._2Feb.day21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// 838. 推多米诺
// 中等题
public class PushDominoes {

    public static void main(String[] args) {
//        System.out.println(pushDominoes("RR.L"));
        System.out.println(pushDominoes(".L.R...LR..L.."));

    }

    // 模拟
    /*
     * 先录入初始为 R/L 的 Card 到队列中
     * 每轮取出队列中的全部 Card, 对相邻的 Card 进行 push
     * 被 push 的 Card 加入队列, 再进行下一轮 push
     *
     * .L.R...LR..L..
     *  1 1   11  1
     * .\./...\/..\..
     * 2   2 2  22
     * \\.//.\\//\\..
     *      3
     * \\.///
     *
     * */
    public static String pushDominoes(String dominoes) {
        ArrayList<Card> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int n = dominoes.length();
        for (int i = 0; i < n; i++) {
            char c = dominoes.charAt(i);
            list.add(new Card(c));
            if (c != '.') queue.add(i);
        }
        for (int i = 1; i <= n; i++) {
            if (queue.isEmpty()) break;
            while (!queue.isEmpty()) {
                pushCard(i, queue.poll(), list, queue);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Card card : list) ans.append(card.c);
        return ans.toString();
    }

    private static void pushCard(int round, int i, ArrayList<Card> list, Queue<Integer> queue) {
        Card thisCard = list.get(i);
        thisCard.round = round;

        i += (thisCard.c == 'R' ? 1 : -1);
        int n = list.size();
        if (i < 0 || i >= n) return;

        Card card = list.get(i);

        // 正常push
        if (card.c == '.' && card.round == 0) {
            card.c = thisCard.c;
            queue.add(i);
            return;
        }

        // 左侧被访问过, 且是`/`, 当前是`\`, =>`/|\`
//            if (card.visited && card.c == 'R' && thisCard.c == 'L') {
//                card.c = '.';
//                return;
//            }

        // 轮数相同时 (这时邻居不会是`.`)
        // 相同方向, 则不必再push, =>`//`或`\\`
        // 不同方向, `//\`=>`/|\`
        if (thisCard.round == card.round && thisCard.c != card.c) {
            card.c = '.';
            card.round = round;
        }

    }

    static class Card {
        char c;
        int round;

        public Card(char status) {
            this.c = status;
            this.round = 0;
        }
    }

}
