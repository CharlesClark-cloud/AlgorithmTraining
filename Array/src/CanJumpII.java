/**
 * ClassName: CanJumpII
 * Package: PACKAGE_NAME
 */
public class CanJumpII {
    public int jump(int[] nums) {
        int step = 0;
        int position = nums.length-1;
        while (position>0){
            for (int i = 0; i < position; i++) {
                if(i+nums[i]>=position){
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }
    public int jumpII(int[] nums) {
        int step = 0;
        int maxPosition = 0;
        int rightBorder = 0;
        for(int i = 0;i<nums.length-1;i++){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i==rightBorder){
                rightBorder = maxPosition;
                step++;
            }
        }

        return step;
    }
    public static void main(String[] args){
        int[] array = new int[]{3,1,2,0,4};
        System.out.println(new CanJumpII().jumpII(array));
    }
}
