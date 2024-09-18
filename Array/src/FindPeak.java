/**
 * ClassName: FindPeak
 * Package: PACKAGE_NAME
 */
public class FindPeak {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return  0;
        }
        int mid = 0;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
           mid = left+(right-left)/2;
           int pre = mid == 0 ? 1 : nums[mid] - nums[mid - 1];
           int next = mid == nums.length-1 ?-1:nums[mid+1]-nums[mid];

              if(pre>0&&next<0){
                  //说明左右都比中间小 符合要求
                  return  mid;
              }
              if(next>0){
                  //有一边不符合要求，右边比较高，向右边走
                  left=mid+1;
              }else {
                  //右边小于0，说明pre也小于0 ，则是左边比较高，向右边走
                  right = mid-1;
              }
           }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeak().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
