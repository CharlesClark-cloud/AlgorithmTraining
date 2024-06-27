/**
 * ClassName: LengthOfLastWord
 * Package: PACKAGE_NAME
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("hello word"));

    }
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");

        return  words[words.length-1].length();

    }
}
