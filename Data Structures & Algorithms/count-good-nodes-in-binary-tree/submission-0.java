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
    int count=0;
    public int goodNodes(TreeNode root) {
        int max = root.val ;
        goodNode(root,max);
        return count;
    }
    void goodNode(TreeNode node,int max){
        if(node==null){
            return ;
        }
        if(node.val>=max){
            count++;
            max=node.val;
        }
        goodNode(node.left,max);
        goodNode(node.right,max);
    }
}
