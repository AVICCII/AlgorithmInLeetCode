package easy;

import java.util.*;

/**
 * @author aviccii 2020/8/12
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 */
public class Case09numJewelsInStones {
    /**
     * 暴力解法：
     * <p>
     * 复杂度分析
     * 时间复杂度：O(J.length * S.length))O(J.length∗S.length))。
     * 空间复杂度：在 Python 实现中，空间复杂度为 O(1)O(1)。在 Java 实现中，空间复杂度为 O(J.length * S.length))O(J.length∗S.length))。
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    ans++;
                }
            }
        }
        return ans;

        /**
         * 使用hashSet
         *
         * 复杂度分析
         * 时间复杂度：O(J.length + S.length))O(J.length+S.length))。O(J.length}) 这部分来自于创建 J，O(S.length)O(S.length) 这部分来自于搜索 S。
         * 空间复杂度：O(J.length)O(J.length)。
         */
    }
        public int numJewelsInStones2(String J, String S) {
        Set<Character> set= new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        int ans=0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)){
                ans++;
            }
        }
        return ans;
    }
}
