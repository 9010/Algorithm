package cn.com.self;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' '
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * 2019.6.11 zx
 * 求一个字符串最后一个单词的长度，注意一种情况：最后一位或多位不是字母
 */
public class LengthofLastWord {
    public static void main(String[] args) {
        String s = "a ";
        LengthofLastWord tmp = new LengthofLastWord();
        System.out.println(tmp.lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s) {
        int res = 0;
        if(s.length() == 0) return res;
        int i = s.length() - 1;
        for(; i >= 0; i--){
            if(Character.isLetter(s.charAt(i))){
                break;
            }
        }
        for(; i >= 0; i--){
            if(s.charAt(i) != ' '){
                res++;
            }
            else{
                break;
            }
        }
        return res;
    }
}
