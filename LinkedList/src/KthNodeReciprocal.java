/**
 * ClassName: KthNodeReciprocal
 * Package: PACKAGE_NAME
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class KthNodeReciprocal {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null){return  null;}
        ListNode pre = null; //前缀节点
        ListNode find = head; //k步长末尾
        ListNode nNode= null; //倒数第n个节点
        int count =1; //节点计数器
        while (find!=null){
            //节点少于k个直接后移
            if(count>=n){
                if(count==n){
                    //第n个 启动n节点
                    nNode = head;
                }
                if(count==n+1){
                    //第n+1个 启动n节点前缀节点
                    pre = head;
                };
                if(count>n){
                    //n节点后移 n节点为空时步
                    nNode =nNode.next;
                }
                if(count>n+1){
                    pre =pre.next;
                }
            }
            find = find.next;
            count++;
        }
        if(nNode!=null&&pre!=null){
            //前缀和n节点都找到，直接串接
            pre.next = nNode.next;
        } else if(pre==null){
            //n 节点找到了，但是前缀没有，此时是删除了列表的第一个值，因此直接返回头节点以后的连标即可
            return head.next;
        }

        return  head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=null;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=null;
        ListNode node = new KthNodeReciprocal().removeNthFromEnd(n1, 1);
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
