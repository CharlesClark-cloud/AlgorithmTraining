/**
 * ClassName: MaxPublicPrefix
 * Package: PACKAGE_NAME
 */
public class MaxPublicPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){ return  strs[0];}
        String res = "";
        String shortest = "";
        int shortestLength=  Integer.MAX_VALUE;
        for(int i= 0;i<strs.length;i++){
            if(strs[i].length()<shortestLength){
                shortestLength = strs[i].length();
                shortest = strs[i];
            }
        }
        if(shortestLength==0){
            return "";
        }
        boolean over = false;
        boolean isIn =false;
        int count = 0;
        char[] charsArray = shortest.toCharArray();
        for(int i= 0;i<charsArray.length;i++){
            for(int j= 0;j<strs.length;j++){
                if(strs[j].charAt(i) != charsArray[i]){
                        count = i-1;
                        over =true;
                        isIn =true;
                }
            }
            if (over){
                break;
            }
        }
        if (!isIn){
            count = charsArray.length-1;
        }
        for (int i = 0; i <= count; i++) {
            res+=charsArray[i];
        }
        System.out.println(res);

     return  res;
    }

    public static void main(String[] args) {
        String[] strs = new  String[]{"flower","flow","flight"};
        String[] strs2 = new  String[]{"flower","flower","flower","flower"};

        System.out.println(new MaxPublicPrefix().longestCommonPrefix(strs2));
    }

}
