
  //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

     TreeNode(int x) { val = x; }

 }

class Solution {
      private int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
         // Perform reverse in-order traversal
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
    
    // Helper method to print the tree for testing purposes
     public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}