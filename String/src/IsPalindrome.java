/**
 * ClassName: IsPalindrome
 * Package: PACKAGE_NAME
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        s = s.toLowerCase();
        int left = 0,right = s.length()-1;
        while(left<=right){
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(s.charAt(left)!= s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        char a = 'a';

        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
