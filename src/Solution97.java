public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Impossible case
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        // return bruteForce(s1, 0, s2, 0, "", s3);

        int[][] memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }

        return recursionWithMemoization(s1, 0, s2, 0, s3, 0, memo);
    }

    public boolean recursionWithMemoization(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        // memo[i][j] are initialized by -1
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }

        boolean ans = false;

        if (s3.charAt(k) == s1.charAt(i) &&
                recursionWithMemoization(s1, i + 1, s2, j, s3, k + 1, memo) ||
                s3.charAt(k) == s2.charAt(j) &&
                        recursionWithMemoization(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }

        memo[i][j] = ans ? 1 : 0;

        return ans;
    }

    public boolean bruteForce(String s1, int i, String s2, int j, String res, String s3) {
        // Finish if we have match and scan s1 and s2
        if (res.equals(s3) && i == s1.length() && j == s2.length()) {
            return true;
        }

        boolean ans = false;

        if (i < s1.length()) {
            // x|= 3 <- x = x | 3
            ans |= bruteForce(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        }
        if (j < s2.length()) {
            ans |= bruteForce(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        }

//        if (i == s1.length() && j == s2.length()) {
//            System.out.println(res);
//        }

        return ans;
    }

    public static void main(String[] args) {
        // | applies OR to booleans
//        boolean ans = false;
//        System.out.println(ans | true);
//        System.out.println(ans | false);
//        ans = true;
//        System.out.println(ans | true);
//        System.out.println(ans | false);

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution97 sol = new Solution97();
        boolean answer = sol.isInterleave(s1, s2, s3);
        System.out.println("Answer: " + answer);
    }
}
