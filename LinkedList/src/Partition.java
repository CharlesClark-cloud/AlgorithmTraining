/**
 * ClassName: Partition
 * Package: PACKAGE_NAME
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if( head == null||head.next == null ){
            return head;
        }
        ListNode nHead = new ListNode(0);
        ListNode currentpNode = head;
        while(currentpNode.next!= null){
            currentpNode = currentpNode.next;
        }
        currentpNode.next = null;
        ListNode tail = currentpNode;
        ListNode endNode = currentpNode;
        nHead.next = head;
        currentpNode = nHead;
        while(currentpNode !=endNode){
            ListNode proNext = currentpNode.next;
            if(proNext.val>=x){
                if(proNext!= tail){
                    //放到链表最后面即可
                    //移动节点的前节点与后节点连接
                    currentpNode.next  = proNext.next;
                    //移动到最后面要指向尾节点
                    proNext.next = null;
                    //当前尾节点指向新的尾节点
                    tail.next = proNext;
                    //更新新的尾节点
                    tail = proNext;
                }
                if(proNext == endNode){
                    //遍历结束边界
                    break;
                }
            }else {
                currentpNode = currentpNode.next;
            }
        }
        return nHead.next;
    }

    public static void main(String[] args) {
//        ListNode head  = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(0);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        ListNode head  = new ListNode(1);
        head.next = new ListNode(2);

        ListNode head1 = partition(head,2);
        while (head1!=null){
            System.out.println(head1.val);
            head1 = head1.next;
        }

    }

}
