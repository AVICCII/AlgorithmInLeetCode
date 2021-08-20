package easy;

import java.util.Scanner;

/**
 * @author aviccii 2021/8/19
 * @Discrimination
 */
public class case345_反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while ( left < s.length() && !isVowels(chars[left])) {
                left++;
            }

            while ( right > 0 && !isVowels(chars[right]) ) {
                right--;
            }
            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public boolean isVowels(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }


    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    class Solution {
        public String reverseVowels(String s) {
            int n = s.length();
            char[] arr = s.toCharArray();
            int i = 0, j = n - 1;
            while (i < j) {
                while (i < n && !isVowel(arr[i])) {
                    ++i;
                }
                while (j > 0 && !isVowel(arr[j])) {
                    --j;
                }
                if (i < j) {
                    swap(arr, i, j);
                    ++i;
                    --j;
                }
            }
            return new String(arr);
        }

        public boolean isVowel(char ch) {
            return "aeiouAEIOU".indexOf(ch) >= 0;
        }

        public void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
    }
}
