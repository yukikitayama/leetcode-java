import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            System.out.println(product);
        }
        List<List<String>> result = new ArrayList<>();
        int start = 0;
        int bsStart = 0;
        int n = products.length;
        String prefix = new String();

        for (char c : searchWord.toCharArray()) {
            // prefix get logger by one character each for loop
            prefix += c;
            // System.out.println(prefix);

            // Get the start index of word starting with prefix in the sorted products
            start = lowerBound(products, bsStart, prefix);

            result.add(new ArrayList<>());

            /*
            We want to suggests at most three products which is min(start + 3, products length)
             */
            for (int i = start; i < Math.min(start + 3, n); i++) {
                /*
                If a product name doesn't have enough characters of prefix, or a product name substring is not equal to
                prefix, it doesn't match search word
                 */
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                // Append a list to the end of result, and append a word to the list
                result.get(result.size() - 1).add(products[i]);
            }

            /*
            In each for loop, prefix gets one character longer than the existing prefix. Products which are not matched
            with prefix in the current iteration won't match again in the next iteration, so we remove them to consider
            by moving start index after them.
             */
            bsStart = Math.abs(start);
        }
        return result;
    }

    /*
    Compare each word in products with word (searching prefix) to do binary search. This binary search gives us the
    array index of the first word which matches the prefix.
     */
    int lowerBound(String[] products, int start, String word) {
        int i = start;
        int j = products.length;
        int mid;

        while (i < j) {
            mid = (i + j) / 2;

            if (products[mid].compareTo(word) >= 0) {
                j = mid;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        Solution1268 sol = new Solution1268();
        List<List<String>> answer = sol.suggestedProducts(products, searchWord);
        for (List<String> ans : answer) {
            System.out.println(ans);
        }
    }
}
