/**
 * ClassName: SwapPairs
 * Package: PACKAGE_NAME
 */
public class SwapPairs {
    public ListNode swapPairsWithRecursion(ListNode head) {
        //首先明确递归结束边界
        //当没有或者只有一个节点的时候递归结束
        if(head == null || head.next == null){
            return  head;
        }
        //否则进行交换
        ListNode newHead = head.next;//第二个节点
        head.next = swapPairs(newHead.next);//第二个节点后面的节点
        newHead.next = head;
        return newHead;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode front = dummy.next;
        ListNode back = front.next;
        while(front!=null&&front.next!=null){
            //交换两个节点时,上一次交换已经完成，此时，只有两种情况，后面一个也没有了，就是front 为null
            // 或者还有一个那就是front 不为null，但是front.next 会为null
            front.next = back.next;
            pre.next = back;
            back.next = front;
            pre = front;
            front = pre.next;
            if(front!=null){
                back = front.next;
            }
        }
        return dummy.next;

    }
}
