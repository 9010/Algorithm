package cn.com.self;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 2019.4.8 zx
 * 举例子，算到第5个就是其实是2的（target-1）次方，非举例的正确运算方法看牛客网
 */

public class JumpFloorII {
    public static void main(String[] args) {
        JumpFloorII jumpFloorII = new JumpFloorII();
        System.out.println(jumpFloorII.jumpFloorII(5));
    }
    public int jumpFloorII(int target) {
        return (int)(Math.pow(2,target-1));
    }
}
