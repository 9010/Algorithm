package cn.com.self;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *     Only one letter can be changed at a time.
 *     Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *     Return 0 if there is no such transformation sequence.
 *     All words have the same length.
 *     All words contain only lowercase alphabetic characters.
 *     You may assume no duplicates in the word list.
 *     You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * 2019.9.4 zx
 * 看了discussion里的解释，算法是BFS，思想是将构建一个图形，其节点表示字符串，边缘连接仅相差1个字符的字符串
 * 然后我们从startWord节点应用BFS。如果我们找到endWord，返回bfs的级别计数
 * 但是可以通过使用HashSet和Queue减少不必要的空间，不需要构建邻接列表图
 */
public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] list = {"hot","dot","dog","lot","log","cog"};
        wordList = Arrays.asList(list);

        WordLadder tmp = new WordLadder();
        System.out.println(tmp.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;  //wordList中不存在endWord直接返回0

        HashSet<String> set = new HashSet<String>(wordList);  //set中存入整个wordList
        Queue<String> q = new LinkedList<String>();
        int length = 0;
        set.add(endWord);  //不知道为啥要加入endWord，个人认为不需要加，且不加也PASS了
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String w = q.poll();  //返回第一个元素并删除
                if (w.equals(endWord)) return length + 1;  //匹配到endWord，返回result
                wordMatch(w, set, q); //搜索下一个仅变化一个字母的单词
            }
            length++;
        }
        return 0;
    }

    /**
     * 找到w改变一个字母后，存在于set中的单词
     * @param w
     * @param set
     * @param q
     */
    public void wordMatch(String w, Set<String> set, Queue<String> q) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();  //String转数组方便后续操作，也可以转StringBuilder
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (word[i] == c) continue;
                word[i] = c;  //w改变一个字母
                String s = String.valueOf(word);
                if (set.contains(s)) {  //如果w改变一个字母，set中存在，则删除set中这个单词，存入q中
                    set.remove(s);
                    q.offer(s);
                }
            }
        }
    }
}
