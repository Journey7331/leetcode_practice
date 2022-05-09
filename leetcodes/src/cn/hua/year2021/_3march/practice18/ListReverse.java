package cn.hua.year2021._3march.practice18;
// 92. 反转链表 II
import cn.hua.data.ListNode;

/*
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 */


public class ListReverse {

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(5, null);
        ListNode listNode3 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);
        ListNode head = new ListNode(1, listNode1);
        Print(head);
        reverseBetween(head, 2, 4);
        Print(head);

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

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        //把不需要反转的部分遍历掉
        //需要反转的部分头插法反转
        //  1(pre) 2(head) 3(nex)  4      5
        //  1(pre) 3       2(head) 4(nex) 5
        //  1(pre) 4       3       2      5
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 1; i < left; i++)
            pre = pre.next;

        //类似于遍历变量节点
        head = pre.next;
        for (int i = left; i < right; i++) {
            ListNode nex = head.next;
            //head节点连接nex节点之后链表部分，也就是向后移动一位   即 2->4
            head.next = nex.next;
            //nex节点移动到需要反转链表部分的首部  即 3->2
            nex.next = pre.next;
            //pre继续为需要反转头节点的前驱节点  即 1->3
            pre.next = nex;
        }
        return dummy.next;
    }

//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode newnode = new ListNode(0, head);
//        ListNode pre = newnode;
//        for (int i = 1; i < left; i++) {
//            pre = pre.next;
//        }
//        for (int i = left; i < right; i++) {
//            ListNode node = pre.next;
//            pre.next = node.next;
//            node.next = node.next.next;
//            pre.next.next = node;
//        }
//
////  1(pre) 2(head) 3(nex)  4      5
////  1(pre) 3       2(head) 4(nex) 5
////  1(pre) 4       3       2      5
//
//
//        ListNode tmp = new ListNode(0);
//        tmp.next = head;
//        int i = 1;
//        while (true) {
//            if (i >= left && i <= right) {
//                ListNode node = tmp.next;
//                tmp.next = node.next;
//                node.next = node.next.next;
//                tmp.next.next = node;
//            } else {
//                tmp = tmp.next;
//            }
//            i++;
//
//            if (head.next != null) {
//                System.out.print("->");
//                head = head.next;
//            } else {
//                System.out.print("->NULL");
//                break;
//            }
//        }
//
//        return tmp;
//}


}


