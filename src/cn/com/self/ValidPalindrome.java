package cn.com.self;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * 判断是否回文，忽略空格和符号，仅判断字母数字
 *
 * 2019.9.4 zx
 * easy难度
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0p";
        ValidPalindrome tmp = new ValidPalindrome();
        System.out.println(tmp.isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;

        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        else{
            return false;
        }
    }
}
