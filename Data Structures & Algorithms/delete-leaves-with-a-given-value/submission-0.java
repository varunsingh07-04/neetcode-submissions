/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        level(root,target);
        if(root.left==null && root.right==null && root.val==target) return null;
        return root;
    }
    int level(TreeNode root,int target){
        if(root==null){
            return 0;
        }
        int leftHeight = level(root.left,target);
        int rightHeight = level(root.right,target);
        if(leftHeight==1 && root.left.val==target){
            root.left=null;
            leftHeight--;
        }
        if(rightHeight==1 && root.right.val==target){
            root.right=null;
            rightHeight--;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }
}