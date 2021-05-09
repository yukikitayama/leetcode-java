public class Solution583 {
    public int minDistance(String word1, String word2) {

        // Why + 1
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];

        return word1.length() + word2.length() - 2 * lcsMemo(word1, word2, word1.length(), word2.length(), memo);
    }

    // Returns the length of the longest common sequence, lcs
    public int lcs(String s1, String s2, int m, int n) {

        // Either strings is empty string, no overlap, so return 0
        // In recursive call, when we reach the beginning of strings, we need to return there's no more characters to
        // compare to increment length, works as end of recursive call
        if (m == 0 || n == 0) {
            return 0;
        }

        System.out.println("s1.charAt(m - 1): " + s1.charAt(m - 1) + " s2.charAt(n - 1): " + s2.charAt(n - 1));

        // Current characters match, increment 1, go to next character in both strings
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }

        /* Current characters don't match, go to a next character of either strings, check both, return max because we
        want the longest length
         */
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }

    public int lcsMemo(String s1, String s2, int m, int n, int[][] memo) {

        if (m == 0 || n == 0) {
            return 0;
        }

        /* memo array is initialized with 0. If it's more than 0, we already made calculation, so avoid making a
        recursive call. Memoization.
         */
        if (memo[m][n] > 0) {
            return memo[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);
        }

        else
            memo[m][n] = Math.max(lcsMemo(s1, s2, m, n - 1, memo), lcsMemo(s1, s2, m - 1, n, memo));

        return memo[m][n];
    }
}
