import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: SimpleCalculator
 * Package: PACKAGE_NAME
 */
public class SimpleCalculator {
    public  static int calculate(String s) {
        //首先确保只有一个栈存放值 符号直接运算
        Deque<Integer> stack = new ArrayDeque<>();
        char preSignal  = '+';
        int num = 0;
        for(int i=0;i<s.length();i++){
            //如果此时符号为数字
            if(Character.isDigit(s.charAt(i))){
                //其实此时如果是数字的话 preSignal 存的也是数字
                num = num*10+s.charAt(i)-'0';//num*10 如果前面也是数字则要扩大，然后加上现在的数 就是这个数字
            }
            //如果此时不是数字
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==s.length()-1){
                //最后一位一定是数字
                switch(preSignal){
                    case '+':
                        //上一个符号是 加号 直接将这个数字放入栈中
                        stack.addFirst(num);
                        break;
                    case '-':
                        //上一个是减号 相反数放入栈中
                        stack.addFirst(-num);
                        break;
                    case '*':
                        //上一个号是乘号，也就是现在这个数字之前是乘号， 则将这个数字与栈顶的数字直接相乘就行。记得放入栈中
                        stack.addFirst(stack.pollFirst()*num);
                        break;
                    default:
                        stack.addFirst(stack.pollFirst()/num);

                }
                //能到这里说明是符号的话已经运算完，是数字的话已经入栈了，数字要归零 为下一次储存数字作准备
                preSignal = s.charAt(i);
                num = 0; //


            }
        }
//        循环结束以后 栈中只剩下数字了 直接求和就行
        int ans = 0;
        while (!stack.isEmpty()){
            ans+=stack.pop();
        }
        return  ans;


    }

    public static void main(String[] args) {
        System.out.println(calculate("12+2*9+6-9+7-10*3"));
    }

}
