package cn.hua.year2021._3march.practice25;
// 82. 删除排序链表中的重复元素 II
import cn.hua.data.ListNode;

public class demo {

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6, null);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(3, listNode2);
        ListNode listNode = new ListNode(2, listNode1);
        ListNode head = new ListNode(1, listNode);
        Print(head);
        head = deleteDuplicates(head);
        Print(head);
    }


    // [题解]  递归写法
    public static ListNode deleteDuplicates1(ListNode head) {
        //baseCase
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        //如果是这种情况
        //      1 --> 1 --> 1 --> 2 --> 3
        //     head  next
        //1.则需要移动next直到出现与当前head.value不相等的情况（含null）
        //2.并且此时的head已经不能要了，因为已经head是重复的节点
        //--------------else-------------
        //      1 --> 2 --> 3
        //     head  next
        //3.如果没有出现1的情况，则递归返回的节点就作为head的子节点
        if (head.val == next.val) {
            //1
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            //2
            head = deleteDuplicates(next);
        } else {
            //3
            head.next = deleteDuplicates(next);
        }
        return head;
    }


    // 循环写法
    public static ListNode deleteDuplicates(ListNode head) {
        // 如果链表为空 或者 链表只有一个数 直接返回
        if (head == null || head.next == null) return head;

        ListNode node = new ListNode(0, head);
        ListNode p = node, now = p.next;
        int num = Integer.MAX_VALUE;    //记录 now 所在位置的值
        while (true) {
            if (num != now.val) {
                // 如果与上一个值不同则更新num
                num = now.val;
                // now.val  ?  now.next.val
                // == 则继续遍历到单独的值
                // != 即now为单独的值 则令 p.next=now 把now添加到新链表中
                if (now.val != now.next.val) {
                    p.next = now;
                    p = now;
                }
            }
            // 遍历
            now = now.next;
            if (now.next == null) {
                // 与上一个值仍相同，但已经到了链表尾，则令 p.next=null 新链表收尾
                if (num == now.val) p.next = null;
                    // 与上一个值不同，但已经到了链表尾 把now添加到新链表中
                else p.next = now;
                break;
            }
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
