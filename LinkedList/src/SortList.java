/**
 * ClassName: SortList
 * Package: PACKAGE_NAME
 */
public class SortList {
//    public static ListNode sortList(ListNode head) {
//        //最笨的方法 查找排序 超时
//
//        ListNode virHead  = new ListNode();
//        virHead.next = head;
//        int length = 0;
//        ListNode current = head;
//        while (current!=null){
//            length++;
//            current = current.next;
//        }
//        ListNode pre =null;
//        for(int i = 0;i<length;i++){
//            pre = virHead;
//            current = virHead.next;
//            //根据i 跨过已经排过序的，
//            for(int j = 0;j<i;j++){
//                pre = pre.next;
//                current = current.next;
//            }
//            ListNode min = current;
//            ListNode sortedTail = pre;
//            ListNode minPre = pre;
//
//            //开始找没有拍序的最小的
//            while(current!=null){
//                if(current.val<min.val){
//                    minPre = pre;
//                    min = current;
//                }
//                pre =pre.next;
//                current =current.next;
//            }
//            //此时min指向最小值的节点
//            //minpre 指向最小的前节点
//
//
//            //进行连接
//            minPre.next = min.next;
//            min.next = sortedTail.next;
//            sortedTail.next = min;
//        }
//
//        return virHead.next;
//
//    }
    public static ListNode sortListWithTraversal(ListNode head){
//        首先明确一点 每次找到两个当前的子链表，然后排序，因为遍历是自底向上，所以开始从每一个节点开始
        if(head == null){
            return  head;
        }
        ListNode current = head;
        int length= 0;
        while (current!=null){
            length++;
            current = current.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for(int subLength = 1;subLength<length;subLength<<=1){
            //每次循环处理完 子链表长度翻倍 1—2-4-8
            ListNode prev =  dummy;  current =dummy.next;
            while (current!=null){
                //找到第一个子串
                ListNode head1 = current;
                for(int i= 1;i<subLength&&current.next!=null;i++){
                    current = current.next;
                }
                //第一个子串寻找结束 此时head1 指向第一个子串

                //开始寻找第二个子串 此时第一个子串后便是第二个子串开始的位置
                ListNode head2 = current.next;
                current.next = null;//将第一个子串与后面部分断开
                current = head2;//指向第二个子串头部
                for(int i=1;i<subLength&&current!=null&&current.next!=null;i++){
                    current = current.next;
                }
                //两个字串都寻找完成
                //next 记录剩下未处理的部分
                ListNode next = null;
                if(current!=null){
                    next = current.next;//next 连接还未处理的部分
                    current.next = null; //将第二个字串与未处理部分断开
                }
                ListNode merged = mergeTwoLists(head1,head2);
                prev.next = merged;//合并后的链表衔接到之前处理完的部分
                //然后移动prev
                while(prev.next!=null){//保证停留在尾节点
                    prev = prev.next;
                }
                current = next;

            }
        }
        return  dummy.next;
    }

    public static ListNode sortList(ListNode head) {
//        思路就是从上向下分 一次分成两半
//        直到分为自身， 此时head.next = tail; 此时自身有序，然后返回即可，return head；
//        返回到上一层 进行合并，merge l1，l2，依次返回 递归。

        return   sort(head,null);
    }
    public static ListNode sort(ListNode head,ListNode tail){
        //自顶向下进行排序 拆分 递归方法
        if(head == null){
            //空链表 return head 或者 return null 都一样
            return  head;
        }
        if(head.next == tail){
            //只有一个节点 此时返回自身 因为自身已经是有序的
            head.next = null;
            return  head;
        }
        //二个指针
        ListNode slow = head,quick = head;
        while (quick!=tail){
            slow = slow.next;
            quick = quick.next;
            if(quick!=tail){
                quick = quick.next;
            }
        }
        //目前慢指针指向节点中间  快指针指向节点的尾部 链表分为了两段
        ListNode mid = slow;
        ListNode list1 = sort(head,mid);
        ListNode list2 = sort(mid,tail);
        ListNode stored = mergeTwoLists(list1, list2);
        return stored;
    }
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
        ListNode head = new ListNode(1);
        head = sortList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

}
