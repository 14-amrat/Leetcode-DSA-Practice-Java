import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {

        int[] common = new int[26];

        // Count characters of the first word
        for (char c : words[0].toCharArray()) {
            common[c - 'a']++;
        }

        // Compare with every other word
        for (int i = 1; i < words.length; i++) {

            int[] current = new int[26];

            for (char c : words[i].toCharArray()) {
                current[c - 'a']++;
            }

            // Keep the minimum frequency
            for (int j = 0; j < 26; j++) {
                common[j] = Math.min(common[j], current[j]);
            }
        }

        // Build answer
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (common[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                common[i]--;
            }
        }

        return result;
    }
}