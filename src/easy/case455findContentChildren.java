package easy;

import java.util.Arrays;

/**
 * @author aviccii 2020/12/25
 * @Discrimination
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class case455findContentChildren {
    public static void main(String[] args) {
        int g[] = {1,2,3};
        int s[] = {1,1};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i = 0,j = 0;i<g.length&&j<s.length;i++,j++){
            if (g[i]<=s[i]) ans++;
            else {
                for (int k = j; k < s.length; k++) {
                    if (g[i]<=s[k]) {
                        ans++;
                        j=k;
                        break;
                    }
                }
            }
        }
        return ans;

    }

    /**
     * 官方题解
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }

}
