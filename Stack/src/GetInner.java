import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: GetInner
 * Package: PACKAGE_NAME
 /*
 输入：((2 + 3) + (3 * 4)) + 2
 输出：
 [
 '2 + 3',
 '3 * 4'，
 '(2 + 3) + (3 * 4)',
 ]
 输入： (()
 输出：error

 输入：(((2 + 3) + (3 * 4))+(1*2)) + 2
 输出：
 [
 '2 + 3',
 '3 *   4'，
 '(2 + 3) + (3 * 4)',
 '1*2',
 (2 + 3) + (3 * 4))+(1*2)

 ]
 */

public class GetInner {
    public static List<String> getInside(String in){
        List<String> res = new ArrayList<>();
        char[] charArray = in.toCharArray();
        int n = charArray.length;
        for (int i = 1; i < n; i++) {
            if(charArray[i]==')'){
                int currentRight = 1;
                int currentIndex = i-1;
                // 出栈找答案  ((2 + 3) + (3 * 4)) + 2
                //同进入另一个栈
                StringBuilder sb = new StringBuilder();
                while (currentRight!=0&&currentIndex>=0){
                    char currChar = charArray[currentIndex];
                    if( currChar== '('){
                        //判断是否是左边界
                        currentRight--;
                        if(currentRight==0){ // 说明此处的左括号是左边界
                            break;
                        }else {
                            sb.append(charArray[currentIndex]);// 说明左括号也是答案的一部分
                        }
                    } else if (currChar==')') {
                        sb.append(charArray[currentIndex]);
                        currentRight++;
                    }
                    else {
                        // 不是边界
                        sb.append(charArray[currentIndex]);

                    }
                    currentIndex--;
                }
                if(currentRight == 0){
                    res.add(sb.reverse().toString());
                }else {
                    return  null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> inside = getInside("(((2 + 3) + (3 * 4))+(1*2)) + 2");
        if(inside==null){
            System.out.println("Error");
        }else {
            inside.stream().forEach(System.out::println);
        }
    }
}
