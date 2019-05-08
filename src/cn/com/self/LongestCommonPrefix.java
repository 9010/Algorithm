package cn.com.self;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix tmp = new LongestCommonPrefix();
        String[] test  = {"aca","cba"};
        System.out.println(tmp.commonPrefix(test));
    }

    public String commonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        StringBuilder tmp = new StringBuilder();
        boolean isPrefix = true;
        for (int i = 0; i < strs[0].length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(i > strs[j].length() - 1){
                    isPrefix = false;
                    break;
                }
                else if (strs[0].charAt(i) == strs[j].charAt(i)){
                    isPrefix = true;
                }
                else{
                    isPrefix = false;
                    break;
                }
            }
            if (isPrefix) {
                tmp.append(strs[0].charAt(i));
            }
            else{
                break;
            }
        }
        return tmp.toString();
    }
}
