/**
 * ClassName: MergeKLists
 * Package: PACKAGE_NAME
 */
public class MergeKLists {
    public ListNode mergeKListsWithRecursion(ListNode[] lists) {
//        参考二分查找
        return  merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r){
//            自身
            return  lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)>>1;
        //二分合并哈哈
        return mergeTwoSortedList(merge(lists,l,mid),merge(lists,mid,r));
    }
    public ListNode mergeKLists(ListNode[] lists) {
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
        //思路是两两的合并 从下向上的 归并
        return lists[0];
    }
    public static ListNode mergeTwoSortedList(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return  l1==null?l2:l1;
        }
        // 合并两个链表   直接在一个上面操作
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = l1;
        ListNode pre = dummy;
        ListNode l2Next;
        while(l1!=null && l2!=null){
            //l1 l2 都不空
            if(l2.val>=pre.val&&l1.val>l2.val){
                l2Next= null;
                // 找到插入的的位置
                if(l2.next!=null){
                    l2Next = l2.next;
                }
                pre.next = l2;
                l2.next = l1;
                pre = pre.next;
                l2 = l2Next;

            }else if(l2.val >= l1.val){
                pre = l1;
                l1 = l1.next;
            }
        }
        //l1 !=null 那一定是l2 为null 那不用管
        //l2 !=null 那就是l1 为null
        if(l2!=null){
            pre.next = l2;
        }
        return dummy.next;
    }
}
