import java.util.*;

/**
 * ClassName: PhoneNumberCombination
 * Package: PACKAGE_NAME
 */
public class PhoneNumberCombination {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       Map<Character,String> map =new HashMap<>(){{
           put('2', "abc");
           put('3', "def");
           put('4', "ghi");
           put('5', "jkl");
           put('6', "mno");
           put('7', "pqrs");
           put('8', "tuv");
           put('9', "wxyz");
       }};
        Deque<String> deque = new ArrayDeque<>();
        char[] digit = digits.toCharArray();
        for (char c:digit) {
            String  cases = map.get(c);
            char[] charArray = cases.toCharArray();
            if(deque.isEmpty()){
                //初始为空的情况
                for ( char onecase:charArray) {
                    deque.add(onecase+"");
                }
            }else {
                List<String> dequeUpdate = new ArrayList<>();
                while (!deque.isEmpty()){
                    //栈中元素全部取出放入列表中
                    dequeUpdate.add(deque.pop());
                }
                //栈不为空说明里面有字符串
                for (int i = 0; i < charArray.length; i++) {
                    for (int j = 0; j < dequeUpdate.size(); j++) {
                        String newS = dequeUpdate.get(j)+charArray[i];
                        deque.add(newS);
                    }
                }
            }

        }

        while (!deque.isEmpty()){
            res.add(deque.pop());
        }
        System.out.println(res);

        return  res;
    }
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuffer stringBuffer = new StringBuffer();
        backtrack(combinations, phoneMap, digits, 0,stringBuffer );
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

        public static void main(String[] args) {
            new PhoneNumberCombination().letterCombinations2("234");

        }
}
