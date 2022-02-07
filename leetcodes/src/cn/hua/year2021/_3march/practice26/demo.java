package cn.hua.year2021._3march.practice26;

import cn.hua.year2021._3march.data.ListNode;
// 83. 删除排序链表中的重复元素
public class demo {

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(3, null);
        ListNode listNode5 = new ListNode(3, listNode6);
        ListNode listNode4 = new ListNode(3, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = new ListNode(1, listNode1);
        ListNode head = new ListNode(0, listNode);
        Print(head);
        head = deleteDuplicates(head);
        Print(head);

    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0, head);
        ListNode p = node;
        while (p.next != null) {
            ListNode now = p.next;
            if (now.next != null && now.val == now.next.val) p.next = now.next;
            else p = p.next;
        }
        return node.next;
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
