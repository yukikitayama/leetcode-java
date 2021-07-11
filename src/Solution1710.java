public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int unitCount = 0;
        int remainingTruckSize = truckSize;

        while (remainingTruckSize > 0) {
            int maxUnitBoxIndex = findMaxUnitBox(boxTypes);

            if (maxUnitBoxIndex == -1) {
                break;
            }

            int boxCount = Math.min(remainingTruckSize, boxTypes[maxUnitBoxIndex][0]);

            unitCount += boxCount * boxTypes[maxUnitBoxIndex][1];
            remainingTruckSize -= boxCount;
            boxTypes[maxUnitBoxIndex][1] = -1;
        }
        return unitCount;
    }

    public int findMaxUnitBox(int[][] boxTypes) {
        int maxUnitBoxIndex = -1;
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][1] > maxUnits) {
                maxUnits = boxTypes[i][1];
                maxUnitBoxIndex = i;
            }
        }
        return maxUnitBoxIndex;
    }

    public static void main(String[] args) {
        Solution1710 sol = new Solution1710();
        int[][] boxTypes = {
                {1, 3}, {2, 2}, {3, 1}
        };
        int answer = sol.maximumUnits(boxTypes, 4);
        System.out.println("Answer: " + answer);
    }
}
