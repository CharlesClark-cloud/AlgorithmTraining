/**
 * ClassName: IntReverse
 * Package: PACKAGE_NAME
 */
public class IntReverse {
    public static int reverse(int x) {
        //反转整数 每次取出最后一位 但是过程中判断是否超过整数的储存边界
        int res = 0;
        if(x>0){
            int n = x;
            while(n>0){
                int temp = n%10;
                n = n/10;
                if(res>214748364||res==214748364&&temp>7){
                    return 0;
                }
                res = res*10+temp;

            }
        }else if(x<0){
            int n = x;
            while(n<0){
                int temp = n%10;
                n = n/10;
                if(res<-214748364||res==-214748364&&temp<-8){
                    return 0;
                }
                res = res*10+temp;
                if(res>0){
                    res = -res;
                }

            }

        }
        return  res;
    }


    public static void main(String[] args) {
        System.out.println(reverse(  -1463847412));
    }
}
