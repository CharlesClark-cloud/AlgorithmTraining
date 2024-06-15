import java.util.Stack;

/**
 * ClassName: Temperatures
 * Package: PACKAGE_NAME
 */
public class Temperatures {

    public static void main(String[] args) {
        int [] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int [] temperatures2 = new int[]{30,40,50,60};
        //                              [1,1,4,2,1,1,0,0]
        new Temperatures().dailyTemperatures(temperatures2);
    }
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈 要点栈中存的并不是温度值 而是温度值所对应的日期 也就是下标
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]) {
                int top = stack.pop();
                res[top]=i-top;
            }
            stack.push(i);
        }
        res[res.length-1]=0;
        for (int i = 0;  i< res.length; i++) {
            System.out.println(res[i]+" ");
        }
        return res;
    }
}
