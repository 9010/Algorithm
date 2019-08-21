package cn.com.self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock)
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * 2019.8.21 zx
 * 想复杂了，EASY难度题目
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};

        BestTimeToBuyAndSellStock tmp = new BestTimeToBuyAndSellStock();
        System.out.println(tmp.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else{
                if(max < prices[i] - min){
                    max = prices[i] - min;
                }
            }
        }

        return max;
    }
}
