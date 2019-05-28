package cn.com.self;

/**
 * Given two non-negative integers num1 and num2 represented as strings
 * return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Note:
 * 1.The length of both num1 and num2 is < 110.
 * 2.Both num1 and num2 contain only digits 0-9.
 * 3.Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * 4.You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * 2019.5.28 zx
 * discuss答案：num[i] 与 num[j] 相乘，他们的结果所在位子就在pos[i + j] 与 pos[i + j + 1]的地方
 * 该题目不能将整个字符串转换成数字计算，long长度都不够
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "9";
        //"123456789";
        //"6913259244"
        String num2 = "9";   //"987654321";
        MultiplyStrings tmp = new MultiplyStrings();
        System.out.println(tmp.multiply(num1, num2));
    }
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] pos = new int[n1 + n2];

        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) -'0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < pos.length; i++){
            if(!(result.length() == 0 && pos[i] == 0))
                result.append(pos[i]);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
