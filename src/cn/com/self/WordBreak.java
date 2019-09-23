package cn.com.self;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * 2019.9.19 zx
 * 解释：
 * nCharsAvail代表当前计算的字符长度，对于例来说，第一次计算a，那么nCharsAvail = 1，
 * 很明显nCharsAvail不大于任意一个wordDict中的单词的长度，会字符会继续增加，下一个会是p，nCharsAvail会变为2，长度依旧不大于任意单词，
 * 直到字符为apple的时候，nCharsAvail = 5，此时，nCharsAvail等于wordDict中 "apple" 的长度，此时会计算 suffixScore
 * 即：在nCharsAvail = s.length - j - word.length 的时候，是否有匹配的长度
 * 在例中，此时nCharsAvail = 5，那么suffixScore = 0，因为这是第一个大于等于wordDict中单词的单词。
 * scorePotential = word.length + suffixScore 代表此时的单词长度 + 之前匹配的单词长度
 * scorePotential应该等于此时的nCharsAvail，否则代表之前有没有匹配的单词或单词长度不匹配
 * 此时scorePotential = 5 与 nCharsAvail相同，进入isMatchStartingAt函数
 * isMatchStartingAt函数的目的是查看每一格字符是否相同，相同则将此时的单词长度存入dp[j]
 * 即：nCharsAvail = s.length - j时，匹配到scorePotential长度的单词
 * 此时dp[8] = 5，并跳出之后的wordDict中的循环
 * 继续，后一个字符为p，此时nCharsAvail = 6，长度大于wordDict中的单词，但是suffixScore都会查询到0，那么此时scorePotential != nCharsAvail
 * 直到pen全部输入，此时nCharsAvail = 8，
 * suffixScore = dp[j + word.length()] 即 dp[5 + 3] = dp[8] = 5
 * 此时scorePotential = 5 + 3 = 8 = nCharsAvail，进入isMatchStartingAt函数比较字符
 * 完全符合，存入dp[5] = 8，继续下一个字符，直到结束
 * 最后判断dp[0]是否等于s.length，相等则为true，否则false
 *
 */
public class WordBreak {
    public static void main(String[] args) {
        String[] words = {"apple", "pen"};
        List<String> wordDict = Arrays.asList(words);
        String s = "applepenapple";

        WordBreak tmp = new WordBreak();
        System.out.println(tmp.wordBreak(s, wordDict));

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (isNullOrEmpty(s) || wordDict == null) {
            return false;
        }
        // Insert empty set after last character.
        final int cols = s.length() + 1;
        // Values in matrix stored at starting index of matched words.
        int[] dp = new int[cols];
        // Be explicit about the inserted empty set.
        dp[cols-1] = 0;
        // for each character...
        for (int j = cols - 2; j >= 0; j--) {
            // Number of characters available to match with.
            int nCharsAvail = s.length() - j;
            dp[j] = 0;
            // for each word in the dictionary...
            for (String word : wordDict) {
                // Check for enough characters to match to.
                if (nCharsAvail >= word.length()) {
                    // Get score of the suffix to this match site.
                    int suffixScore = dp[j + word.length()];
                    // Add suffix score to ours for match potential.
                    int scorePotential = word.length() + suffixScore;
                    // Check for need to actually check this match.
                    // Optimal solution needs all characters matched.
                    if (scorePotential == nCharsAvail) {
                        // Check for a match at this j-th starting character.
                        if (isMatchStartingAt(s, j, word)) {
                            dp[j] =  scorePotential;
                            // Done with this j-th char (minor optimization).
                            break;
                        }
                    }
                }
            }
        }
        // Optimal solution for whole problem is stored at index 0,
        // meaning that all suffix characters have been considered.
        // Must have matched all N input characters somehow.
        return (dp[0] == s.length());
    }

    // Check for a match of the given word at the starting index of the input s.
    private boolean isMatchStartingAt(String s, int sStartIndex, String word) {
        // for each character in the word...
        for (int i = 0; i < word.length(); i++) {
            // check that the characters match.
            if (s.charAt(sStartIndex + i) != word.charAt(i)) {
                // Any character miss-match means no word match.
                return false;
            }
        }
        // All characters in the window matched.
        return true;
    }

    private boolean isNullOrEmpty(String s) {
        return (s == null || s.length() == 0);
    }
}
