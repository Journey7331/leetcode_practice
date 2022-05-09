package cn.hua._utils;

import cn.hua.data.ListNode;

public class LNode {

    public static void main(String[] args) {
        printListNode(numStringToListNode("123"));
        printListNode(reverseList(numStringToListNode("123")));

    }


    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.print("NULL\n");
            return;
        }
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

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode node = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            if(next == null){
                node = current;
            }
            current.next = prev;
            prev = current;
            current = next;
        }
        return node;
    }

    public static ListNode numStringToListNode(String num) {
        ListNode ans = new ListNode(), node = ans;
        for (char c : num.toCharArray()) {
            node.next = new ListNode(Integer.parseInt(c + ""), null);
            node = node.next;
        }
        return ans.next;
    }

}
