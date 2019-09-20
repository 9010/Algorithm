package cn.com.self;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 *
 * What is the minimum candies you must give?
 *
 * 2019.9.18 zx
 *
 * Now traverse the array from left to right.
 * If the rating of (n+1) child is greater than (n) child
 * then set the candy of (n+1) child as one candy more than the (n) child candies.
 *
 * Now traverse the array from right to left.
 * If the (n) child rating is more than (n+1) child and (n) child candies is less than one more than (n+1) child candies
 * then update the candies of (n) child as 1+ (n+1) candies.
 * 正面过一遍，反过来再过一遍就行，注意反过来算的时候要判断：第n个大于n+1个，并且candy数量小于n+1个
 */
public class Candy {
    public static void main(String[] args) {
        int[] ratings = {0,1,2,3,2};
        Candy tmp = new Candy();
        System.out.println(tmp.candy(ratings));
    }
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;

        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i] > ratings[i + 1]){
                if(i - 1 >= 0 && ratings[i] <= ratings[i - 1]){  //判断是否同时大于左边和右边，这种情况只增加1
                    dp[i] = dp[i + 1] + 1;
                    for(int j = i; j >= 1; j--){
                        if(ratings[j - 1] > ratings[j] && dp[j - 1] <= dp[j]){
                            dp[j - 1] = dp[j] + 1;
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(i == 0){
                    dp[i]++;
                }
            }
            else if(ratings[i] < ratings[i + 1]){
                dp[i + 1] = dp[i] + 1;
            }
        }

        int result = 0;
        for(int i = 0; i < dp.length; i++){
            result += dp[i];
        }
        return result;
    }

    public int candy2(int[] ratings) {
        int sum=0;
        int[] a=new int[ratings.length];
        for(int i=0;i<a.length;i++)
        {
            a[i]=1;
        }
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i+1]>ratings[i])
            {
                a[i+1]=a[i]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i])
            {
                if(a[i-1]<(a[i]+1))
                {
                    a[i-1]=a[i]+1;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
        }
        return sum;
    }
}
