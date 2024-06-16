import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: MinStack
 * Package: PACKAGE_NAME
 */
//主要思路是用一个辅助栈存最小的元素，每次存入一个新元素时，判断她是不是比最小的小，如果不是，那她入栈以后，最小元素依旧是之前的最小元素。
    // 则辅助栈中入之前的最小元素。 若比之前的小，则辅助栈中入这个元素，因为她最小。
public class MinStack {
    private  LinkedList<Integer> list;
    private LinkedList<Integer> minList;
    public MinStack() {
        this.list = new LinkedList<>();
        this.minList  = new LinkedList<>();
        minList.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        list.add(val);
        minList.add(Math.min(minList.getLast(),val));
    }

    public void pop() {
        list.removeLast();
        minList.removeLast();
    }

    public int top() {
        return  list.getLast();
    }

    public int getMin() {
        return minList.getLast();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

