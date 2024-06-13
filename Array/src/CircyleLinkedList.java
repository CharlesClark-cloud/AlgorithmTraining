import java.util.*;

/**
 * ClassName: CircyleLinkedList
 * Package: PACKAGE_NAME
 */
public class CircyleLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = null;
//        l3.next=l4;
//        l4.next = null;
        System.out.println(new CircyleLinkedList().hasCycle(l1));
    }
    public boolean hasCycle(ListNode head) {
        //设置集合
        Set<ListNode> seen = new HashSet<ListNode>();

        while (head != null) {
            if (!seen.add(head)) {
                //证明seen.add(head)返回的false 集合里已经有了 访问过了 有回环
                return true;
            }
            head = head.next;
        }
        return false;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }


