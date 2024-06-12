
public class MostWaterContainer {
    public static void main(String[] args){
        int[] array = new int[]{1,8,6,2,5,4,8,3,7};
        int[] array2 = new int[]{2,3,4,5,18,17,6};
        System.out.println(new MostWaterContainer().maxAreaOfficial(array2));
    }
    public int maxArea(int[] height) {
        //时间复杂度n2 超时
        int res =0;
        int index1= 0,index2=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int currentHeight = Math.min(height[j],height[i]);
                int currentRes = currentHeight*(j-i);
                if(currentRes>res){
                    res = currentRes;
                }
            }
        }
        return res;
    }
    public int maxAreaOfficial(int[] height) {
        //时间复杂度n 官方
        int res =0;
        int left= 0,right=height.length-1;
        for (int i = 0; i < height.length; i++) {
            int currentRes = (right-left)*Math.min(height[left],height[right]);
            if(currentRes>res){
                res = currentRes;
            }
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
