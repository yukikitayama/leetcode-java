public class Solution906 {
    public int superpalindromesInRange(String left, String right) {
        // Long.valueOf converts String to long
        long L = Long.valueOf(left);
        long R = Long.valueOf(right);
        int MAGIC = 100000;
        int ans = 0;

        // k is a half

        // Count odd length number
        // When k = 1234, we want 1234321 (odd length digits)
        for (int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));

            // if sb is 1234, i starts from 3 -> 12343, 2 -> 123432, 1 -> 1234321
            for (int i = sb.length() - 2; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            // Get square
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalindrome(v)) {
                ans ++;
            }
        }

        // Count even length number
        // When k = 1234, we want 12344321 (even length digits)
        for (int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));

            // When sb = 1234, i = 3 -> 12344, i = 2 -> 123443, i = 1 -> 1234432, i = 0 -> 12344321
            for (int i = sb.length() - 1; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalindrome(v)) {
                ans ++;
            }
        }
        return ans;
    }

    public boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    public long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            System.out.println("10 * ans: " + (10 * ans) + ", x % 10: " + (x % 10) + ", x / 10: " + (x / 10));
            System.out.println("x / 10: " + (x / 10));
            System.out.println();
            // 10 * ans moves every digit to the left
            // x / 10 gets the all the digits except the rightmost
            // x % 10 gets the first digit, rightmost
            // if x / 10 is equal to 0 or less than 1, it means no more digits we can append to the reversed.
            // So we a digit from the rightmost, append it, move all the digits to the left, so we can get the reversed.
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }
}
/* P = R^2 is a super palindrome, P = 121, R = 11
If R is 11, we have even number of digits in R
left and right represent integers in the range [1, 10^18]. P < 10^18, R^2 < 10^18
R < (10^18)^1/2 = 10^9. R = k|k', where k' is k reversed. R has less than 10 digits, so k should have less than 5 digits
So K < 10^5 = MAGIC, magic constant
 */
