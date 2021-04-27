package randomStart;

import java.util.*;

/**
 * @author aviccii 2021/4/27
 * @Discrimination 给定一个 不含重复 单词的字符串数组 words ，编写一个程序，返回 words 中的所有 连接词 。
 *
 * 连接词 的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。
 *
 */
//************未解决****************
public class case472连接词 {
    class Trie {
        boolean end = false;
        Trie[] nexts = new Trie[26];
    }

    class Solution {
        Trie root = new Trie();
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            // 按字符串的长度进行排序
            Arrays.sort(words, new Comparator<String>(){
                @Override
                public int compare(String a, String b) {
                    int i = a.length(), j = b.length();
                    if (i == j)
                        return 0;
                    if (i > j)
                        return 1;
                    else
                        return -1;
                }
            });
            // System.out.println(Arrays.toString(words));
            List<String> ans = new ArrayList<>();
            for(String word: words) {
                if (word.length() == 0)
                    continue;
                if (search(word))
                    ans.add(word);
                else
                    insert(word);
            }
            return ans;
        }

        public boolean search(String word){
            Trie cur = root;
            int len = word.length();
            if (len == 0)
                return true;
            for(int i = 0, ch; i < len; ++i){
                ch = word.charAt(i) - 'a';
                if (cur.nexts[ch] == null)
                    return false;
                if (cur.nexts[ch].end) {
                    if (search(word.substring(i+1)))
                        return true;
                }
                cur = cur.nexts[ch];
            }
            return false;
        }

        public void insert(String word){
            Trie cur = root;
            for(int i = 0, len = word.length(), ch; i < len; ++i) {
                ch = word.charAt(i) - 'a';
                if (cur.nexts[ch] == null){
                    cur.nexts[ch] = new Trie();
                }
                cur = cur.nexts[ch];
            }
            cur.end = true;
        }
    }

}
