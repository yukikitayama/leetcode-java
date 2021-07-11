public class Solution462 {

    public int minMoves2(int[] nums) {
        long ans = Long.MAX_VALUE;

        // Find the min and max from the array. min is max because sequentially min in for loop
        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        for (int num : nums) {
            minval = Math.min(minval, num);
            maxval = Math.max(maxval, num);
        }

        // Try all the possible k by i
        for (int i = minval; i <= maxval; i++) {

            // Taking difference with each element gives us increment/decrement
            long sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - i);
            }

            // Minimum move is the answer
            ans = Math.min(ans, sum);
        }

        return (int) ans;
    }

    public int minMoves22(int[] nums) {
        long min = Integer.MAX_VALUE;

        for (int num : nums) {
            long sum = 0;
            for (int n : nums) {
                sum += Math.abs(n - num);
            }
            min = Math.min(min, sum);
        }
        return (int) min;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        Solution462 sol = new Solution462();
        int answer = sol.minMoves2(test);
        System.out.println("Answer: " + answer);
    }
}

/*
Input: nums = [1,2,3]
Output: 2
 */
