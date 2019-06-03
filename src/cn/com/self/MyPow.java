package cn.com.self;

/**
 * Implement pow(x, n), which calculates x raised to the power n.
 *
 * 2019.6.3 zx
 * LeetCode discussion 答案
 * 要用递归，正常循环的计算不能实现，时间不够
 */
public class MyPow {
    public static void main(String[] args) {
        double x = 2;
        int n = -2;
        MyPow tmp = new MyPow();
        System.out.println(tmp.myPow(x, n));
    }
    double myPow(double x, int n) {
        if (x == 0.0 || x == 1.0)   // special case, 0^n = 0, 1^n = 1
            return x;

        if (n == 0)                 // special case 2, x^0 = 1
            return 1.0;
        else if (n < 0) {
            // special case for MIN_VALUE since -MIN_VALUE = MAX_VALUE+1
            if (n == Integer.MIN_VALUE)
                return myPow(x, n+1)/x;
            else
                return 1.0/myPow(x, -n);
        }
        else if (n == 1) // special case, base case, x^1 = x
            return x;
        else if (n % 2 == 0) {      // common case, n is even, n=n/2+n/2, x^n = (x^(n/2))^2
            double ret = myPow(x, n/2);
            return ret*ret;
        }
        else  {                      // common case, n is odd, n=n/2+n/2+1, x^n = (x^(n/2))^2*x
            double ret = myPow(x, n/2);
            return x*ret*ret;
        }
    }
}
