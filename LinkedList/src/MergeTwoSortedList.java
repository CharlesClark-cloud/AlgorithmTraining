/**
 * ClassName: MergeTwoSortedList
 * Package: PACKAGE_NAME
 */
public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode virHead = new ListNode(Integer.MIN_VALUE);
        virHead.next = list1;
        ListNode pre = virHead;
        while(list2!=null&&list1!=null){
            if(list1.val>list2.val&&pre.val<= list2.val){
                ListNode insert  = list2;
                list2 = list2.next;
                insert.next = list1;
                pre.next = insert;
                pre = insert;
                continue;
            }
            list1 = list1.next;
            pre = pre.next;
        }
        if(list1 == null){
            pre.next = list2;
        }
        return virHead.next;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(-2);
        list1.next = new ListNode(5);
//        list1.next = new ListNode();
//        list1.next = new ListNode();
//        list1.next = new ListNode();
//        list1.next = new ListNode();
        ListNode list2 = new ListNode(-9);
        list2.next = new ListNode(-6);
        list2.next.next = new ListNode(-3);
        list2.next.next.next = new ListNode(-1);
        list2.next.next.next.next = new ListNode(1);
        list2.next.next.next.next.next = new ListNode(6);
//        list2.next = new ListNode();
//        list2.next = new ListNode();
//        list2.next = new ListNode();
//        list2.next = new ListNode();
//        list2.next = new ListNode();
        ListNode node = mergeTwoLists(list1, list2);
        ListNode.outPrint(node);
    }

}
