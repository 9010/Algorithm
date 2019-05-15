package cn.com.self;

/**
 * Given two integers dividend and divisor
 * divide two integers without using multiplication
 * division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * 2019.5.14 zx
 * 设定上两个数不会大于2147483647， 不会小于-2147483648，但是除法运算完成后可能会，判断这两种情况就行
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers tmp = new DivideTwoIntegers();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(tmp.divide(dividend, divisor));
    }
    public int divide(int dividend, int divisor) {
        long m = dividend, n = divisor;
        if(m / n > 2147483647){
            return 2147483647;
        }
        else if(m / n < -2147483648){
            return -2147483648;
        }
        else {
            return dividend / divisor;
        }

    }
}
