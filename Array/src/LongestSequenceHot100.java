import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LongestSequenceHot100
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 */
public class LongestSequenceHot100 {
    public static void main(String[] args) {
        int [] array = new int[] {7,7,6,7,18,5,2,1,1,1,2};
        int [] array1 = new int[] {7};
        int [] array2 = new int[] {1};
        int [] array3 = new int[] {0,1,1,2};
        System.out.println(new LongestSequenceHot100().longestConsecutiveOfficial(array2));

    }
    public int longestConsecutive(int[] nums) {
        //时间复杂度是快排nlogn
        if (nums.length ==0) return 0;
        if(nums.length==1)return 1;
        Arrays.sort(nums);
        int longestCount = 1;
        int currentSeqCount = 1;
        int front = 0;
        int rear = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[front]+1==nums[rear]){
                currentSeqCount++;
                if(currentSeqCount>longestCount){
                    longestCount = currentSeqCount;
                }
                if(front+1 == rear){
                    front++;
                    rear++;
                }else {
                    front = rear;
                    rear++;
                }

            }else if(nums[front]==nums[rear]){
                rear++;

            }
            else{
                currentSeqCount = 1;
                if(front+1 ==rear){
                    front++;
                    rear++;
                }else {
                    front = rear;
                    rear++;
                }
            }
        }
        return  longestCount;

    }
    public int longestConsecutiveOfficial(int[] nums) {
        //时间复杂度是 n
        //官方方法
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longgestSeqCount = 0;
        int currentSeqCount = 1;
        //获得了nums集合
        for (int num : num_set) {
            currentSeqCount = 1;
            System.out.println(num_set.contains(num - 1));
            if (!num_set.contains(num - 1)) {
                 int number = num;
                 while (num_set.contains(number+1)){
                     currentSeqCount++;
                     number++;
                 }
            }

            if (currentSeqCount > longgestSeqCount) {
                longgestSeqCount = currentSeqCount;
            }

        }
        return longgestSeqCount;
    }




}
