import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * ClassName: ValidParentheses
 * Package: PACKAGE_NAME
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('{');set.add('[');set.add('(');
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if(set.contains(currentChar)){
                stack.push(currentChar);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if((currentChar == '}' && stack.pop()!='{')){
                    return  false;
                }
                else if ((currentChar == ']' && stack.pop()!='[')){
                    return  false;
                }else if((currentChar == ')' && stack.pop()!='(')){
                    return  false;
                }

            }
        }
        return stack.isEmpty();
    }
    public  boolean officialMethod(String s){
        //栈里放匹配的另一半
        Stack<Character> sta = new Stack<>();
        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if(data[i] == '('){
                sta.push(')');
            } else if (data[i]=='[') {
                sta.push(']');
            } else if (data[i]=='{') {
                sta.push('}');
            } else if (sta.isEmpty() || data[i]!=sta.pop()) {
                return false;
            }
        }
        return sta.isEmpty();
    }

    public static void main(String[] args) {
        String parentheses = "[[[]{({}[][])}]]";
        System.out.println(new ValidParentheses().isValid(parentheses));
    }

}
