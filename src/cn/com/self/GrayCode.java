package cn.com.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code
 * print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * 2019.8.1 zx
 * 从最后一位开始，每一位二进制只有在2^（n + 1） （n表示位数）次变化后才会改变
 * 例：000,最后一位0只有在两次变化后才会改变一次，前一位0在4次（2^2）改变后才会改变一次
 * （一次改变代表数值变化）
 * 算法时间、空间复杂度都太高了
 *
 * graycode2 解释：
 * I use induction to proof this. So we proof If k bits can get 2^k gray code, then k+1 bits can get 2^(k+1) gray code.
 * For the k + 1 bits gray codes, the first 2^k gray codes' highest bit is "0", with the same order of k bits's gray code.
 * the second 2^k gray codes' highest bit is "1" with the symmetrical order of k bits' gray code. Such, we get the 2^(k+1) gray code.
 * For this solution, time complexity is n*2^n, 2^n numbers and to get each numbers, at most n bits to modify.
 *
 * 对于 n = k + 1,格雷码就是 n = k的两倍，不同点在于前一半 2^k 个格雷码对于 k + 1 位的最高为位0,后半部分最高位为1，总共有 2^(k+1)
 */
public class GrayCode {
    public static void main(String[] args) {
        int n = 4;
        GrayCode tmp = new GrayCode();
        System.out.println(tmp.grayCode2(n).toString());
    }

    public List<Integer> grayCode(int n) {
        List result = new ArrayList();
        if(n == 0){
            result.add(0);
            return result;
        }

        char[] tmp = new char[n];
        Arrays.fill(tmp, '0');
        boolean[] changeState = new boolean[n];
        Arrays.fill(changeState, false);
        int[] changeNum = new int[n];
        Arrays.fill(changeNum, 0);

        result.add(parseInt(String.valueOf(tmp), 2));
        for(int i = 1; i < Math.pow(2, n); i++){
            for(int j = n - 1; j >= 0; j--){
                if(!changeState[j]){
                    if(tmp[j] =='0') tmp[j] = '1';
                    else tmp[j] = '0';
                    changeState[j] = true;
                    changeNum[j] = (int)Math.pow(2, (n - j));
                    result.add(parseInt(String.valueOf(tmp), 2));
                    for(int k = 0; k < n; k++) {
                        if (changeNum[k] > 0) {
                            changeNum[k]--;
                            if (changeNum[k] == 0 && changeState[k] == true) {
                                changeState[k] = false;
                            }
                        }
                    }
                    break;
                }

            }
        }

        return result;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
