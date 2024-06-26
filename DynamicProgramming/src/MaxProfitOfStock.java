/**
 * ClassName: MaxProfitOfStock
 * Package: PACKAGE_NAME
 */
public class MaxProfitOfStock {
    public int maxProfit(int[] prices) {
        //动态规划，像人一样思考，如果自己在之前最低的时候买了就好了。那么就用一个变量来存之前的最低价格，
        // 就可以知道在最低的时候买了，能赚多少钱（一个变量存储最大利润）
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] <minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice>maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,3,5,7,1};
        new MaxProfitOfStock().maxProfit(prices);
    }

}
