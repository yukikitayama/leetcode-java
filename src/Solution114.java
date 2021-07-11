public class Solution114 {

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

    private TreeNode flattenTree(TreeNode node) {

        /*
        * Edge case when root is null. Input: root = [], Output: []
         */
        if (node == null) {
            return null;
        }

        /*
        * When we have a leaf node, return the node as is
        * */
        if (node.left == null && node.right == null) {
            return node;
        }

        // Recursively flatten left subtree
        TreeNode leftTail = this.flattenTree(node.left);

        // Recursively flatten right subtree
        TreeNode rightTail = this.flattenTree(node.right);

        if (leftTail != null) {
            // Make leftTail point to right subtree of the node, but now both leftTail and node point right subtree
            leftTail.right = node.right;
            // Insert left subtree between node and right subtree by making node right point to left subtree
            node.right = node.left;
            // In the above, both node left and right point to left subtree, so let node left point to nothing
            node.left = null;
        }

        // ?
        return rightTail == null ? leftTail : rightTail;
    }

    public void flatten(TreeNode root) {
        this.flattenTree(root);
    }
}
