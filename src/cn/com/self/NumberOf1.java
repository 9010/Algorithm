package cn.com.self;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 2019.4.11
 * 难点其实在10进制转2进制，但是直接调用API解决了，也懒得去搞这个了
 */

public class NumberOf1 {
    public static void main(String[] args) {
        NumberOf1 test = new NumberOf1();
        System.out.println(test.numberOfOne(10));
    }
    public int numberOfOne(int n) {
        String result = Integer.toBinaryString(n);
        //System.out.println(result);

        int num = 0;
        for (int i = 0; i < result.length(); i++){
            if (result.charAt(i) == '1'){
                num++;
            }
        }

        return num;
    }
}
