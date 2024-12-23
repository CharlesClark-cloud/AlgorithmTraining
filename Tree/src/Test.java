import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 */
public class Test {
    public  static int maxLength(String in){
        char[] charArray = in.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int maxL = 0;
        for (int i = 0; i < charArray.length; i++) {
            if(set.contains(charArray[i])){
                while (charArray[l]!=charArray[i]){
                    set.remove(charArray[l]);
                    l++;
                }
                //此时l位置为 重复位置;
                l++;//

            }else {
                set.add(charArray[i]);
            }
            // 更新最大长度
            if((i-l+1)>maxL){
                maxL = i-l+1;
            }
        }
        return maxL;
    }






    public static void main(String[] args) {

        int n = 100;
        // 100个学生
        int[][] players = new int[n][2];
        for(int i=0;i<players.length;i++){
            players[i][0]=i+1;
            players[i][1]=0;
        }
        int count=n;
        int cycleNumber = 1;
        int i = 0;
        while (count>1){
            if(cycleNumber==7&&players[i][1]==0){
                //此玩家还没被淘汰，且到7了
                System.out.println(i);
                players[i][1] = 1;
                count--;
                cycleNumber=1;

            }
            if(players[i][1]==0){
                cycleNumber++;
            }
            i++;
            if(i>99){
                i=i%n;
            }
        }
        System.out.println("---------");
        for(int[] play:players){
            if(play[1]==0){
                System.out.println(play[0]);
            }
        }
        //一个数组nums  一个target
//        给一个数组，里面的元素都是数字，有零有正有负，给一个target值，要找出数组里连续N个数字之和和target最接近且N最小的情况下的N。就是先满足连续N个数字最接近target，同样接近再找N最小，最后返回N



    }
}


