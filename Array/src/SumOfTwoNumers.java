/**
 * ClassName: SumOfTwoNumers
 * Package: PACKAGE_NAME
 */
public class SumOfTwoNumers {
    public int[] twoSum(int[] numbers, int target) {
        //暴力超时 n^2
        int [] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                if(numbers[i]+numbers[j]==target){
                    res[0] = i+1;
                    res[1] = j+1;
                }
            }
        }
        return  res;

    }

    public int[] twoSum2(int[] numbers, int target) {
        //最优解n
        int [] res = new int[2];
        int left = 0;
        int right  =numbers.length-1;
        while (left<=right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }else if(numbers[left]+numbers[right]>target){
                right--;
            }else {
                res[0]=left+1;
                res[1]=right+1;
                break;
            }
        }
        return  res;

    }

    public static void main(String[] args) {
        int[] array = new int []{2,3,4};

        System.out.println(new SumOfTwoNumers().twoSum2(array, 6)[0]);
        System.out.println(new SumOfTwoNumers().twoSum2(array, 6)[1]);
    }
}
