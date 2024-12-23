/**
 * ClassName: ListNode
 * Package: PACKAGE_NAME
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public  static  void outPrint(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists.length == 1){
            return lists.length==0?null:lists[0];
        }
        //用迭代的方法 每次两个 下次变为四个
        for(int i = 1;i<lists.length;i<<=1){
            //此时，间隔为1 表示每两个都要合并
            for(int j = 0;j<lists.length;j+=(i<<1)){
                if(j+i<lists.length){
                    lists[j] = mergeTwoSortedList(lists[j],lists[j+i]);
                }
            }
        }

        //思路是两两的合并 从下向上的 归并排序
        return lists[0];
    }
    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1==null||l2==null){
            return  l1==null?l2:l1;
        }
        // 合并两个链表   直接在一个上面操作
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = l1;
        ListNode pre = dummy;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        while(currentL1!=null && currentL2!=null){
            //l1 l2 都不空
            if(currentL2.val>=pre.val&&currentL1.val>currentL2.val){
                // 找到插入的的位置
                ListNode l2Next = null;
                if(currentL2.next!=null){
                    l2Next = currentL2.next;
                }
                pre.next = currentL2;
                currentL2.next = currentL1;
                pre = pre.next;
                currentL2 = l2Next;

            }else if(currentL2.val >= currentL1.val){
                pre = currentL1;
                currentL1 = currentL1.next;
            }
        }
        //l1 !=null 那一定是l2 为null 那不用管
        //l2 !=null 那就是l1 为null
        if(currentL2!=null){
            pre.next = currentL2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode l1  = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(5);
////        l1.next.next.next  = new ListNode(7);
//
////        ListNode l2 =null;
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
////        l2.next.next.next  = new ListNode(5);
//
//        ListNode l3 =new ListNode(2);
//        l3.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{null,new ListNode(1)};

        ListNode node =mergeKLists(lists);

        outPrint(node);


    }
}
