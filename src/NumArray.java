public class NumArray {
    private int[] nums;
    private int[] b;
    private int len;

    public NumArray(int[] nums) {
        this.nums = nums;
        double l = Math.sqrt(nums.length);
        this.len = (int) Math.ceil(nums.length / l);
        b = new int[len];

        for (int i = 0; i < nums.length; i++) {
            b[i / len] += nums[i];
        }
    }

//    public void update(int index, int val) {
//        nums[index] = val;
//    }

    public void update(int index, int val) {
        int b_l = index / len;
        b[b_l] = b[b_l] - nums[index] + val;
        nums[index] = val;
    }

//    public int sumRange(int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            sum += nums[i];
//        }
//        return sum;
//    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int startBlock = left / len;
        int endBlock = right / len;

        if (startBlock == endBlock) {
            for (int k = left; k <= right; k++) {
                sum += nums[k];
            }
        }

        else {
            for (int k = left; k <= (startBlock + 1) * len - 1; k++) {
                sum += nums[k];
            }
            for (int k = startBlock + 1; k <= endBlock - 1; k++) {
                sum += b[k];
            }
            for (int k = endBlock * len; k <= right; k++) {
                sum += nums[k];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray obj = new NumArray(nums);
        int sum1 = obj.sumRange(0, 2);
        System.out.println("sumRange: " + sum1);
        obj.update(1, 2);
        int sum2 = obj.sumRange(0, 2);
        System.out.println("sumRange: " + sum2);
    }
}
