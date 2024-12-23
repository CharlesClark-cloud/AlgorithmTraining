import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AllSeq
 * Package: PACKAGE_NAME
 */
public class AllSeq {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        new  AllSeq().permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> resInner = new ArrayList<>();
        if(nums.length==1){
            resInner.add(nums[0]);
            res.add(resInner);System.out.println(res);
            return  res;}
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length-1; j++) {
                resInner = new ArrayList<>();
                int num = nums[j];
                nums[j]=nums[j+1];
                nums[j+1] = num;
                for (int k = 0; k < nums.length; k++) {
                    resInner.add(nums[k]);
                }
                res.add(resInner);
            }

        }
        System.out.println(res);
        System.out.println(res.size());

        return res;
    }

}
