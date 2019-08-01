package cn.com.self;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
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
}
