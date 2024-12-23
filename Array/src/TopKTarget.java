import java.util.Random;

/**
 * ClassName: TopKTarget
 * Package: PACKAGE_NAME
 */
public class TopKTarget {
    public  static  int   heapSortMethod(int[] array,int k){
        //先进行一次排序
        for(int i = array.length/2-1;i>=0;i--){
            heapSort(array,array.length-1,i);
        }
        //此时根节点就是最大值
        //拿到最大值要换到数组最后面，因为堆排序每次都会把最大值拿到第一个位置
        for(int i= array.length-1;i>0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp; //交换完成 现在从array[0] - array[i-1] 就不是有序的了
            //进行堆排序
            if(i == array.length-k){
                break;//已经到目标值了 进行剪枝操作
            }
            heapSort(array,i-1,0); //此处因为i已经被换为次轮的最大值了，所以递归边界要减一
        }
        return array[array.length-k];

    }
    public  static  void heapSort(int[] array,int remainBorder,int processRoot){
            int largest = processRoot;
            int leftChild = 2*processRoot+1;
            int rightChild = 2*processRoot+2;
            if(leftChild<=remainBorder&&array[leftChild]>array[processRoot]){
                largest = leftChild;
            }
            if(rightChild<=remainBorder&&array[rightChild]>array[processRoot]){
                largest = rightChild;
            }
            if(largest!=processRoot){
                //这是此前三个几点已经保证了
                int temp = array[largest];
                array[largest] = array[processRoot];
                array[processRoot] = temp;
                //然后还要向下传递 看largest 是和谁换的，然后向下递归调整子树
                heapSort(array,remainBorder,largest);
            }


    }

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
        //此处的pivot 可以随机生成尽量避免n*n 时间复杂度
//        Random random = new Random();
//        int pivot2 = left+random.nextInt(right-left+1);
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
