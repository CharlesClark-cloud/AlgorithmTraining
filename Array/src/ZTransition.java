/**
 * ClassName: ZTransition
 * Package: PACKAGE_NAME
 */
public class ZTransition {
    public String convertOfficial(String s, int numRows) {
//       模仿移动，创建二维矩阵，按照z字，把字母填入矩阵，最后扫描二维矩阵。
//        填入过程有两种，一种是向下移动 y-1，一种是向又上移动 x+1 y+1
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }

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
