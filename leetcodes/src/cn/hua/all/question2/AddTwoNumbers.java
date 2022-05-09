package cn.hua.all.question2;

import cn.hua._utils.LNode;
import cn.hua.data.ListNode;

// 2. 两数相加
// 中等题
// 合并两个链表, 模拟加法计算
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l3 = LNode.reverseList(LNode.numStringToListNode("1234"));
        LNode.printListNode(l3);
        ListNode l4 = LNode.reverseList(LNode.numStringToListNode("6"));
        LNode.printListNode(l4);
        LNode.printListNode(addTwoNumbers(l3, l4));

        l3 = LNode.reverseList(LNode.numStringToListNode("5"));
        LNode.printListNode(l3);
        l4 = LNode.reverseList(LNode.numStringToListNode("5"));
        LNode.printListNode(l4);
        LNode.printListNode(addTwoNumbers(l3, l4));

        l3 = LNode.reverseList(LNode.numStringToListNode("9999999"));
        LNode.printListNode(l3);
        l4 = LNode.reverseList(LNode.numStringToListNode("9999"));
        LNode.printListNode(l4);
        LNode.printListNode(addTwoNumbers(l3, l4));


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), cursor = ans;
        int carry = 0;

        while (l1 != null || l2 != null) {
            // 这里这样处理, 就不需要额外再写两个 while循环
            int x = 0, y = 0, val;
            if (l1 != null) x = l1.val;
            if (l2 != null) y = l2.val;

            val = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            cursor.next = new ListNode(val);
            cursor = cursor.next;

            // 对应前面的两个, 本质上和再写两个 while 一样的效果
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 最高位的进位
        if (carry != 0) cursor.next = new ListNode(carry);

        return ans.next;
    }

    // 更简洁的写法
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(-1), pre = dummyHead;
            int t = 0;
            while (l1 != null || l2 != null || t != 0) {
                if (l1 != null) {
                    t += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    t += l2.val;
                    l2 = l2.next;
                }
                pre.next = new ListNode(t % 10);
                pre = pre.next;
                t /= 10;
            }

            return dummyHead.next;
        }
    }


    // 笨方法 ( 额外两个while )
    // 而且会有函数内和函数外的 cursor carry 变化不统一的情况, 导致最高位的进位出错
    private static void addContinue(ListNode l, ListNode cursor, int carry) {
        while (l != null) {
            int x = l.val;
            int val = (x + carry) % 10;
            carry = (x + carry) / 10;
            cursor.next = new ListNode(val);

            cursor = cursor.next;
            l = l.next;
        }
    }


}
