package cn.com.self;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list
 * and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * 2019.6.19 zx
 * Easy难度的题，没啥好说的
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
        PlusOne tmp = new PlusOne();
        digits = tmp.plusOne(digits);
        for(int i = 0; i < digits.length; i++){
            System.out.println(digits[i]);
        }
    }
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 1 && digits[0] == 0){
            digits[0] = 1;
            return digits;
        }
        digits[len - 1] ++;
        if(digits[len - 1 ] >= 10){
            digits[len - 1] -= 10;
            for(int i = len - 2; i >=0 ; i--){
                if(digits[i] + 1 >= 10){
                    digits[i] -= 9;
                }
                else{
                    digits[i]++;
                    break;
                }
            }
        }
        if(digits[0] == 0){
            int[] res = new int[len + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
