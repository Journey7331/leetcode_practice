package cn.hua.year2022._6Jun.day18;

// 剑指 Offer II 029. 排序的循环链表
// 中等题
public class Insert {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node p = head.next, q = head;
        while (p != head) {
            if (p.val >= insertVal && q.val <= insertVal) break;
            if (p.val < q.val && (p.val>= insertVal || q.val <= insertVal)) break;
            q = q.next;
            p = p.next;
        }
        q.next = new Node(insertVal, p);
        return head;
    }


    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}

