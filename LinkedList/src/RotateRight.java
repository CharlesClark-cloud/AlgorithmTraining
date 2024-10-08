/**
 * ClassName: RotateRight
 * Package: PACKAGE_NAME
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode process = head;
        int length = 0;
        while(process.next!=null){
            length++;
            process = process.next;
        }
        length++;
        //此时process停留在最后一个节点的位置
        int rotateLength = k%length;//真正需要移动的长度
        int findPosition = length - rotateLength;
        if(k==0||rotateLength==0){
            return  head;
        }
        ListNode position = head;
        for(int count = 1;count!=findPosition;position = position.next){
            count++;
        };
        ListNode nHead = position.next;//新头节点
        position.next = null;//成为尾部
        process.next = head;//将原来的尾部与之前的头部链接
        return  nHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode node = rotateRight(head, 3);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }


    }

}
