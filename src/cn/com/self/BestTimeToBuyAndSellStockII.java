package cn.com.self;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * 2019.8.21 zx
 * 如果一个数比前一个数小，那么这个数就作为购买数，如果一个数比前一个数大，那么就作为卖出数，同时购买数变为这个数
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 10, 100};
        BestTimeToBuyAndSellStockII tmp = new BestTimeToBuyAndSellStockII();
        System.out.println(tmp.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;

        int profit=0;
        int buy=prices[0];
        for(int i=0;i<prices.length;i++)    {
            if(prices[i]<buy)   {
                buy=prices[i];
            }
            else if(prices[i]>buy)  {
                profit+=prices[i]-buy;
                buy=prices[i];
            }
        }
        return profit;
    }
}
