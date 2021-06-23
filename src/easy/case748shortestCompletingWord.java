package easy;

/**
 * @author aviccii 2021/6/23
 * @Discrimination
 */
public class case748shortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = count(licensePlate);
        String ans = "";
        for (String word : words) {
            if ((word.length() < ans.length() || ans.length() == 0) && dominates(count(word.toLowerCase()), count)){
             ans = word;
            }
        }
        return ans;
    }

    public boolean dominates(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] < count2[i]) return false;
        }
        return true;
    }

    public int[] count(String arr) {
        int[] ans = new int[26];
        for (char c : arr.toCharArray()) {
            int index = Character.toLowerCase(c) - 'a';
            if (0 <= index && index < 26) ans[index]++;
        }
        return ans;
    }
}
