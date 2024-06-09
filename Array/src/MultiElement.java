import java.util.HashMap;

/**
 * ClassName: MultiElement
 * Package: PACKAGE_NAME
 */
public class MultiElement {
    public MultiElement() {
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 3};
        (new Solution()).majorityElement(a);
    }

}
class Solution {
    Solution() {
    }

    public int majorityElement(int[] nums) {
        HashMap map = new HashMap();
        int maxKey = 0;
        int maxValue = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                int updateValue = (Integer) map.get(nums[i]);
                ++updateValue;
                if (updateValue > maxValue) {
                    maxValue = updateValue;
                    maxKey = nums[i];
                }

                map.put(nums[i], updateValue);
            } else {
                map.put(nums[i], 1);
            }
        }

        System.out.println("" + maxKey + "-" + maxValue);
        System.out.println(map);
        System.out.println(maxKey);
        return maxKey;
    }
}
