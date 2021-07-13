public class Solution162 {
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }

        int mid = (l + r) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        Solution162 sol = new Solution162();
        int ans = sol.findPeakElement(nums);
        System.out.println("Answer: " + ans);
    }
}
