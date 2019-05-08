package cn.com.self;


import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive
 * return all possible letter combinations that the number could represent.
 * Note that 1 does not map to any letters.
 *
 */
public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber tmp = new LetterCombinationsOfPhoneNumber();
        String digits = "23";
        System.out.println(tmp.letterCombinations(digits).toString());
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.equals("")){
            return result;
        }

        String[] button = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int[] num = new int[digits.length()];
        result.add("");
        int x = 0;

        for (int i = 0; i < digits.length(); i++){
            x = Character.getNumericValue(digits.charAt(i)) - 2;
            while (result.peek().length() == i){
                String t = result.remove();
                for (char s : button[x].toCharArray()){
                    result.add(t + s);
                }
            }
        }

        return result;
    }
}
