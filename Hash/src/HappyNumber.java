/**
 * ClassName: HappyNumber
 * Package: PACKAGE_NAME
 */
public class HappyNumber {
    //关键就是如何破循环，此方法是快慢指针，一个每次走两步，一个每次走一步，如果有循环必碰面
    //一旦碰面就不是。
//    如果不碰面，肯定是等1了(可以自选快指针或慢指针)。
//

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast!=slow&&fast!=1){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return  fast==1;

    }
    public int getNext(int process){
        int next =0;
        while(process>0){
            int last = process%10;
            next+=last*last;
            process/=10;
        }
        return  next;
    }
    public static void main(String[] args) {
        int num = 19;
        System.out.println(new HappyNumber().isHappy(num));
    }

}
