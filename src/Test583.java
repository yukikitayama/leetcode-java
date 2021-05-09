public class Test583 {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        Solution583 sol = new Solution583();
//        int lcs = sol.lcs(word1, word2, word1.length(), word2.length());
//        System.out.println("lcs: " + lcs);

//        System.out.println("Test of int list initialization");
//        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
//        for (int[] i : memo) {
//            for (int j : i) {
//                System.out.println("i: " + i + " j: " + j);
//            }
//        }

        int ans = sol.minDistance(word1, word2);
        System.out.println("Answer: " + ans);
    }
}

/*
* word1 = "sea", word2 = "eat", m = 3, n = 3, lcs = 2
* m + n - 2 * lcs = 3 + 3 - 2 * 2 = 6 - 4
* Get all the number of characters, subtract the number of characters that we don't need to delete, and get the number
* of characters that we need to delete.
*
* lcs
* 'a' == 't': false, max(lcs(s1, s2, 3, 2), lcs(s1, s2, 2, 3))
*   m = 3, n = 2, 'a' == 'a': true, 1 + lcs(s1, s2, 3 - 1, 2 - 1) = 1 + cls(s1, s2, 2, 1)
*     m = 2, n = 1, 'e' == 'e': true, 1 + lcs(s1, s2, 2 - 1, 1 - 1) = 1 + cls(s1, s2, 1, 0)
*       m = 1, n = 0, 1 == 0 || 0 == 0: true, 0
*   so lcs(s1, s2, 3, 2) = 1 + (1 + 0) = 2
*   m = 2, n = 3, 'e' == 't': false, max(lcs(s1, s2, 2, 2), lcs(s1, s2, 1, 3))
*     m = 2, n = 2, 'e' == 'a': false, max(lcs(s1, s2, 2, 1), lcs(s1, s2, 1, 2))
*       m = 2, n = 1, 'e' == 'e': true, 1 + lcs(s1, s2, 1, 0)
*         m = 1, n = 0, 1 == 0 || 0 == 0: true, 0
*     so lcs(s1, s2, 2, 1) = 1 + 0 = 1
*       m = 1, n = 2, ...
*
* So recursively find the number of common characters, use max in the end, so we can have the length of longest common
* sequence.
* */
