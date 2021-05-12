public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // By making +1 length array and initialized as 0 elements, we can have a case where we don't take any cards
        // either from front or rear
        // These are initialized with 0 in each element
        int[] front = new int[k + 1];
        int[] rear = new int[k + 1];

        // Get cumulative sum from front and rear
        for (int i = 0; i < k; i++) {
            front[i + 1] = cardPoints[i] + front[i];
            // n - i - 1 gets element from begind
            rear[i + 1] = cardPoints[n - i - 1] + rear[i];
        }

        // We won't have negative card points
        int maxScore = 0;

        for (int i = 0; i <= k; i++) {
            int currentScore = front[i] + rear[k - i];
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    public int maxScore2(int[] cardPoints, int k) {
        int front = 0;
        int rear = 0;
        int n = cardPoints.length;

        // Initialize front score
        for (int i = 0; i < k; i++) {
            front += cardPoints[i];
        }

        // Initialize max score with the initialized fron score
        int maxScore = front;

        // Increment rear score, decrement front score, get current score by sum, and update max score
        for (int i = k - 1; i >= 0; i--) {
            rear += cardPoints[n - (k - i)];
            front -= cardPoints[i];
            int currentScore = front + rear;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 79, 80, 1, 1, 1, 200, 1};
        int k = 3;

        Solution1423 sol = new Solution1423();
        int answer = sol.maxScore(test, k);
        System.out.println("Answer: " + answer);

//        int[] front = new int[k + 1];
//        for (int i : front) {
//            System.out.println(i);
//        }

        int[] front = new int[k + 1];
        int[] rear = new int[k + 1];
        int n = test.length;
        for (int i = 0; i < k; i++) {
            front[i + 1] = test[i] + front[i];
            rear[i + 1] = test[n - 1 - i] + rear[i];
        }
        for (int i = 0; i < front.length; i++) {
            System.out.println("front: " + front[i] + " " + rear[i]);
        }

        int answer2 = sol.maxScore2(test, k);
        System.out.println("Answer2: " + answer2);
    }
}
