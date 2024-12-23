import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * ClassName: TopKFrequent
 * Package: PACKAGE_NAME
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int[][] res2 = new int[nums.length][2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int[] i = new int[1];
        map.forEach((u,v)->{
            res2[i[0]][0]=u;
            res2[i[0]][1]=v;
            i[0]++;
        });
        Arrays.sort(res2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//数组里面的下标为0，表示排序根据数组的第一列排序
            }
        });
        for (int j = 0; j < nums.length; j++) {
            System.out.println(res2[j][0]+"  "+res2[j][1]);
        }
        for (int j = nums.length-1; j >=nums.length-k ; j--) {
            res[nums.length-j-1]=res2[j][0];
        }
        System.out.println("---");
        for (int j = 0; j < res.length; j++) {
            System.out.println(res[j]);
        }

        return  res ;

    }

    public static void main(String[] args) {
        int [] array = new int[]{1};
        System.out.println(new TopKFrequent().topKFrequent(array,1));
    }

}
