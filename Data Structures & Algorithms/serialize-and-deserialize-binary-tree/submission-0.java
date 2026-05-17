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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr==null){
                sb.append("null,");
                continue;
            }
            sb.append(Integer.toString(curr.val)+",");
            queue.offer(curr.left);
            queue.offer(curr.right);  
        }
        while(sb.length()>=5 && sb.substring(sb.length()-5).equals("null,")){
            sb.delete(sb.length()-5,sb.length());
        }
        if (sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                queue.offer(left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
