package easy;

import java.util.Arrays;

/**
 * @author aviccii 2020/8/24
 * @Discrimination 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
    public class Case36repeatedSubstringPattern {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int i = 1; i * 2 <= n; ++i) {
                if (n % i == 0) {
                    boolean match = true;
                    for (int j = i; j < n; ++j) {
                        if (s.charAt(j) != s.charAt(j - i)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * KMP算法
         */
        public class Solution {
            public boolean repeatedSubstringPattern(String s) {
                return kmp(s + s, s);
            }

            public boolean kmp(String query, String pattern) {
                int n = query.length();
                int m = pattern.length();
                int[] fail = new int[m];
                Arrays.fill(fail, -1);
                for (int i = 1; i < m; ++i) {
                    int j = fail[i - 1];
                    while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                        j = fail[j];
                    }
                    if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                        fail[i] = j + 1;
                    }
                }//next域实现

                int match = -1;
                for (int i = 1; i < n - 1; ++i) {
                    while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                        match = fail[match];
                    }
                    if (pattern.charAt(match + 1) == query.charAt(i)) {
                        ++match;
                        if (match == m - 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }

