package cn.com.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 *
 * 2019.6.3 zx
 * 把内容相同的字符串分为一组，大概思路：
 *  每个字符串先做从小到大排序，如果map中不存在相同的字符串，则加入此字符串作为key，并加入key下的value中的list
 *  如果存在，则在add到相同的字符串key的value中的list
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"tea","and","ace","ad","eat","dans"};
        GroupAnagrams tmp = new GroupAnagrams();
        System.out.println(tmp.groupAnagrams(strs).toString());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            char[] sortword = strs[i].toCharArray();    //Turn word into char array and sort it
            Arrays.sort(sortword);
            String word = String.valueOf(sortword);

            if(!hmap.containsKey(word))             //if our sorted word isn't in hmap, add it
                hmap.put(word, new ArrayList<>());

            hmap.get(word).add(strs[i]);            //Always add word to they key's corresponding value
        }                                           //add by getting key's value list:  basically, list.add( word )

        return new ArrayList<>(hmap.values());
    }
}
