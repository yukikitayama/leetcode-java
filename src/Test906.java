public class Test906 {
    public static void main(String[] args) {

        System.out.println(Math.pow(11, 2));
        System.out.println(Math.pow(22, 2));

        Solution906 sol = new Solution906();

        long x = 484;
        System.out.println("x: " + x);
        long reversedX = sol.reverse(x);
        System.out.println("Reversed x: " + reversedX);

        String left = "4";
        String right = "1000";
        int ans = sol.superpalindromesInRange(left, right);
        System.out.println("Answer: " + ans);
    }
}
