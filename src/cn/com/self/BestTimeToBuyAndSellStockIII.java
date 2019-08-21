package cn.com.self;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        BestTimeToBuyAndSellStockIII tmp = new BestTimeToBuyAndSellStockIII();
        System.out.println(tmp.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] max = new int[2];
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++){
            int profit = 0;
            if(prices[i] < buy){
                buy = prices[i];
            }
            else if( (prices[i] > buy) && (i == prices.length - 1 || prices[i + 1] < prices[i]) ){
                profit += prices[i] - buy;
                buy = prices[i];
                Arrays.sort(max);
                if(profit > max[0]){
                    max[0] = profit;
                }
            }
        }

        return max[0] + max[1];
    }
}
