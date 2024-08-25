/**
 * ClassName: DeleteDuplicates
 * Package: PACKAGE_NAME
 */
public class DeleteDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){return nums.length;}
        int numsRealLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[numsRealLength-1]){
                nums[numsRealLength] = nums[i];
                numsRealLength++;
            }

        }
        return  numsRealLength;
    }

    public static void main(String[] args) {
        int [] array = new int[]{0,0,1,1,1,2,5};
        int [] array2 = new int[]{0,0,1,1,1,2,5};
        int [] array3 = new int[]{0,0,1,1,1,2,5};
        System.out.println(new DeleteDuplicates().removeDuplicates(array));

    }
}
