import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: MergeArray
 * Package: PACKAGE_NAME
 */
public class MergeArray {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        int count =0;

        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

//        for (int i = 0; i < intervals.length; i++) {
//
//            System.out.println("["+intervals[i][0]+","+intervals[i][1]+"]");
//
//        }
        int[] currentRes = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(currentRes[1]>=intervals[i][0]){
                if(currentRes[1]<intervals[i][1]){
                    currentRes[1] = intervals[i][1];
                }


            }else {
                res[count]=currentRes;
                count++;
                currentRes = intervals[i];
            }
        }
        res[count]=currentRes;
        count++;
        int[][] resRet = new int[count][2];
        for (int i = 0; i < count; i++) {
            resRet[i] = res[i];
        }
//        for (int i = 0; i < count; i++) {
//
//            System.out.println("["+resRet[i][0]+","+resRet[i][1]+"]");
//
//        }
        return resRet;

    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = new int[][]{{4,5},{1,4},{0,1}};//[4,5],[1,4],[0,1]
        new MergeArray().merge(intervals2);
    }
}
