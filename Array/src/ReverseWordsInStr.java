import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: ReverseWordsInStr
 * Package: PACKAGE_NAME
 */
public class ReverseWordsInStr {

    public String reverseWords(String s) {
        String[] array = s.split(" ");
        String res = "";
        for(int i=array.length-1;i>0;i--){
            if(array[i].length()>=1){
                res+= array[i]+" ";
            }
        }
        res+=array[0];
        if(res.charAt(res.length()-1)==' '){res=res.substring(0,res.length()-1);}
        return res;
    }
    public String reverseWordsOfficial(String s) {
        s=s.trim();//去除两端空格
        List<String> listS = Arrays.asList(s.split("\\s+"));
        Collections.reverse(listS);
        return  String.join(" ",listS);
    }
    public String reverseWordsQuick(String s) {
        char[] charArray = s.toCharArray();
        int right = charArray.length-1;
        int left = charArray.length-1;
        String res ="";
        boolean flag = false;
        for (int i=charArray.length-1;i>=0;i--){
            if(charArray[i]!=' '){
                right=i;
                for(int j = i;j>=0;j--){
                    if(charArray[j]==' '){
                       left=j+1;
                        i=j;
                       break;
                    }else if(j==0){
                        left=0;
                        i=0;
                    }

                }

                for(int j=left;j<=right;j++){
                    res+= charArray[j];
                }
                res+=' ';
            }
        }
        res=res.trim();
        return  res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInStr().reverseWordsQuick("the sky is blue"));
    }
}
