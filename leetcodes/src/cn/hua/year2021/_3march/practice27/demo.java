package cn.hua.year2021._3march.practice27;
// 61. 旋转链表
import cn.hua.data.ListNode;

public class demo {

    public static void main(String[] args) {
        ListNode node6 = new ListNode(3, null);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(2, null);
        ListNode node0 = new ListNode(1, node1);
        ListNode head1 = new ListNode(0, node0);
        Print(head1);
        head1 = rotateRight(head1, 4);
        Print(head1);
    }


    // 1
    // 连成环再截断
    public static ListNode rotateRight(ListNode head, int k) {
        // 为空或者只有一个数
        if (head == null || head.next == null) return head;

        int cnt = 1;
        ListNode h = head;
        for (; h.next != null; cnt++) h = h.next;
        h.next = head;  // 成环
        for (int i = 0; i < (cnt - k % cnt) - 1; i++, head = head.next) ;
        ListNode node = head.next;
        head.next = null;
        return node;
    }


    // 2
    // 截断再连接
    public static ListNode rotateRight0(ListNode head, int k) {
        // 为空或者只有一个数
        if (head == null || head.next == null) return head;

        int cnt = 1;
        for (ListNode h = head; h.next != null; cnt++) h = h.next;
        k = k % cnt;    // k%cnt 把无效移动去掉
        if (k == 0) return head;

        ListNode node = head;
        for (int i = 0; i < (cnt - k) - 1; i++, head = head.next) ;
        ListNode last = head;   // 新尾
        ListNode tmp = node;    // 旧头
        node = head.next;    // 新头

        while (head.next != null) head = head.next;
        head.next = tmp;    // 旧尾连旧头
        last.next = null;   // 新尾指null
        return node;
    }


    // 3
    // 暴力移动解法
    public static ListNode rotateRight1(ListNode head, int k) {
        // 为空或者只有一个数
        if (head == null || head.next == null) return head;

        int cnt = count(head);
        k = k % cnt;    // k%cnt 把无效移动去掉
        if (k == 0) return head;
        for (int i = 0; i < k; i++) head = fun(head);
        return head;
    }

    // 链表计数
    private static int count(ListNode head) {
        int cnt = 1;
        while (head.next != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    // 向右移动一次
    public static ListNode fun(ListNode head) {
        ListNode node = head;
        if (head.next.next == null) {
            node = head.next;
            node.next = head;
            head.next = null;
            return node;
        }
        while (head.next.next != null) head = head.next;
        ListNode tmp = node;
        node = head.next;
        node.next = tmp;
        head.next = null;
        return node;
    }


    private static void Print(ListNode head) {
        while (true) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
                head = head.next;
            } else {
                System.out.print("->NULL\n");
                break;
            }
        }
    }

}
