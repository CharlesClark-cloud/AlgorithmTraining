/**
 * ClassName: ExceptSelfSum
 * Package: PACKAGE_NAME
 */
public class ExceptSelfSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] nums2 = new int[]{-1,1,0,-3,3};

        new ExceptSelfSum().productExceptSelf(nums2);
    }
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) return nums;
        int[] leftStartSum = new int[nums.length];
        int[] rightStartSum = new int[nums.length];
        int leftFlag = 1;
//        leftStartSum[0] = leftFlag;
        for (int i = 0; i < nums.length; i++) {
            leftStartSum[i] = nums[i]*leftFlag;
            leftFlag = leftStartSum[i];
        }
        System.out.println("---");
        int rightFlag = 1;
        for (int i = nums.length-1; i >-1 ; i--) {
            rightStartSum[i] = nums[i]*rightFlag;
            rightFlag = rightStartSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(leftStartSum[i]);

        }
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(rightStartSum[i]);

        }
        System.out.println("");
        nums[0] = rightStartSum[1];
        System.out.println(nums[0]);

        for (int i = 1; i < nums.length-1; i++) {
            nums[i] = leftStartSum[i-1]*rightStartSum[i+1];
            System.out.println(nums[i]);
        }
        nums[nums.length-1] = leftStartSum[leftStartSum.length-1-1];
        System.out.println(nums[nums.length-1]);

        return nums;
    }
}
