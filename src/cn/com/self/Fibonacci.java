package cn.com.self;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 2019.4.8 zx
 * 简单题目，注意从0开始，判断一个特殊 n = 1的时候
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(2));
    }
    public int fibonacci(int n) {
        if (n == 1){
            return 1;
        }
        long i = 0, j = 1;
        long sum = 0;
        for (int k = 1; k < n; k++){
            sum = i + j;
            i = j;
            j = sum;
        }
        return (int)sum;
    }
}
//0, 1, 1, 2, 3, 5, 8, 13