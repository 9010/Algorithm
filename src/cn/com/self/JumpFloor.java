package cn.com.self;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 2019.4.8 zx
 * 斐波那契数列的应用，先举几个例子看看，想到就很简单，想不到就想死
 */
public class JumpFloor {
    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.jumpFloor(2));
    }

    public int jumpFloor(int target) {
        if (target == 1){
            return 1;
        }
        int i = 1, j = 1;
        int sum = 0;
        for (int k = 1; k < target; k++){
            sum = i + j;
            i = j;
            j = sum;
        }
        return sum;
    }
}
