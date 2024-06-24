import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: OnlyOnceNumber
 * Package: PACKAGE_NAME
 */
public class OnlyOnceNumber {
    public static void main(String[] args) {
        int [] nums = new int[]{2,1,1};
        System.out.println(new OnlyOnceNumber().singleNumber(nums));
        System.out.println(new OnlyOnceNumber().official(nums));

    }
    public int singleNumber(int[] nums) {
        // n  n
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2){
                map.remove(nums[i]);
            };

        }
        Set<Integer> integers = map.keySet();
        Object[] array = integers.toArray();
        int x = (Integer) array[0];
        return x;

    }
    public  int official(int [] nums){
        // n 0;  使用异或方法，任何数与自己异或都是0，任何数与0异或都是自身。且异或满足分配律
        int res = 0;
        for (int num:nums) {
            //res^=num;
            res = res^num;
        }
        return  res;
    }
}
