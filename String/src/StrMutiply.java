/**
 * ClassName: StrMutiply
 * Package: PACKAGE_NAME
 */
public class StrMutiply {
    public static String multiply(String num1, String num2) {
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        if(num1Chars.length==1&&num1Chars[0]=='0'||num2Chars.length==1&&num2Chars[0]=='0'){
//            排除有0的情况
            return "0";
        }

        // 默认第一个数在上面 第二个数在下面
        int[][] res = new int[num2Chars.length][num1Chars.length+1]; //下面的数是几位就是几行 上面的数是几位就有几位+1位（进位）
        for(int i =num2Chars.length-1;i>=0;i--){
            int upper = 0;
            for(int j=num1Chars.length-1;j>=0;j--){
                //将每两个数字的成绩存储起来，然后求和
                int currentRes = (num2Chars[i]-'0')*(num1Chars[j]-'0')+upper;
                res[num2Chars.length-1-i][j+1] = currentRes%10;
                upper = currentRes/10;
            }
            if(upper!=0){
                res[num2Chars.length-1-i][0] = upper;
            }
        }
        //现在矩阵中存放的就是每一位数字与上面数字的乘积了
        StringBuffer sbBac =new StringBuffer();

        for(int i = 0;i<res.length-1;i++){
            //处理每一行 还要处理下一行
            //首先第一行最后一个直接加入resStr
            sbBac.insert(0,res[i][res[i].length-1]);
            int upper = 0;
            for(int j = res[i].length-2;j>=0;j--){
                int sum = res[i+1][j+1] + res[i][j]+upper;
                res[i+1][j+1] = sum%10;
                upper = sum/10;
            }
            if(upper!=0){
                res[i+1][0]+= upper;
            }
        }
        // 处理到这里就剩下最后一行 + resStr
        StringBuffer sbPre= new StringBuffer();
        for(int i=0;i<res[0].length;i++){
            if(res[res.length-1][i]!=0){
                for(int j = i;j<res[res.length-1].length;j++){
                    sbPre.append(res[res.length-1][i]);
                    i++;
                }
            }
        }
        sbPre.append(sbBac);
        return sbPre.toString();
    }

    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        System.out.println(multiply(num1, num2));
    }
}
