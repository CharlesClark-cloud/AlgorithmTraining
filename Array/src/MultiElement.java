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
        (new MultiElement()).majorityElement(a);
    }
    public int majorityElement(int[] nums) {
        HashMap map = new HashMap();
        int maxKey = 0,maxValue = 0;
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){ //元素是否出现过
                int updateValue = (int) map.get(nums[i]);//获取对应元素的出现次数
                updateValue++;
                if(updateValue > maxValue){ //超过当前最多次数的元素，max更新为此元素
                    maxValue = updateValue;
                    maxKey = nums[i];
                }
                map.put(nums[i],updateValue);
            }else {
                if(maxValue == 0){
                    maxValue = 1;
                    maxKey = nums[i];
                }
                map.put(nums[i],1); //第一次出现

            }
        }
        if(maxValue> nums.length / 2){
            return maxKey;
        }
        return 0;
    }

}

