package cn.com.self;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * 219.6.11 zx
 * 字典序排序，找到第k个字典序，具体算法：
 *      1、从右到左，找到第一个左边数字比右边数字小的，记录下标为a
 *      2、从右到左，找到第一个比下标a大的数，记录下标为b
 *      3、交换a，b的数
 *      4、将下标a之后的数排序
 * 原版下面链接
 * https://www.cnblogs.com/darklights/p/5285598.html
 * 一个个找时间复杂度太高，寻求别的方法
 *
 *
 */
public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        PermutationSequence tmp = new PermutationSequence();
        System.out.println(tmp.getPermutation(n, k));
    }
    public String getPermutation(int n, int k) {
        int[] res = new int[n];
        for(int i = 1; i <= n; i++){
            res[i - 1] = i;
        }
        for(int i = 1; i < k; i++) {
            dictionary(res);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }

    private void dictionary(int[] res){
        int a = 0, b = 0;
        for(int i = res.length - 1; i > 0; i--){
            if(res[i - 1] < res[i]){
                a = i - 1;
                break;
            }
        }

        for(int i = res.length - 1; i >= 0; i--){
            if(res[a] < res[i]){
                b = i;
                break;
            }
        }
        swap(res, a, b);
        Arrays.sort(res, a + 1, res.length);
    }

    private void swap(int[] res, int i, int j){
        int tmp = 0;
        tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }
}
