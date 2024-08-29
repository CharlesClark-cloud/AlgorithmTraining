import java.util.Arrays;
import java.util.Queue;

/**
 * ClassName: CanJump
 * Package: PACKAGE_NAME
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if(i<=rightMost){
                rightMost = Math.max(rightMost,i+nums[i]);//实时更新最远距离
                if(rightMost>=n){
                    return  true;
                }
            }
        }
        return  false;
    }

    public static void main(String[] args){
        int[] array = new int[]{1,1,2,2,0,1,1};
        System.out.println(new CanJump().canJump(array));
    }

}
