import java.util.Arrays;

public class Solution1564 {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {

        // Preprocess the warehouse with non-increasing heights
        // Warehouse will be non-increasing by getting min value from the beginning and the previous values
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }

        Arrays.sort(boxes);

        // Initialize answer
        int ans = 0;

        // For loop starts from the biggest int and decrement, because we wanna compare warehouse from the end with the
        // boxes from the beginning
        for (int i = warehouse.length - 1; i >= 0; i--) {

            // If horizontally we still have space in warehouse to add the remaining boxes,
            // and if vertically a box height is equal to or less than warehouse height.
            // The first if needs to be the first, otherwise the second if condition throws index out of bound error.
            if (ans < boxes.length && boxes[ans] <= warehouse[i]) {
                ans ++;
            }
        }
        return ans;
    }
}
