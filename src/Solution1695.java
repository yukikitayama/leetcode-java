import java.util.HashSet;

public class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int currentSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int start = 0;

        for (int end = start; end < nums.length; end++) {

            // When duplicate is found at end, we keep removing elements from the left until left element which is
            // duplicate of element at end is removed
            while (set.contains(nums[end])) {
                set.remove(nums[start]);
                currentSum -= nums[start];
                start++;
            }
            currentSum += nums[end];
            set.add(nums[end]);

            result = Math.max(result, currentSum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 6};
        Solution1695 sol = new Solution1695();
        int answer = sol.maximumUniqueSubarray(nums);
        System.out.println("Answer: " + answer);
    }
}
