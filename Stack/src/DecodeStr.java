import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import static java.util.Collections.list;
import static java.util.Collections.reverse;

/**
 * ClassName: DecodeStr
 * Package: PACKAGE_NAME
 */
public class DecodeStr {
    public String decodeString(String s) {
        String res = "";
        String reversedStr="";
        String multiStr = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar!=']'){
                stack.push(currentChar);
            }
           else if(currentChar==']'){
                String currentStr = "";
                while (true){
                    Character nowChar = stack.pop();
                    if(nowChar=='['){
                        break;
                    }
                    currentStr+=nowChar;
                }
                reversedStr = reverseStr(currentStr);
//                System.out.println(reversedStr+" revesed");
                //此时栈顶一定是数字
                multiStr = "";

                int strNum = 0;
                int count =1;
                while(true){
                    if(!stack.isEmpty()){
                        Character top = stack.peek();
                        if(top-'0'>=0&&top-'0'<=9){
                            strNum+=count*(top-'0');
                            count*=10;
                            stack.pop();
                        }else {
                            System.out.println();
                            break;
                        }
                    }else {
                        break;
                    }


                }


//                System.out.println(strNum+" shuzi");
                for (int j = 0; j < strNum; j++) {
                    multiStr+=reversedStr;
                }
                //此时multiStr 就是内部的一个解码后的字符串
                //然后全部入栈
//                System.out.println(multiStr+" fuzhihou");
                for (int j = 0; j < multiStr.length(); j++) {
                    stack.push(multiStr.charAt(j));
                }

            }
        }
        //处理完毕栈中剩下处理好的数据了
        if(!stack.isEmpty()){
            String lastStr = "";
            while (!stack.isEmpty()){
                lastStr+=stack.pop();
            }
            lastStr = reverseStr(lastStr);
            res = lastStr;
        }

        return  res;
    }
    public String reverseStr(String currentStr){
        char[] charArray = currentStr.toCharArray();
        //反转数组
        for (int j = 0; j < charArray.length/2; j++) {
            Character temp = charArray[charArray.length-1-j];
            charArray[charArray.length-1-j] = charArray[j];
            charArray[j]=temp;
        }
        String reversedStr = "";

        for (int j = 0; j < charArray.length; j++) {
            reversedStr+=charArray[j];
        }
        return  reversedStr;
    }

    public static void main(String[] args) {

//        System.out.println(new DecodeStr().decodeString("3[a2[c]]"));
        System.out.println("-------");

//        System.out.println(new DecodeStr().decodeString("3[a]3[c]2[bc]"));
        System.out.println(new DecodeStr().decodeString("100[leetcode]"));
    }
}
