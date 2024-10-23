import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: RingList
 * Package: PACKAGE_NAME
 */
public class RingList {
    public  static ListNode detectCycle(ListNode head) {
//        环形链表，使用set值唯一的特性 但是空间复杂度为O（N）
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while(current!=null){
            if(!set.add(current)){
                return  current;
            }
            current = current.next;
        }
        return null;
    }
    public  static ListNode detectCycleWithTwoPointer(ListNode head) {
//        环形链表，双指针 空间复杂度为O（1）
        if(head == null||head.next == null){
            return  null;
        }
        ListNode slow =head;
        ListNode fast = head.next;
        while (slow!=null&&fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
            if(slow == fast){
                ListNode ptr = head;
                while(ptr!=slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return  ptr;
            }
        }

        return null;
    }

}
