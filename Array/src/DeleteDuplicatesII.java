import java.util.HashMap;

/**
 * ClassName: DeleteDuplicatesII
 * Package: PACKAGE_NAME
 */
public class DeleteDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return  nums.length;
        }
        int numsRealLength = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
                nums[numsRealLength]=nums[i];
                numsRealLength++;
            }else if(map.get(nums[i])!=null &&map.get(nums[i])==1){
                map.put(nums[i],2);
                nums[numsRealLength]=nums[i];
                numsRealLength++;
            }
        }
        return numsRealLength;
    }
    public int removeDuplicates2(int[] nums) {
        if(nums.length<=1){
            return  nums.length;
        }
        int numsRealLength = 1;
        int slow = nums[numsRealLength-1];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] ==slow&&count<2){
                nums[numsRealLength] = nums[i];
                numsRealLength++;
                count++;
            }else if(nums[i] !=slow){
                count=1;
                slow = nums[i];
                nums[numsRealLength] = nums[i];
                numsRealLength++;
            }
        }
        for (int i = 0; i < numsRealLength; i++) {
            System.out.println(nums[i]);
        }
        return numsRealLength;
    }
    public static void main(String[] args) {
        int [] array = new int[]{1,1,1,2,2,3};
        System.out.println(new DeleteDuplicatesII().removeDuplicates2(array));

    }
}
