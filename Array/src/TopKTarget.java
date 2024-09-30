/**
 * ClassName: TopKTarget
 * Package: PACKAGE_NAME
 */
public class TopKTarget {

    public  static  void  quickSort(int[] array,int left,int right){
        //TODO  普通快排
        if(left>=right){
            return;
        }
        int prior = left; // 基准值选择第一个元素
        int l = left;
        int r = right;

        while (l < r) {

            // 从右边找到第一个比基准值小的元素
            while (l < r && array[r] >= array[prior]) {
                r--;
            }
            // 从左边找到第一个比基准值大的元素
            while (l < r && array[l] <= array[prior]) {
                l++;
            }



            // 如果l和r还没有相遇，交换两个元素
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

// 最后，交换基准值与相遇位置的元素
        int temp = array[l];
        array[l] = array[prior];
        array[prior] = temp;

        quickSort(array,left,l-1);

        quickSort(array,r+1,right);
    }

    public  static  int   quickSortGetPivot(int[] array,int left,int right,int k){
        //TODO topK算法分开写法函数1
        if(left>=right){
            return left;
        }
        int prior = left; // 基准值选择第一个元素
        int l = left;
        int r = right;

        while (l < r) {

            // 从右边找到第一个比基准值小的元素
            while (l < r && array[r] >= array[prior]) {
                r--;
            }
            // 从左边找到第一个比基准值大的元素
            while (l < r && array[l] <= array[prior]) {
                l++;
            }

            // 如果l和r还没有相遇，交换两个元素
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

// 最后，交换基准值与相遇位置的元素
        int temp = array[l];
        array[l] = array[prior];
        array[prior] = temp;
        //返回标志位 位置
        return  l;

    }

    public  static int getK(int[] array,int left,int right,int k){
        //TODO topK算法分开写法函数2
        int target = k-1;
        int pivot = quickSortGetPivot(array,left,right,k);//第一遍快排，找出标志位
        //然后根据标志位情况和k进行对比
        if(target==pivot){
            return  array[pivot];
        }else if(target<pivot){
            return getK(array,left,pivot-1,k);
        }else {
            return getK(array,pivot+1,right,k);
        }
    }

    //首先第一个函数要拿到每次快排的标志位是几
//    然后在主函数中对标志位进行判断


    //一体
    public  static  int TopK(int [] array,int left,int right,int k){
        //TODO topK算法整体写法
        if(left>=right){
            return array[left];
        }
        int pivot = left; // 基准值选择第一个元素
        int l = left;
        int r = right;
        while (l < r) {
            // 从右边找到第一个比基准值小的元素
            while (l < r && array[r] >= array[pivot]) {
                r--;
            }
            // 从左边找到第一个比基准值大的元素
            while (l < r && array[l] <= array[pivot]) {
                l++;
            }

            // 如果l和r还没有相遇，交换两个元素
            if (l < r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }
// 最后，交换基准值与相遇位置的元素
        int temp = array[l];
        array[l] = array[pivot];
        array[pivot] = temp;

        int nowPivot = l;
        int target = k-1;

        if(target== nowPivot){
            return array[nowPivot];
        }else if(target>nowPivot){
            return  TopK(array,nowPivot+1,right,k);
        }else {
            return  TopK(array,left,nowPivot-1,k);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,5,6,4,1,3,7,8,9,0};
        int k = 2;
        getK(array,0,array.length-1,k);
        System.out.println(array[k-1]);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }

}
