/**
 * Find the sum of all left leaves in a given binary tree.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
	return sumOfLeftLeaves(root, false);
    }
    
    private int sumOfLeftLeaves(TreeNode root, boolean isLeft){
        
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null && isLeft){
            return root.val;
        }else{
            return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
        }
        
    }
    
}