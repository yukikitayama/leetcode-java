import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Initialize answer
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        // Edge case
        if (root == null) {
            return answer;
        }

        // FIFO queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        // LinkedList.add appends to the end
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            // While loop always starts with the new level iteration
            answer.add(new ArrayList<Integer>());

            // Get number of element at the current level
            int level_length = queue.size();

            /* At some point, queue contains nodes at both current level and next level. But this i in the for loop uses
            element only at current level. At the end of each for loop, nodes at the current level are all removed, and
            filled with the nodes at the next level
             */
            for (int i = 0; i < level_length; i++) {

                // LinkedList.remove removes from the beginning
                TreeNode node = queue.remove();

                // Add current node to the answer at the correct level
                // This throws error if node is null
                answer.get(level).add(node.val);

                // Add child nodes of the current level to the next level queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return answer;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
