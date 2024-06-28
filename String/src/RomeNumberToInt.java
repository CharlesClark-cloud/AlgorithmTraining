import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: RomeNumberToInt
 * Package: PACKAGE_NAME
 */
public class RomeNumberToInt {
    public int romanToInt(String s) {
        //题目很简单，单个字符映射处理，判断下一个字符是否比当前字符大，（若大则表示当前字符与下一个字符为一个组合），
        // 当前字符需要变为对应负值，依次累加即可。因为数组处理边界问题，最后将字符的最后一位加上即可。
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] charArray = s.toCharArray();
        int currentNum = 0;
        int nextNum = 0;
        for (int i = 0; i < charArray.length-1; i++) {
            currentNum =map.get(charArray[i]);
            nextNum = map.get(charArray[i+1]);
            if(nextNum>currentNum){
                currentNum = -currentNum;
            }
            res+=currentNum;
        }
        res+=map.get(charArray[charArray.length-1]);
        return  res;

    }

    public static void main(String[] args) {
        String romeNumber = "MDCCCLXXXIV";
        System.out.println(new RomeNumberToInt().romanToInt(romeNumber));
    }
}
