package cn.com.self;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * 2019.8.22 zx
 * LeetCode讨论区最好的答案+解释
 *
 * First assume that we have no money, so buy1 means that we have to borrow money from others.
 * We want to borrow less so that we have to make our balance as max as we can(because this is negative).
 *
 * sell1 means we decide to sell the stock.
 * After selling it we have price[i] money and we have to give back the money we owed.
 * So we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.
 *
 * buy2 means we want to buy another stock.
 * We already have sell1 money, so after buying stock2 we have buy2 = sell1 - price[i] money left
 * We want more money left, so we make it max
 *
 * sell2 means we want to sell stock2.
 * We can have price[i] money after selling it, and we have buy2 money left before
 * So sell2 = buy2 + prices[i], we make this max.
 *
 * So sell2 is the most money we can have.
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        BestTimeToBuyAndSellStockIII tmp = new BestTimeToBuyAndSellStockIII();
        System.out.println(tmp.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
