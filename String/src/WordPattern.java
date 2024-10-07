import java.util.HashMap;

/**
 * ClassName: WordPattern
 * Package: PACKAGE_NAME
 */
public class WordPattern {
    public  static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        HashMap<Character,String> words = new HashMap<>();
        HashMap<String,Character> map = new HashMap<>();
        for(int i = 0;i<chars.length;i++){
            char currentChar = chars[i];
            String currentStr = strs[i];
            String getStr = words.get(currentChar);
            Character getChar = map.get(currentStr);
            if( getStr == null&&getChar == null){
                words.put(currentChar,currentStr);
                map.put(currentStr,currentChar);
            }else if(getStr!=null&&getChar!=null){
                if(getStr.equals(currentStr)||getChar!=currentChar){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String words = "dog cat cat dog";
        System.out.println(wordPattern(pattern,words));
    }
}
