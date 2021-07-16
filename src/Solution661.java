import java.util.Arrays;


public class Solution661 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;

            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    public int binarySearch(int[] nums, int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;

            if (nums[mid] >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        Solution661 sol = new Solution661();
        int ans = sol.triangleNumber(nums);
        System.out.println("Answer: " + ans);
    }
}
