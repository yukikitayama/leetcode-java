/*
816. Ambiguous Coordinates
https://leetcode.com/problems/ambiguous-coordinates/

Example 1:
Input: s = "(123)"
Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 */

import java.util.List;
import java.util.ArrayList;

public class Solution816 {
    public List<String> ambiguousCoordinates(String s) {

        // Initialize
        List<String> ans = new ArrayList();

        // Input s starts from (
        // String s starts from "(", so we need to start from index 1, which is the 1 of make(s, 1, i). To make the min
        // range to make a substring, int i needs to start from 2 to be make(s, 1, 2)
        for (int i = 2; i < s.length() - 1; i++) {

            // First in left side, we make integers and floating numbers
            for (String left : make(s, 1, i)) {

                // For each left, in right side, likewise, we make integers and floating numbers
                // To avoid overlapping, left make ends with i, but right make starts with i
                for (String right : make(s, i, s.length() - 1)) {

                    // Number format validation occurs in make methods, so we are safe to add any string in left list
                    // and right list. So we just simple add left and right here to the answer list
                    ans.add("(" + left + ", " + right + ")");
                }

            }
        }

        return ans;
    }

    /*
    * Separate s substring starting at i and ending at j - 1 into two substring at k
    * Insert . between left and right if possible
    * Join left and right into one string again
    * */
    public List<String> make(String s, int i, int j) {
        List<String> ans = new ArrayList();

        // k <=/< j - i checks if k is in the j-i range
        for (int k = 1; k <= j - i; k++) {
            String left = s.substring(i, i + k);
            String right = s.substring(i + k, j);

//            System.out.println("left: " + left + ", right: " + right);
//            System.out.println("!left.startsWith(0): " + !left.startsWith("0") +
//                    ", left.equals(0): " + left.equals("0"));

            /*
            * !left.startsWith("0") means we are making float starting non zero
            * left.equals("0") means we have single 0 at the left side. We can make float by 0.XXX (0 is left, XX is
            * right)
            * right.endsWith("0") means the number will be X.X0. You can't have ending 0 after decimal
            */
            if ((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
                String tmp = left + (k < j - i ? ".": "") + right;
                ans.add(tmp);

//                System.out.println("tmp: " + tmp);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
//        String test = "(012345)";
        String test = "(12345)";

        Solution816 sol = new Solution816();

        int i = 3;
        List<String> leftMakeOutput = sol.make(test, 1, i);
        for (String num : leftMakeOutput) {
            System.out.println(num);
        }
        System.out.println();
        List<String> rightMakeOutput = sol.make(test, i, test.length() - 1);
        for (String num : rightMakeOutput) {
            System.out.println(num);
        }

        System.out.println("Answer");
        List<String> answer = sol.ambiguousCoordinates(test);
        for (String ans : answer) {
            System.out.println(ans);
        }

//        System.out.println(
//                "test.substring(4, 4): " + test.substring(4, 4) + ", "
//                + test.substring(4, 4).getClass()
//                + ", length: " + test.substring(4, 4).length()
//        );
    }
}
