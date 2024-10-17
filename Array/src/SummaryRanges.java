import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SummaryRanges
 * Package: PACKAGE_NAME
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        String currentRes="";
        boolean findHead = true;
        boolean conti = false;
        for(int i = 0;i<nums.length-1;i++){
            if(findHead){
                // 找到当前答案的开头（若后面没有连续的则此开头就是整个段）
                currentRes = String.valueOf(nums[i]);
                findHead = false;
            }
            if(nums[i]+1 == nums[i+1]){
                //找到连续的了
                conti = true;
                continue;
            }

            if(nums[i]+1!=nums[i+1]){
                if(conti){
                    currentRes+="->"+String.valueOf(nums[i]);
                }
                res.add(currentRes);
                currentRes="";
                findHead =true;
                conti = false;
            }
        }
        if(conti){
            currentRes+="->"+String.valueOf(nums[nums.length-1]);
            res.add(currentRes);
        }else {
            res.add(String.valueOf(nums[nums.length-1]));
        }
        return  res;

    }

    public static List<String> summaryRangesImproved(int[] nums) {
        //之前的方法一直在找连续的区间，现在转换思路 寻找第一个不与前面连续的元素
        List<String> res = new ArrayList<>();
       int start = 0;
        //因为要找前一个元素，所以i从1 开始，
        for(int i = 1;i<=nums.length;i++){
            if(i==nums.length||nums[i]!=nums[i-1]+1){
                //找到第一个不与前面连续的元素得了
                if(i-1 == start){
                    //判断是否只有前一个元素
                    res.add(String.valueOf(nums[start]));
                }else {
                    //使用stringbuffer 这是因为使用 StringBuffer 或 StringBuilder 进行字符串拼接在 Java 中比直接使用 + 操作符更高效。
                    // + 操作符会生成多个中间的字符串对象，从而增加了内存分配和垃圾回收的开销，
                    // 而 StringBuffer 和 StringBuilder 是可变的字符串对象，可以直接修改已有的缓冲区，减少对象创建次数，因此效率更高
                    StringBuffer sb =new StringBuffer();
                    sb.append(nums[start]).append("->").append(nums[i-1]);
                    res.add(sb.toString());
                }
                start = i;
            }

        }

        return  res;

    }


    public static void main(String[] args) {
        int [] nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(summaryRangesImproved(nums));
    }
}
