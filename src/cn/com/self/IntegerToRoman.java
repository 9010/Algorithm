package cn.com.self;

/**
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman tmp = new IntegerToRoman();
        System.out.println(tmp.intToRoman(1994));
    }
    public String intToRoman(int num) {
        int[] define = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] CHAR = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] charnum = new int[13];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < 13; i++){
            charnum[i] = num / define[i];
            num -= charnum[i] * define[i];
        }
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < charnum[i]; j++){
                result.append(CHAR[i]);
            }
        }
        return result.toString();
    }
}
