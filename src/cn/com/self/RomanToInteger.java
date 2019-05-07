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
 * 2019.5.7 zx
 */
public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger tmp = new RomanToInteger();
        System.out.println(tmp.RomanToInt("III"));
    }
    public int RomanToInt(String s) {
        int[] define1 = {1000, 500, 100, 50, 10, 5, 1};
        int[] define2 = {900, 400, 90, 40, 9, 4};
        char[] CHAR1 = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        String[] CHAR2 = {"CM", "CD", "XC", "XL", "IX", "IV"};
        int num = 0;
        StringBuilder x = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        tmp.append("  ");
        x.append(s);

        for (int i = 0; i < x.length() - 1; i++){
            tmp.setCharAt(0, x.charAt(i));
            tmp.setCharAt(1, x.charAt(i+1));
            for(int j = 0; j < 6; j++){
                if(tmp.toString().equals(CHAR2[j])){
                    num += define2[j];
                    x.setCharAt(i, ' ');
                    x.setCharAt(i + 1, ' ');
                }
            }
        }
        for (int i = 0; i < x.length(); i++){
            for(int j = 0; j < 7; j++){
                if(x.charAt(i) == CHAR1[j]){
                    num += define1[j];
                }
            }
        }
        return num;
    }
}
