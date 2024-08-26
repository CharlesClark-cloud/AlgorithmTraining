/**
 * ClassName: FindKth
 * Package: PACKAGE_NAME
 */
public class FindKth {
    public int findKthLargest(int[] nums, int k) {
        //时间有严格要求的时候 可以考虑用空间换时间，本题就是用桶排序
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i])>max){
                max = Math.abs(nums[i]);
            }
        }
        int[] numsTong =  new int[2*max+1];
        for (int i = 0; i < nums.length; i++) {

            numsTong[nums[i]+max]++;


        }
        int count = 0;
        for (int i = numsTong.length-1; i >=0 ; i--) {
            boolean flag = false;
            if(numsTong[i]!=0){
                count+=numsTong[i];
            }
            if(count>=k){
                flag=true;
            }
            if(flag){
                return i-max;
            }
        }
        return  0;
    }
    public  static void main(String[] args){
        int [] array = new int[]{3,2,1,5,6,4};
        int [] array2 = new int[]{-1,-1,-1};

        System.out.println(new FindKth().findKthLargest(array2,2));
    }
}
