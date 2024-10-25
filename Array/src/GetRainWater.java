/**
 * ClassName: GetRainWater
 * Package: PACKAGE_NAME
 */
public class GetRainWater {
    public static int trap(int[] height) {
        int res = 0;
        if(height.length==0){
            return res;
        }
        //首先要明确一个容器最重要的是，1 容器左边界高度，2 容器有边界高度，3 容器内部的容量
        // 一组数据中第一个左边界与最后一个有边界要特殊考虑
        //上一个容器的右边界是下一个容器的左边界查找起点
        //找到左边界 然后寻找右边界 寻找右边界时 找到第一个比左边界高的 如果找不到比左边界高的就找剩下里面最高的
        int first = 0;
        while(first<height.length&&height[first]==0){
            first++;
        }
        if(first == height.length){
            return  res;
        }
        //找到第一个不为零的左边界
        int left ,right;
        for(int i = first;i<height.length;i=right){
            left = i;
            right = i;
            if(left==right&&left == height.length-1){
                break;
            }
            int j=i;
            for(j=i;j<height.length;j++){
                if(height[j]>=height[left]&&j!=i){
                    //高度高于等于左边界
                    //找到第一个边界
                    right = j;
                    break;
                }
            }

            if(j==height.length&&height[right]<=height[left]){
                //没有找到高于left的  证明目前left是最高的
                int max = 0;
                for(j = i+1;j<height.length;j++){
                    //寻找剩余的最高的作为右边界
                    if(height[j]>=max){
                        max = height[j];
                        right = j;
                    }
                }
                //此时right 为右边界
            }
            if(left+1==right){
                continue;
            }
            //此时左右边界都找到，计算区间容量
            int border = Math.min(height[left],height[right]);
            int sectionSum = 0;
            for(int k = left+1;k<right;k++){
                sectionSum+=border - height[k];
            }
            res += sectionSum;
        }
        return res;
    }
    public  static int trapDP(int[] height){
        //这是动规 用了O（N）的空间
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length-1] = height[height.length-1];
        int lMax = height[0];
        int rMax = height[height.length-1];
        for(int i = 1;i<height.length;i++){
            leftMax[i] = Math.max(height[i],lMax);
            if(height[i]>lMax){
                lMax = height[i];
            }
        }
        for(int i = height.length-2;i>=0;i--){
            rightMax[i] = Math.max(height[i],rMax);
            if(height[i]>rMax){
                rMax = height[i];
            }
        }
        for (int i = 0; i < height.length; i++) {
            res+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return  res;
    }
    public  static int trapDPWithoutSpace(int[] height){
        //这是动规 用了O（1）的空间
        //用双指针
        int res = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int left = 0;
        int right = height.length-1;
        while (left<right){
            if(height[left]>leftMax){
                leftMax= height[left];//真正意义上的左侧最大值
            }
            if(height[right]>rightMax){
                rightMax = height[right];//真正意义上的右侧最大值
            }
           if(height[left]<height[right]){
               //进入此条件 把目光拉到整个数组 无论中间是什么样子，此时left 和 right 之间一定是存水的
               // 而存多少 就要看左边低的那个值，也就是左边的最大值，此时低的值是leftMax
               //证明left是存水的 其实left 向前走，然后 leftMax 就是真正的左侧最大值 height[right]就是此时的右侧最大值
//               此处能存多少水就是 leftMax - height[left]
               res += leftMax - height[left];
               left++;

           }else{

               res+= rightMax - height[right];
               right--;
           }
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapDPWithoutSpace(height));
    }
}
