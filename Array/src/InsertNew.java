import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: InsertNew
 * Package: PACKAGE_NAME
 */
public class InsertNew {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right  = newInterval[1];
        boolean placed = false;
        ArrayList<int[]> ansList = new ArrayList<>();
        for (int[] interval:intervals) {
            if(interval[0]>right){
                //在插入区间的右边
                //检查新区间是否安置
                //如果新区间在最左边的话,通过下面的判断也会插入
                if(!placed){
                    ansList.add(new int[]{left,right});
                    placed = true;
                }
                //如果已经插入过合并区间，那么后面的区间可以直接插入
                ansList.add(interval);
            }else  if(interval[1]<left){
                //在新区间的左边，可以直接插入
                ansList.add(interval);
            }else {
                //和新区间有交集
                //更新插入后的区间值
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!placed){
            //表示新区间最右边
            ansList.add(new int[]{left,right});
        }
        int [][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return  ans;
    }


    public static void main(String[] args) {
        int[][] insert = insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
//        int[][] insert = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < insert.length; i++) {
            System.out.println(insert[i][0]+" - "+insert[i][1]);
        }
    }

}
