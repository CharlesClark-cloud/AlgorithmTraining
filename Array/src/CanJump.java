import java.util.Arrays;
import java.util.Queue;

/**
 * ClassName: CanJump
 * Package: PACKAGE_NAME
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for(int i = 0;i<nums.length;i++){
            if(i<=maxPosition){
                maxPosition = Math.max(maxPosition,i+nums[i]);
                if(maxPosition>=nums.length-1){
                    return true;
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
