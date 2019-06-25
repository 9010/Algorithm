package cn.com.self;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Sqrtx {
    public static void main(String[] args) {
        int x = 2147395599;
        Sqrtx tmp = new Sqrtx();
        System.out.println(tmp.mySqrt(x));
    }
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        long low = 1, high = x;
        long mid = (low + high) / 2;
        while(low < high){
            if(mid * mid > x){
                high = mid;
                mid = (low + high) / 2;
            }
            else if(mid * mid < x){
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else{
                return (int)mid;
            }
        }
        return (int) (mid - 1);
    }
}
