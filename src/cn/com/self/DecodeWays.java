package cn.com.self;

import java.util.Arrays;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * 2019.8.2 zx
 * 动态规划 貌似是个经典题目 （有些类似傅立叶极数）
 * 假设dp[i]为以i为结尾的字符串解码方式数量的总和。
 * 假设当前index为i，当s[i]有效的时候，则dp[i] += dp[i - 1]。
 * 当s[i - 1]s[i]组成的字符串有效时，dp[i] += dp[i - 2]。
 * 实际上我们并不需要一个额外的数组来储存，只需要两个变量来储存dp[i - 1]和dp[i - 2]即可。
 */
public class DecodeWays {
    public static void main(String[] args) {
        String s = "1221";
        DecodeWays tmp = new DecodeWays();
        System.out.println(tmp.numDecodings(s));
    }
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int curWays = 1;
        int preWays = 1;
        int length = s.length();
        for(int i = 1; i < length; i++){
            int newCurWays = curWays;
            if(s.charAt(i) == '0'){
                if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') return 0;
                else newCurWays = preWays;
            }else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')){
                newCurWays += preWays;
            }
            preWays = curWays;
            curWays = newCurWays;
        }
        return curWays;
    }

    public int numDecodings2(String s){
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9')
                dp[i] += dp[i-1];
            if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'))
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
}
