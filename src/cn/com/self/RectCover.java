package cn.com.self;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 2019.4.11 zx
 * 斐波那契数列
 */
public class RectCover {
    public int rectCover(int target) {
        if (target == 1){
            return 1;
        }
        int i = 1, j = 1;
        int n = 0;
        for (int k = 1; k < target; k++){
            n = i + j;
            i = j;
            j = n;
        }
        return n;
    }
}
