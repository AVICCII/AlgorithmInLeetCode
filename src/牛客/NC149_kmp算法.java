package 牛客;

/**
 * @author aviccii 2021/7/12
 * @Discrimination
 */
public class NC149_kmp算法 {

    public int calcMatchValue(String subStr){
        int length = subStr.length();
        //前缀
        String prefixStr = subStr.substring(0,length - 1);
        //后缀
        String suffixStr = subStr.substring(1);

        while (prefixStr.length() > 0 && suffixStr.length() > 0){
            if (prefixStr.equals(suffixStr)) return prefixStr.length();
            if (prefixStr.length() == 1 && suffixStr.length() == 1) break;

            prefixStr = prefixStr.substring(0,prefixStr.length() - 1);
            suffixStr = suffixStr.substring(1);
        }
        return 0;
    }

    public int[] createPartialMatchTable(String pattern){
        int patternLen = pattern.length();
        int[] matchTable = new int[patternLen];

        int i = 0;
        int matchValue = 0;
        while (i < patternLen){
            if (i == 0) matchValue = 0;
            else matchValue = calcMatchValue(pattern.substring(0,i+1));

            matchTable[i] = matchValue;
            i++;
        }
        return matchTable;
    }

    public boolean kmp(String target, String pattern) {
        int[] partialMatchTable = createPartialMatchTable(pattern);

        char[] targetCharArr = target.toCharArray();
        char[] patternCharArr = pattern.toCharArray();
        int matchCharCounts = 0;//当前已经匹配的字符的个数

        int i = 0, j = 0, moveCounts = 0;
        while (i < targetCharArr.length) {

            //如果当前主串和子串的字符匹配上了 那么比较下一个字符是否匹配
            if (targetCharArr[i] == patternCharArr[j]) {
                matchCharCounts++;
                i++;
                j++;
            }
            //如果子串的第一个元素都不与主串的元素相等，那么就拿主串的下一个元素进行比较
            else if (j == 0) i++;
                //如果子串不是在第一个元素的位置而是在其他位置进行了失配，那么进行移位操作
            else {
                //移动位数=已匹配的字符数 - 对应的部分匹配值
                //对应匹配值 指的是最后一个字符的对应匹配值 j是失配的位置 所以这里是partialMatchTable[j-1]
                moveCounts = matchCharCounts - partialMatchTable[j - 1];
                j = j - moveCounts;//移动模式串 往前移moveCounts位
                matchCharCounts = matchCharCounts - moveCounts;//修改匹配的字符个数，就是减去移动过的位数
            }

            //匹配成功返回true
            if (j == patternCharArr.length) return true;

        }
        return false;
    }
}
