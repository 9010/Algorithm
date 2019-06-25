package cn.com.self;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * 2019.6.25 zx
 * 从0个阶梯和1个阶梯开始计算，2个阶梯就是0个阶梯的情况+1个阶梯的情况，以此类推
 * 可以用递归、迭代
 *
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        ClimbingStairs tmp = new ClimbingStairs();
        System.out.println(tmp.climbStairs(n));
    }
    public int climbStairs(int n) {
//        int[] cache = new int[n + 1];
//        return climbStairs(n, cache);

//        if(n == 0 || n == 1) return 1;
//        int[] cache = new int[n + 1];
//        cache[0] = 1;
//        cache[1] = 1;
//        for(int i = 2; i <= n; i++){
//            cache[i] = cache[i - 2] + cache[i - 1];
//        }
//        return cache[n];
        if(n == 0 || n == 1) return 1;
        int pre2 = 1, pre1 = 1, res = 0;
        for(int i = 2; i <= n; i++){
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

    private int climbStairs ( int n, int[] cache){
        if (n < 0) { // this can happen due to our recursive calls
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = climbStairs(n - 1, cache)
                + climbStairs(n - 2, cache);

        return cache[n];
    }
}
//     int res = 0;
//        res = step(n , 0);
//        return res;
//    }
//    private int step(int n, int res){
//        if(n == 0){
//            res++;
//            return res;
//        }
//        for(int i = 1; i <= 2; i++){
//            if(n - i >= 0){
//                n = n - i;
//                res = step(n, res);
//                n = n + i;
//            }
//        }
//        return res;
