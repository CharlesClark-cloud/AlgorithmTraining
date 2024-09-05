/**
 * ClassName: MaxProfitII
 * Package: PACKAGE_NAME
 */
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];
        int max = prices[0];
        boolean flag = false;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
                max = prices[i];
            }
            if(prices[i]>max){
                max = prices[i];
                flag = true;
            }
            if(flag == true && prices[i]<=max){
                maxProfit+= max-min;
                flag = false;
                max = prices[i];
                min = prices[i];
            }
        }
        if(flag==true){
            maxProfit+=max-min;
        }
        return  maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,5,4,3,2,1};
        int[] prices3 = new int[]{1,2,3,4,5,6};
        int[] prices4 = new int[]{2,4,1};
        System.out.println(new MaxProfitII().maxProfit(prices3));
    }
}
