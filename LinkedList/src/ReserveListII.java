import java.util.List;

/**
 * ClassName: ReserveListII
 * Package: PACKAGE_NAME
 */
public class ReserveListII {

    public static  ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        // 用于找到 left 之前的节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pleftpre = dummy; // 这里我们设置一个虚拟头节点，方便处理 left = 1 的情况

        // 找到 pleftpre 和 pleft
        for (int i = 1; i < left; i++) {
            pleftpre = pleftpre.next;
        }
        ListNode pleft = pleftpre.next; // 这是需要反转的第一个节点

        // 找到 pright 和 prightnext
        ListNode pright = pleft;
        for (int i = left; i < right; i++) {
            pright = pright.next;
        }
        ListNode prightnext = pright.next;

        // 开始反转 left 到 right 之间的节点
        ListNode ppre = prightnext;
        ListNode pcurrent = pleft;
        while (pcurrent != prightnext) {
            ListNode nextNode = pcurrent.next;
            pcurrent.next = ppre;
            ppre = pcurrent;
            pcurrent = nextNode;
        }

        // 将反转后的部分接回链表
        pleftpre.next = ppre;

        return dummy.next;
    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 构建链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // 反转链表
        head = reverseBetween(head,2,4);

        System.out.println("Reversed List:");
        printList(head);
    }



}
