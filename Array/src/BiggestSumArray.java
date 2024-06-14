import java.util.Arrays;

/**
 * ClassName: BiggestSumArray
 * Package: PACKAGE_NAME
 */
public class BiggestSumArray {
    public static void main(String [] args){
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        new BiggestSumArray().maxSubArrayTX(array);
    }
    public int maxSubArray(int[] nums) {
        //暴力直接超时 过了百分之90样例
        int maxSum = nums[0];
        int left=0,right=nums.length;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum+=nums[j];
                if(currentSum>maxSum){
                    maxSum = currentSum;
                }
            }

        }
//        System.out.println(maxSum);
        return maxSum;
    }
    public  int maxSubArrayDP(int [] nums){
        int [] arraySum = nums;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(arraySum[i-1]>0){
                arraySum[i] = arraySum[i]+arraySum[i-1];
            }
        }
        for (int i = 0; i < arraySum.length; i++) {
            if(arraySum[i]>res){res = arraySum[i];}
        }
        System.out.println(res);
        return res;
    }
    public  int maxSubArrayTX(int [] nums){
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i]+sum){
                sum = nums[i];
            }else{
                sum=nums[i]+sum;
            }
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
        return  maxSum;
    }
}
