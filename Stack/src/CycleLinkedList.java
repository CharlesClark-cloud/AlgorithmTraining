import java.util.Stack;

/**
 * ClassName: CycleLinkedList
 * Package: PACKAGE_NAME
 */
public class CycleLinkedList {

    /**
     * Definition for singly-linked list.

     */

    public boolean isPalindrome(ListNode head) {
        if(head.next==null){return true;}
        Stack<Integer> stack  = new Stack<>();
        ListNode p = head;
        int count = 0;
        while(p!=null){
            count++;
            p=p.next;
        }
        p = head;
        for(int i = 0;i<count/2;i++){
            stack.push(p.val);
            p=p.next;
        }
        int start = count/2;
        if(count%2==1){
            p=p.next;
            start +=1;

        }
        for(int i = start;i<count;i++){
            if(stack.pop()!=p.val){
                return false;
            };
            p=p.next;
        }



        System.out.println(count);
        return true;
    }

    public static void main(String[] args) {
//        head =[1,2,2,1]
//        new CycleLinkedList().isPalindrome(list);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
