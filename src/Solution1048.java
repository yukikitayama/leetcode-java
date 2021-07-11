import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Solution1048 {
    public int longestStrChain(String[] words) {
        // Key: Last word in sequence, Value: Length of word sequence
        HashMap<String, Integer> memo = new HashMap<String, Integer>();

        // Set to find what words we need to perform DFS
        HashSet<String> wordsPresent = new HashSet<String>(Arrays.asList(words));
        // System.out.println("HashSet wordsPresent: " + wordsPresent);

        int ans = 0;

        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }

        return ans;
    }

    private int dfs(HashSet<String> words, HashMap<String, Integer> memo, String currentWord) {

        // To reduce recursive calls, we use values (sequence length) from memoization hashmap, if the current word was
        // seen in the previous dfs.
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }

        // Initial value for maximum sequence length
        int maxLength = 1;

        /* Delete one character from the current word, check if this new word is in the original words array, if present
        we can do dfs again to find the end.
         */
        StringBuilder sb = new StringBuilder(currentWord);
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();

            if (words.contains(newWord)) {
                // Increment sequence length
                int currentLength = 1 + dfs(words, memo, newWord);
                // Update maximum length
                maxLength = Math.max(maxLength, currentLength);
            }
            // We need to recover the original word, because we are required to delete a character one at a time
            sb.insert(i, currentWord.charAt(i));
        }

        // After we find the maximum sequence length from current word, we memoize it
        memo.put(currentWord, maxLength);

        return maxLength;
    }

    public static void main(String[] args) {
        Solution1048 sol = new Solution1048();
        String[] test = new String[]{"a","b","ba","bca","bda","bdca"};
        int answer = sol.longestStrChain(test);
        System.out.println("Answer: " + answer);
    }
}
