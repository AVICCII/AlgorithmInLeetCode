package 牛客;

/**
 * @author aviccii 2021/6/3
 * @Discrimination
 */
public class 最长回文子串 {
    public int getLongestPalindrome(String A, int n) {
        //边界
        if (n < 2) return A.length();
        int maxLen = 0;  //最长回文串的长度
        for (int i = 0; i < n; ) {
            //base
            if (n - i <= maxLen / 2) break;

            int left = i;
            int right = i;

            while (right < n - 1 && A.charAt(right + 1) == A.charAt(right)) ++right;
            //考虑16行，如果重复则从重复的下一个字符开始循环,即i = right + 1
            i = right + 1;
            while (right < n - 1 && left > 0 && A.charAt(right + 1) == A.charAt(left - 1)) {
                ++right;
                --left;
            }
            if (right - left + 1 > maxLen) maxLen = right - left + 1;
        }
        return maxLen;
    }

    public int getzchwzc(String A, int n) {
        if (n < 2) return A.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            //base
            if (n - i <= ans / 2) break;

            int left = i;
            int right = i;
            //考虑重复
            while (right < n - 1 && A.charAt(right + 1) == A.charAt(right)) ++right;
            //从不重复的右侧开始，即for循环中的条件放在这里
            i = right + 1;
            while (right < n - 1 && left > 0 && A.charAt(right + 1) == A.charAt(left - 1)) {
                right++;
                left--;
            }
            if (right - left + 1 > ans) ans = right - left + 1;

        }
        return ans;
    }
}
