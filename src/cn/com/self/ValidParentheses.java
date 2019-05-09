package cn.com.self;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Input: "()"
 * Output: true
 *
 * Input: "()[]{}"
 * Output: true
 *
 * 2019.5.9 zx
 *
 * 栈的应用
 */

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses tmp = new ValidParentheses();
        String s = "";

        System.out.println(tmp.isValid(s));
    }

    public boolean isValid(String s) {
        if (s.equals("")){
            return true;
        }
        boolean result = true;

        Stack tmp = new Stack();
        tmp.push(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) - (char)tmp.peek() == 1 || s.charAt(i) - (char)tmp.peek() == 2){
                tmp.pop();
                if(tmp.empty() && i + 1 < s.length()){
                    tmp.push(s.charAt(i + 1));
                    i++;
                }
            }
            else{
                tmp.push(s.charAt(i));
            }
        }

        if(tmp.empty()){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
}
