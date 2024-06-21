import javax.sound.midi.Sequence;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: RotationArray
 * Package: PACKAGE_NAME
 */
public class RotationArray {
    public static void main(String[] args) {
        int k = 2;
        int[] nums2= new int[]{-1,-100,3,99};
        int[] nums = new int[]{1,2,3,4,5,6,7};
        new RotationArray().official(nums,k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
    public void rotate(int[] nums, int k) {
        int location = k%nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length-location; i < nums.length; i++) {
            list.add(nums[i]);
        }
        for (int i = 0; i <nums.length-location; i++) {
            nums[nums.length-i-1] = nums[nums.length-location-i-1];
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

    }
    public  void official(int [] nums ,int k){
        //先总体反转，然后再分为两部分反转
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
