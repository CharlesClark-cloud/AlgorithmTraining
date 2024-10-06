/**
 * ClassName: DeleteDuplicates
 * Package: PACKAGE_NAME
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode  left = head;
        ListNode right = head.next;
        ListNode nHead = new ListNode();
        ListNode pre = nHead;
        while(right!=null&&left!=null){
            boolean findLast = false;
            if(left.val == right.val){
                while(left.val==right.val){
                    right = right.next;
                    if(right == null){
                        findLast = true;
                        break; // 找到最后都是重复的
                    }
                }
                //找到重复数字的前缀
                //找到不等于的值了 直接链接
                if(!findLast){
                    pre.next = right;
                    left = right;
                    right=right.next;
                    continue;
                }

            }
            if(findLast){
                //一下找到最后了
                pre.next = right;
                break;
            }else{
                //正常
                pre.next = left;
                pre = left;
                left = left.next;
                right = right.next;
            }
        }
        return nHead.next;
    }
}
