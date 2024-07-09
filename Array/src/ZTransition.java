/**
 * ClassName: ZTransition
 * Package: PACKAGE_NAME
 */
public class ZTransition {
    public String convert(String s, int numRows) {
        //首先得到间隔数组
        //首尾两行
        if(numRows==1){return  s;}
        int firstAndLast = (numRows-1)*2;
        int[] space = new int [numRows-2];
        for (int i = 0; i < space.length; i++) {
            space[i] =(numRows-(i+2))*2;
        }
        char[] chars = s.toCharArray();
        int count =0;
        String res ="";
        while(count<chars.length){
            res+=chars[count];
            count+=(firstAndLast);
        }
        for (int i = 0; i < space.length; i++) {
            int currentSpace = space[i];
            int nextSpace = space[space.length-i-1];
            int usingSpace ;
            int countSpace = 0;
            count = i+1;
            while(count<chars.length){
                if(countSpace%2==0){
                    usingSpace =currentSpace;
                }else {
                    usingSpace =nextSpace;
                }
                res+=chars[count];
                count+=(usingSpace);
                countSpace++;
            }

        }
        count=numRows-1;
        while(count<chars.length){
            res+=chars[count];
            count+=(firstAndLast);
        }
        return  res;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int row = 1;
        System.out.println(new ZTransition().convert(s, row));
    }

}
