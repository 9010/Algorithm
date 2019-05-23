package cn.com.self;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * 2019.5.23 zx
 * 判断不同的数字，并计数
 */
public class CountandSay {
    public static void main(String[] args) {
        int n = 4;
        CountandSay tmp = new CountandSay();
        System.out.println(tmp.countAndSay(n));
    }
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String result = "11";
        for(int i = 2; i < n ; i++){
            int num = 1;
            char index = result.charAt(0);
            StringBuilder tmp = new StringBuilder();
            for(int j = 1; j < result.length(); j++){
                if(index == result.charAt(j)){
                    num++;
                }
                else{
                    tmp.append(num);
                    tmp.append(index);
                    num = 1;
                    index = result.charAt(j);
                }
            }
            tmp.append(num);
            tmp.append(index);
            result = tmp.toString();
        }

        return result;
    }
}
