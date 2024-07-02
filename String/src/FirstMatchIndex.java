/**
 * ClassName: FirstMatchIndex
 * Package: PACKAGE_NAME
 */
public class FirstMatchIndex {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        for (int i = 0; i < haystackCharArray.length; i++) {
            if(haystackCharArray[i]==needleCharArray[0]&&i+needle.length()<=haystack.length()){
                Boolean is_match =true;
                for (int j = 1; j < needleCharArray.length; j++) {
                    if(haystackCharArray[i+j] != needleCharArray[j]){
                        is_match=false;
                        break;
                    }
                }
                if(is_match){
                    return  i;
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issipi";
        System.out.println(new FirstMatchIndex().strStr(s1,s2));
    }
}
