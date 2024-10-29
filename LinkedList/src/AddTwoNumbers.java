import java.util.HashMap;

/**
 * ClassName: AddTwoNumbers
 * Package: PACKAGE_NAME
 */
public class AddTwoNumbers {
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return  l1==null?l2:l1;
        }
        //不用管长短了 直接在一个链表上进行操作 此处选择直接在l1上进行求和
        ListNode currentL1 = l1;
        ListNode currentL2  = l2;
        ListNode tailL1 = null;
        int upper = 0;
        while(currentL1!=null){
            //证明没处理完
            if(currentL2!=null){
                //l1,l2共同部分
                int sum = (currentL1.val+currentL2.val)+upper;
                currentL1.val = sum%10;
                upper = sum/10;
                currentL2 =currentL2.next;
            }else {
                //l1更长
                int sum = currentL1.val+upper;
                currentL1.val = sum%10;
                upper = sum/10;
            }
            if(currentL1.next==null){
                //记录尾节点为了方便处理最后一个进位
                tailL1 = currentL1;
            }
            currentL1 =currentL1.next;
        }
        boolean first =true;
        while(currentL2!=null){
            //l2更长
            int sum = currentL2.val+upper;
            currentL2.val = sum%10;
            upper = sum/10;
            if(first){
                //之前记录了尾节点，串到l2剩下的部分
                tailL1.next = currentL2;
                first =false;
            }
            if(currentL2.next == null){
                //更新尾节点
                tailL1 =currentL2;
            }
            currentL2 =currentL2.next;
        }
        if(tailL1!=null){
            //根据upper 判断尾节点后是否需要增加新的节点
            if(upper!=0){
                ListNode node = new ListNode(upper);
                tailL1.next = node;
            }
        }
       return  l1;
    }

    public static void main(String[] args) {
        ListNode l1  = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
        ListNode res = addTwoNumbers(l1,l2);
        while (res!=null){
            System.out.println(res.val);
            res =res.next;
        }

    }
}
