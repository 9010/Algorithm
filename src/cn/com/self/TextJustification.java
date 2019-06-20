package cn.com.self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth
 * format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 *
 * If the number of spaces on a line do not divide evenly between words
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * 2019.6.20 zx
 * 一点点试出来，主要是空格的问题
 */
public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        int maxWidth = 16;
        TextJustification tmp = new TextJustification();
        List<String> res = tmp.fullJustify(words, maxWidth);
        for(int i = 0; i < res.size(); i++){
            System.out.println("\"" + res.get(i) + "\"");
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0 || maxWidth == 0) return new ArrayList<>();
        int wordLen = 0, wordNum = 0;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            wordLen += words[i].length();
            wordNum++;
            if(wordLen > maxWidth && i <= words.length - 1){
                wordLen -= words[i].length() + wordNum - 1;
                i--;
                wordNum--;
                StringBuilder tmp = new StringBuilder();
                int spaceNum = 0 , evenl = 0;
                if(wordNum > 1){
                    spaceNum = (maxWidth - wordLen) / (wordNum - 1);
                    evenl = (maxWidth - wordLen) % (wordNum - 1);
                }
                else if(wordNum == 1){
                    spaceNum = maxWidth - wordLen;
                }
                for(int j = i - (wordNum - 1); j < i; j++){
                    tmp.append(words[j]);
                    for(int h = 0; h < spaceNum; h++){
                        tmp.append(' ');
                        if(evenl > 0) {
                            tmp.append(' ');
                            --evenl;
                        }
                    }
                }
                tmp.append(words[i]);
                if(wordNum == 1){
                    for(int h = 0; h < spaceNum; h++) {
                        tmp.append(' ');
                    }
                }
                res.add(tmp.toString());
                wordLen = 0;
                wordNum = 0;
            }
            else if(i == words.length - 1){
                StringBuilder tmp = new StringBuilder();
                for(int j = i - (wordNum - 1); j < i; j++){
                    tmp.append(words[j]);
                    tmp.append(' ');
                }
                tmp.append(words[i]);
                int spaceNum = maxWidth - tmp.length();
                for(int h = 0; h < spaceNum; h++){
                    tmp.append(' ');
                }
                res.add(tmp.toString());
            }
            else{
                wordLen++;
            }
        }
        return res;
    }
}
